package com.achraf.hotelstunisia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.achraf.hotelstunisia.classes.CommentaryAdapter;
import com.achraf.hotelstunisia.classes.Hotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.view.View.GONE;


public class HotelActivity extends AppCompatActivity  {

    private Toolbar titre;
    private FloatingActionButton gmap;
    private RatingBar etoiles;
    private TextView description,ville,adresse,numero;
    private LinearLayout wifi,air,bar,pool,breakfast,parking,restaurent,child,spa,pets,roomservice,laundry,gym,beach,wheel,golf,smoking;
    private ListView list2;
    private int id;
    ArrayList<String> usernames = new ArrayList<String>();
    ArrayList<String> reviewtexts = new ArrayList<String>();
    ArrayList<String> dates = new ArrayList<String>();
    ArrayList<Integer> ratings = new ArrayList<Integer>();

    private Button button1,button2;

    NestedScrollView nsv;


    private TextView reviewuser,reviewtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        nsv = (NestedScrollView) findViewById(R.id.nestedScrollView);
        gmap = (FloatingActionButton) findViewById(R.id.fab);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        id = getIntent().getExtras().getInt("id");

        String ident = String.valueOf(id);
        titre = (Toolbar) findViewById(R.id.titre);
        adresse = (TextView) findViewById(R.id.t1);
        ville = (TextView) findViewById(R.id.t2);
        numero = (TextView) findViewById(R.id.t3);
        etoiles = (RatingBar)  findViewById(R.id.ratingBar);
        etoiles.setMax(5);
        description = (TextView) findViewById(R.id.desc);
        wifi = (LinearLayout) findViewById(R.id.wifi);parking = (LinearLayout) findViewById(R.id.parking);pets = (LinearLayout) findViewById(R.id.pets);
        air = (LinearLayout) findViewById(R.id.air);restaurent = (LinearLayout) findViewById(R.id.restaurent);roomservice = (LinearLayout) findViewById(R.id.room);
        bar = (LinearLayout) findViewById(R.id.bar);child = (LinearLayout) findViewById(R.id.child);laundry = (LinearLayout) findViewById(R.id.laundry);
        pool = (LinearLayout) findViewById(R.id.pool);spa = (LinearLayout) findViewById(R.id.spa);gym = (LinearLayout) findViewById(R.id.gym);
        breakfast = (LinearLayout) findViewById(R.id.breakfast);smoking = (LinearLayout) findViewById(R.id.smoking);golf = (LinearLayout) findViewById(R.id.golf);
        beach = (LinearLayout) findViewById(R.id.beach);wheel = (LinearLayout) findViewById(R.id.wheel);

