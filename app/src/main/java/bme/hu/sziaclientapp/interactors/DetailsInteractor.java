package bme.hu.sziaclientapp.interactors;

import java.util.Arrays;
import java.util.List;

import bme.hu.sziaclientapp.model.Flight;

/**
 * Created by Ákos on 2016.05.06..
 */
public class DetailsInteractor {

    public DetailsInteractor() {
    }

    public Flight getFlight(Long id) {
        Flight res = new Flight();
        res.setId(1L);

        return res;
    }
}
