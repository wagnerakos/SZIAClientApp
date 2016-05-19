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
import bme.hu.sziaclientapp.presenters.FavouritesPresenter;
import bme.hu.sziaclientapp.screens.FavouritesScreen;

public class FavouritesFragment extends Fragment implements FavouritesScreen {

    @Inject
    FavouritesPresenter favouritesPresenter;

    private OnListFragmentInteractionListener mListener;

    public FavouritesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SZIAClientAppApplication.injector.inject(this);
        favouritesPresenter.attachScreen(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new FlightAdapter(favouritesPresenter.getFavourites(), mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
