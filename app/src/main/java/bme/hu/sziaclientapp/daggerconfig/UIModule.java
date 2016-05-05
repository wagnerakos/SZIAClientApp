package bme.hu.sziaclientapp.daggerconfig;

import android.content.Context;

import javax.inject.Singleton;

import bme.hu.sziaclientapp.presenters.DetailsPresenter;
import bme.hu.sziaclientapp.presenters.FavouritesPresenter;
import bme.hu.sziaclientapp.presenters.FlightsPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ákos on 2016.05.05..
 */
@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public FlightsPresenter provideFlightsPresenter() {
        return new FlightsPresenter();
    }

    @Provides
    @Singleton
    public FavouritesPresenter provideFavouritesPresenter() {
        return new FavouritesPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }
}
