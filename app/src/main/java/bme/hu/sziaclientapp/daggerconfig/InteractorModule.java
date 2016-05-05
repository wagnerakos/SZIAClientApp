package bme.hu.sziaclientapp.daggerconfig;

import bme.hu.sziaclientapp.interactors.DetailsInteractor;
import bme.hu.sziaclientapp.interactors.FavouritesInteractor;
import bme.hu.sziaclientapp.interactors.FlightsInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ákos on 2016.05.06..
 */
@Module
public class InteractorModule {

    @Provides
    public FlightsInteractor provideFlightsInteractor() {
        return new FlightsInteractor();
    }

    @Provides
    public FavouritesInteractor provideFavouritesInteractor() {
        return new FavouritesInteractor();
    }

    @Provides
    public DetailsInteractor provideDetailsInteractor() {
        return new DetailsInteractor();
    }
}
