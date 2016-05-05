package bme.hu.sziaclientapp.presenters;

import java.util.List;

import javax.inject.Inject;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.interactors.FlightsInteractor;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.screens.FlightsScreen;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
public class FlightsPresenter extends Presenter<FlightsScreen> {

    @Inject
    FlightsInteractor flightsInteractor;

    @Override
    public void attachScreen(FlightsScreen screen) {
        super.attachScreen(screen);
        SZIAClientAppApplication.injector.inject(this);
    }

    public List<Flight> getFlightList() {
        return flightsInteractor.getFlights();
    }
}
