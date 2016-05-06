package bme.hu.sziaclientapp.network.mock;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import bme.hu.sziaclientapp.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2016. 05. 06..
 */
public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "flights")) {
            return FlightsMock.process(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "flights/")) {
            return FlightsMock.process(request);
        } else {
            return MockHelper.makeResponse(request, headers, 404, "Unknown");
        }
    }
}
