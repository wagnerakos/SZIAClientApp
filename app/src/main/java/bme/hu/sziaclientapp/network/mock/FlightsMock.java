package bme.hu.sziaclientapp.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.network.GsonHelper;
import bme.hu.sziaclientapp.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2016. 05. 06..
 */
public class FlightsMock {

    static List<Flight> flightList = new ArrayList<>();
    static boolean isInitialised = false;

    public static Flight testP1 = new Flight(1L, "London", "Zubony");
    public static Flight testP2 = new Flight(2L, "Párizs", "Zubony");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "flights") && request.method().equals("GET")) {
            if (!isInitialised) {
                flightList.add(testP1);
                flightList.add(testP2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(flightList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "flights/") && request.method().equals("GET")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            Long id = Long.valueOf(uri.getPath().substring(startOfData + 1));
            responseString = GsonHelper.getGson().toJson(new Flight(id, "a", "b"));
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        flightList.clear();
        isInitialised = false;
    }
}
