package bme.hu.sziaclientapp.interactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bme.hu.sziaclientapp.model.Flight;

/**
 * Created by Ákos on 2016.05.06..
 */
public class FavouritesInteractor {

    public FavouritesInteractor() {}

    public List<Flight> getFavourites() {
        List<Flight> res = new ArrayList<>();
        Flight a = new Flight();
        a.setId(2L);
        res.add(a);

        return res;
    }
}
