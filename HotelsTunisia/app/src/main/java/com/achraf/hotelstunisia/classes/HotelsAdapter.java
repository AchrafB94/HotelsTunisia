package com.achraf.hotelstunisia.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.achraf.hotelstunisia.R;
import com.achraf.hotelstunisia.classes.Hotel;

public class HotelsAdapter extends BaseAdapter {

    private final Context mContext;
    private final Hotel[] hotels;

    // 1
    public HotelsAdapter(Context context, Hotel[] hotels) {
        this.mContext = context;
        this.hotels = hotels;
    }

    // 2
    @Override
    public int getCount() {
        return hotels.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final Hotel hotel = hotels[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_hotel, null);
        }

        // 3
        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_hotel_name);
        final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_ville);

        // 4
        imageView.setImageResource(hotel.getImageResource());
        nameTextView.setText(mContext.getString(hotel.getName()));
        authorTextView.setText(mContext.getString(hotel.getVille()));

        return convertView;
    }

}