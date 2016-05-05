package bme.hu.sziaclientapp.interactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.model.Flight;

/**
 * Created by Ákos on 2016.05.05..
 */
public class FlightsInteractor {

    public FlightsInteractor() {}

    public List<Flight> getFlights() {
        List<Flight> res = new ArrayList<>();
        Flight a = new Flight();
        a.setId(1L);
        res.add(a);

        Flight b = new Flight();
        a.setId(2L);
        res.add(a);

        return res;
    }
}
