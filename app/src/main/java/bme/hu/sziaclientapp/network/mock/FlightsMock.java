package bme.hu.sziaclientapp.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    public static List<Flight> flightList = Arrays.asList(
            new Flight(1L, "Zubony", "London", new Date(1463892780850L), "24-50", 0, "Beszállás a 10B kapunál hamarosan kezdődik."),
            new Flight(2L, "Zubony", "Párizs", new Date(1463992780850L), "24-50", 0, ""),
            new Flight(3L, "Zubony", "Bukarest", new Date(1473692780850L), "24-50", 0, ""),
            new Flight(4L, "Zubony", "Berlin", new Date(1475692780850L), "24-50", 100, "Műszaki okok miatt a járat késéssel indul."),
            new Flight(5L, "Zubony", "Reykjavík", new Date(1477692780850L), "24-50", 0, ""),
            new Flight(6L, "Zubony", "Koppenhága", new Date(1478692780850L), "24-50", 20, ""),
            new Flight(7L, "Zubony", "Stockholm", new Date(1481692780850L), "24-50", 0, ""),
            new Flight(8L, "Zubony", "Amszterdam", new Date(1483692780850L), "24-50", 0, ""),
            new Flight(9L, "Zubony", "Madrid", new Date(1484692780850L), "24-50", 0, ""),
            new Flight(10L, "Zubony", "Kairó", new Date(1488692780850L), "24-50", 0, "")
    );

    private static Flight getById(Long id) {
        for (Flight f : flightList) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "flights") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(flightList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "flights/") && request.method().equals("GET")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            Long id = Long.valueOf(uri.getPath().substring(startOfData + 1));
            responseString = GsonHelper.getGson().toJson(getById(id));
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }
}
