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

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> itemname;
    private final ArrayList<String> imgid;
    private final ArrayList<Integer> stars;

    public CustomListAdapter(Activity context, ArrayList<String> itemname, ArrayList<String> imgid, ArrayList<Integer> stars) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.stars=stars;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap resultat) {
            bmImage.setImageBitmap(resultat);
        }
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        RatingBar ratingBar2 = (RatingBar) rowView.findViewById(R.id.starsbar);



        txtTitle.setText(itemname.get(position));
        new DownloadImageTask((ImageView) rowView.findViewById(R.id.icon)).execute(imgid.get(position));


        ratingBar2.setMax(5);
        ratingBar2.setRating(stars.get(position));
        return rowView;

    };
}