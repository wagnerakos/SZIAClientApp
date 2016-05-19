package bme.hu.sziaclientapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import bme.hu.sziaclientapp.R;
import bme.hu.sziaclientapp.adapters.FlightAdapter;
import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.interfaces.OnListFragmentInteractionListener;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.presenters.FlightsPresenter;
import bme.hu.sziaclientapp.screens.FlightsScreen;

public class FlightsFragment extends Fragment implements FlightsScreen {

    @Inject
    FlightsPresenter flightsPresenter;

    private OnListFragmentInteractionListener mListener;

    public FlightsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SZIAClientAppApplication.injector.inject(this);
        flightsPresenter.attachScreen(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flight_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new FlightAdapter(flightsPresenter.getFlightList(), mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()  + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
