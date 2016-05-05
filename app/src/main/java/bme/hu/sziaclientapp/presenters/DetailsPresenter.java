package bme.hu.sziaclientapp.presenters;

import javax.inject.Inject;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.interactors.DetailsInteractor;
import bme.hu.sziaclientapp.interactors.FavouritesInteractor;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.screens.DetailsScreen;
import bme.hu.sziaclientapp.screens.FavouritesScreen;

/**
 * Created by Ákos on 2016.05.06..
 */
public class DetailsPresenter extends Presenter<DetailsScreen> {

    @Inject
    DetailsInteractor detailsInteractor;

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        SZIAClientAppApplication.injector.inject(this);
    }

    public Flight getFlight(Long id) {
        return detailsInteractor.getFlight(id);
    }
}
