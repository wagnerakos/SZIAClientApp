package bme.hu.sziaclientapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bme.hu.sziaclientapp.R;
import bme.hu.sziaclientapp.interfaces.OnListFragmentInteractionListener;
import bme.hu.sziaclientapp.model.Flight;

import java.text.SimpleDateFormat;
import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder> {

    private final List<Flight> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FlightAdapter(List<Flight> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_flight, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleTextView.setText(holder.mItem.getLeavingFrom() + " - " + holder.mItem.getDestination());
        holder.mSubtitleTextView.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(holder.mItem.getDepartureTime()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleTextView;
        public final TextView mSubtitleTextView;
        public Flight mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleTextView = (TextView) view.findViewById(R.id.row_template_title);
            mSubtitleTextView = (TextView) view.findViewById(R.id.row_template_subtitle);
        }
    }
}
