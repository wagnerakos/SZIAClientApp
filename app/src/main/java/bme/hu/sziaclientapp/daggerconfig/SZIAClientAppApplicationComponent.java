package bme.hu.sziaclientapp.daggerconfig;

import javax.inject.Singleton;

import bme.hu.sziaclientapp.fragments.DetailsFragment;
import bme.hu.sziaclientapp.fragments.FavouritesFragment;
import bme.hu.sziaclientapp.fragments.FlightsFragment;
import bme.hu.sziaclientapp.presenters.DetailsPresenter;
import bme.hu.sziaclientapp.presenters.FavouritesPresenter;
import bme.hu.sziaclientapp.presenters.FlightsPresenter;
import dagger.Component;

/**
 * Created by Ákos on 2016.05.05..
 */
@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})
public interface SZIAClientAppApplicationComponent {
    void inject(FlightsFragment o);
    void inject(FavouritesFragment o);
    void inject(DetailsFragment o);

    void inject(FlightsPresenter o);
    void inject(FavouritesPresenter o);
    void inject(DetailsPresenter o);
}
