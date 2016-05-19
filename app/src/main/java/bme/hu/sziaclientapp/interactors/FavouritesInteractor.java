package bme.hu.sziaclientapp.interactors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.fragments.MainActivity;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.network.FlightsApi;

/**
 * Created by Ákos on 2016.05.06..
 */
public class FavouritesInteractor {

    @Inject
    FlightsApi flightsApi;

    public FavouritesInteractor() {
        SZIAClientAppApplication.injector.inject(this);
    }

    public List<Flight> getFavourites() {
        List<Flight> res = new ArrayList<>();
        Set<String> favouriteIds = MainActivity.sharedPreferences.getStringSet(MainActivity.SP_FAVOURITES_KEY, new HashSet<String>());
        try {
            for (Flight flight : flightsApi.flightsGet().execute().body()) {
                if (favouriteIds.contains(flight.getId().toString())) {
                    res.add(flight);
                }
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        return res;
    }
}
