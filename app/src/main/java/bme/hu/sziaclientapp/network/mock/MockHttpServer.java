package bme.hu.sziaclientapp.network.mock;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2016. 05. 06..
 */
public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