        new JsonTaskHotel().execute("lien du site web/webserivce/select.php?id="+ident);
        new JsonTaskReviews().execute("lien du site web/webserivce/selectreviews.php?id="+ident);




    }

    private class JsonTaskHotel extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();



            nsv.setVisibility(GONE);
            gmap.setVisibility(GONE);

        }
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;


            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);



            try {
                JSONArray data = new JSONArray(result);

                int s = data.getJSONObject(0).getInt("etoiles");
                String name = data.getJSONObject(0).getString("name");
                String desc = data.getJSONObject(0).getString("description");
                String adr = data.getJSONObject(0).getString("adresse");
                String gouv = data.getJSONObject(0).getString("gouvernorat");
                final String url = data.getJSONObject(0).getString("site");
                String phone = data.getJSONObject(0).getString("num");
                String Simage = data.getJSONObject(0).getString("image");
                String Simage2 = data.getJSONObject(0).getString("image2");
                String Simage3 = data.getJSONObject(0).getString("image3");
                String swifi = data.getJSONObject(0).getString("wifi");
                String sair = data.getJSONObject(0).getString("air");
                String sbar = data.getJSONObject(0).getString("bar");
                String spool = data.getJSONObject(0).getString("pool");
                String sbreakfast = data.getJSONObject(0).getString("breakfast");
                String sparking = data.getJSONObject(0).getString("parking");
                String srestaurent = data.getJSONObject(0).getString("restaurent");
                String sspa = data.getJSONObject(0).getString("spa");
                String spets = data.getJSONObject(0).getString("pets");
                String sgym = data.getJSONObject(0).getString("gym");
                String slaundry = data.getJSONObject(0).getString("laundry");
                String sroomservice = data.getJSONObject(0).getString("roomservice");
                String schild = data.getJSONObject(0).getString("child");
                String ssmoking = data.getJSONObject(0).getString("smoking");
                String sbeach = data.getJSONObject(0).getString("beach");
                String sgolf = data.getJSONObject(0).getString("golf");
                String swheel = data.getJSONObject(0).getString("wheel");

                etoiles.setRating(s);
                titre.setTitle(name);
                description.setText(desc);
                adresse.setText("Adresse: "+adr);
                ville.setText("Ville: "+gouv);
                numero.setText("Numero de telephone: +216 "+phone);
                final Double x = data.getJSONObject(0).getDouble("maps_x");
                final Double y = data.getJSONObject(0).getDouble("maps_y");



                new DownloadImageTask((ImageView) findViewById(R.id.image)).execute(Simage);
                new DownloadImageTask((ImageView) findViewById(R.id.image2)).execute(Simage2);
                new DownloadImageTask((ImageView) findViewById(R.id.image3)).execute(Simage3);



                nsv.setVisibility(View.VISIBLE);
                gmap.setVisibility(View.VISIBLE);

                if (swifi.equals("1")) wifi.setVisibility(View.VISIBLE);
                if (sair.equals("1")) air.setVisibility(View.VISIBLE);
                if (sbar.equals("1")) bar.setVisibility(View.VISIBLE);
                if (spool.equals("1")) pool.setVisibility(View.VISIBLE);
                if (sbreakfast.equals("1")) breakfast.setVisibility(View.VISIBLE);
                if (sparking.equals("1")) parking.setVisibility(View.VISIBLE);
                if (srestaurent.equals("1")) restaurent.setVisibility(View.VISIBLE);
                if (sspa.equals("1")) spa.setVisibility(View.VISIBLE);
                if (spets.equals("1")) pets.setVisibility(View.VISIBLE);
                if (sgym.equals("1")) gym.setVisibility(View.VISIBLE);
                if (slaundry.equals("1")) laundry.setVisibility(View.VISIBLE);
                if (sroomservice.equals("1")) roomservice.setVisibility(View.VISIBLE);
                if (schild.equals("1")) child.setVisibility(View.VISIBLE);
                if (ssmoking.equals("1")) smoking.setVisibility(View.VISIBLE);
                if (sbeach.equals("1")) beach.setVisibility(View.VISIBLE);
                if (sgolf.equals("1")) golf.setVisibility(View.VISIBLE);
                if (swheel.equals("1")) wheel.setVisibility(View.VISIBLE);





                gmap.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent gomap = null;
                        gomap = new Intent(HotelActivity.this, MapsActivity.class);
                        gomap.putExtra("x",x);
                        gomap.putExtra("y",y);
                        startActivity(gomap);
                    }
                });


                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    }
                });


                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Intent i2 = new Intent(HotelActivity.this, CommentActivity.class);
                        i2.putExtra("id",id);

                        startActivity(i2);

                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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


    private class JsonTaskReviews extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);

                }
                return buffer.toString();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);


            try {
                JSONArray data = new JSONArray(result);


                for(int j=0;j<data.length();j++){

                    JSONObject json_data = data.getJSONObject(j);


                    String user=json_data.getString("user");
                    String text=json_data.getString("text");
                    String date=json_data.getString("date");
                    int njoom = json_data.getInt("stars");

                    usernames.add(user);
                    reviewtexts.add(text);
                    dates.add(date);
                    ratings.add(njoom);

                }

                CommentaryAdapter adapter=new CommentaryAdapter(HotelActivity.this, usernames, reviewtexts, dates,ratings);

                list2=(ListView)findViewById(R.id.list2);
                list2.setAdapter(adapter);




            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



}