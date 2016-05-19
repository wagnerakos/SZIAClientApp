package bme.hu.sziaclientapp.interactors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.network.FlightsApi;

/**
 * Created by Ákos on 2016.05.05..
 */
public class FlightsInteractor {

    @Inject
    FlightsApi flightsApi;

    public FlightsInteractor() {
        SZIAClientAppApplication.injector.inject(this);
    }

    public List<Flight> getFlights() {
        List<Flight> res = new ArrayList<>();
        try {
            res = flightsApi.flightsGet().execute().body();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
