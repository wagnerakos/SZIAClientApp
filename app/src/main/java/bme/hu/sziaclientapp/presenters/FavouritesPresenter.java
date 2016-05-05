package bme.hu.sziaclientapp.presenters;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.interactors.FavouritesInteractor;
import bme.hu.sziaclientapp.interactors.FlightsInteractor;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.screens.FavouritesScreen;
import bme.hu.sziaclientapp.screens.FlightsScreen;

/**
 * Created by Ákos on 2016.05.06..
 */
public class FavouritesPresenter extends Presenter<FavouritesScreen> {

    @Inject
    FavouritesInteractor favouritesInteractor;

    @Override
    public void attachScreen(FavouritesScreen screen) {
        super.attachScreen(screen);
        SZIAClientAppApplication.injector.inject(this);
    }

    public List<Flight> getFlights() {
        return favouritesInteractor.getFavourites();
    }
}
