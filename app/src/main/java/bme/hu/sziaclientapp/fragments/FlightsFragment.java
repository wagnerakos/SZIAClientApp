package bme.hu.sziaclientapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import bme.hu.sziaclientapp.R;
import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.presenters.FlightsPresenter;
import bme.hu.sziaclientapp.screens.FlightsScreen;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlightsFragment extends Fragment implements FlightsScreen {

    @Inject
    FlightsPresenter flightsPresenter;

    public FlightsFragment() {
        SZIAClientAppApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        flightsPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        flightsPresenter.detachScreen();
        super.onDetach();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flights, container, false);
    }
}
