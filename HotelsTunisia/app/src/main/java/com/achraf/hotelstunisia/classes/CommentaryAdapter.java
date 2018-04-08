package com.achraf.hotelstunisia.classes;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.achraf.hotelstunisia.R;

import java.io.InputStream;
import java.util.ArrayList;

public class CommentaryAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> usernames;
    private final ArrayList<String> reviewtexts;
    private final ArrayList<String> dates;
    private final ArrayList<Integer> stars;

    public CommentaryAdapter(Activity context, ArrayList<String> usernames, ArrayList<String> reviewtexts, ArrayList<String> dates,ArrayList<Integer> stars ) {
        super(context, R.layout.commentary, usernames);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.usernames=usernames;
        this.reviewtexts=reviewtexts;
        this.dates=dates;
        this.stars=stars;
    }



    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.commentary, null,true);

        TextView username = (TextView) rowView.findViewById(R.id.user);
        TextView reviewtext = (TextView) rowView.findViewById(R.id.comment);
        TextView date = (TextView) rowView.findViewById(R.id.date);
        RatingBar ratingBar = (RatingBar) rowView.findViewById(R.id.starsrev);


        username.setText(usernames.get(position));
        reviewtext.setText(reviewtexts.get(position));
        date.setText(dates.get(position));



        ratingBar.setMax(5);
        ratingBar.setRating(stars.get(position));

        return rowView;

    };
}