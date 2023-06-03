package com.study.dmprojectnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    Context mContext;
    List<Destination> mDestinations;

    int check = 0;
    SpinnerAdapter spinnerAdapter;
    ArrayList<SpinnerLayout> spinnerLayoutsList;
    ArrayList<String> places;

    public DestinationAdapter(Context mContext, List<Destination> mDestinations, ArrayList<String> places) {
        this.mContext = mContext;
        this.mDestinations = mDestinations;
        this.places = places;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_destination, parent, false);

        return new DestinationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = position;
        Destination destination = mDestinations.get(position);
        holder.destinationItemTitle.setText(destination.getTitle());


        spinnerLayoutsList = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            spinnerLayoutsList.add(new SpinnerLayout(R.drawable.ic_destination_flag, places.get(i)));
        }
        spinnerAdapter = new SpinnerAdapter(mContext, spinnerLayoutsList);
        holder.destinationItemSpinner.setAdapter(spinnerAdapter);

        holder.destinationItemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    MainActivity.spinnerValues[pos + 1] = i - 1;
                } else {
                    MainActivity.spinnerValues[pos + 1] = -1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDestinations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView destinationItemTitle;
        Spinner destinationItemSpinner;

        int iconId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationItemTitle = itemView.findViewById(R.id.destination_item_title);
            destinationItemSpinner = itemView.findViewById(R.id.destination_item_spinner);

        }
    }
}
