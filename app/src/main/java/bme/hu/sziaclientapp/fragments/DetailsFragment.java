package bme.hu.sziaclientapp.fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import bme.hu.sziaclientapp.R;
import bme.hu.sziaclientapp.daggerconfig.SZIAClientAppApplication;
import bme.hu.sziaclientapp.model.Flight;
import bme.hu.sziaclientapp.presenters.DetailsPresenter;
import bme.hu.sziaclientapp.screens.DetailsScreen;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

    private Flight flight;

    private ImageButton addFavouriteBtn;

    Drawable emptyStar;
    Drawable filledStar;

    public DetailsFragment() {
    }

    public static DetailsFragment newInstance(Long flightId) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putLong("flightId", flightId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SZIAClientAppApplication.injector.inject(this);
        detailsPresenter.attachScreen(this);

        Bundle args = getArguments();
        Long flightId = args.getLong("flightId");

        this.flight = detailsPresenter.getFlight(flightId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        TextView leavingFromTV = (TextView) view.findViewById(R.id.leaving_from);
        leavingFromTV.setText(flight.getLeavingFrom());
        TextView destinationTV = (TextView) view.findViewById(R.id.destination);
        destinationTV.setText(flight.getDestination());
        TextView departureTimeTV = (TextView) view.findViewById(R.id.departure_time);
        departureTimeTV.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(flight.getDepartureTime()));
        TextView checkInDeckTV = (TextView) view.findViewById(R.id.check_in_deck);
        checkInDeckTV.setText(flight.getCheckInDeck());
        TextView delayTV = (TextView) view.findViewById(R.id.delay);
        delayTV.setText(String.valueOf(flight.getDelayInMinute()) + " perc");
        TextView commentTV = (TextView) view.findViewById(R.id.comment);
        commentTV.setText(flight.getComment());

        addFavouriteBtn = (ImageButton) view.findViewById(R.id.add_favourite_button);

        addFavouriteBtn.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                addFavouriteBtn.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                addFavouriteBtn.getHeight();

                Drawable emptyStarOrig = ResourcesCompat.getDrawable(getResources(), R.drawable.star_empty, null);
                Bitmap bitmap = ((BitmapDrawable) emptyStarOrig).getBitmap();
                emptyStar = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, addFavouriteBtn.getWidth(), addFavouriteBtn.getHeight(), true));

                Drawable filledStarOrig = ResourcesCompat.getDrawable(getResources(), R.drawable.star_filled, null);
                bitmap = ((BitmapDrawable) filledStarOrig).getBitmap();
                filledStar = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, addFavouriteBtn.getWidth(), addFavouriteBtn.getHeight(), true));

                if (MainActivity.sharedPreferences.getStringSet(MainActivity.SP_FAVOURITES_KEY, new HashSet<String>()).contains(flight.getId().toString())) {
                    addFavouriteBtn.setImageDrawable(emptyStar);
                } else {
                    addFavouriteBtn.setImageDrawable(filledStar);
                }
            }
        });


        addFavouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<String> favouriteIds = MainActivity.sharedPreferences.getStringSet(MainActivity.SP_FAVOURITES_KEY, new HashSet<String>());
                if (favouriteIds.contains(flight.getId().toString())) {
                    addFavouriteBtn.setImageDrawable(filledStar);
                    favouriteIds.remove(flight.getId().toString());
                    MainActivity.sharedPreferences.edit().putStringSet(MainActivity.SP_FAVOURITES_KEY, favouriteIds).apply();
                } else {
                    addFavouriteBtn.setImageDrawable(emptyStar);
                    favouriteIds.add(flight.getId().toString());
                    MainActivity.sharedPreferences.edit().putStringSet(MainActivity.SP_FAVOURITES_KEY, favouriteIds).apply();
                }
            }
        });

        return view;
    }

}
