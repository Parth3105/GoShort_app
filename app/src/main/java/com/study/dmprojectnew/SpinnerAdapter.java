package com.study.dmprojectnew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<SpinnerLayout> places;

    SpinnerAdapter(Context context, ArrayList<SpinnerLayout> places) {
        this.context = context;
        this.places = places;
    }

    @Override
    public int getCount() {
        if (places != null) {
            return places.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView = LayoutInflater.from(context).inflate(R.layout.spinner_dropdown_layout, viewGroup, false);

        TextView textView = customView.findViewById(R.id.text);
        ImageView marker_icon = customView.findViewById(R.id.marker_icon);

        String name = places.get(i).name;

        textView.setText(name);
        marker_icon.setImageResource(places.get(i).img);

        return customView;
    }
}