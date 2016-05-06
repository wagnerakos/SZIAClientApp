package bme.hu.sziaclientapp.interactors;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.network.FlightsApi;

/**
 * Created by Ákos on 2016.05.06..
 */
public class DetailsInteractor {

    @Inject
    FlightsApi flightsApi;

    public DetailsInteractor() {
        SZIAClientAppApplication.injector.inject(this);
    }

    public Flight getFlight(Long id) {
        return null;
    }
}
