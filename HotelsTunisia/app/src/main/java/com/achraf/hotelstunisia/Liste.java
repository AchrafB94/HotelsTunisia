package com.achraf.hotelstunisia;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.achraf.hotelstunisia.classes.CustomListAdapter;

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


public class Liste extends Activity{

    ListView list;

    ArrayList<String> nomhotels = new ArrayList<String>();

    ArrayList<String> imgid= new ArrayList<String>();

    ArrayList<Integer> stars = new ArrayList<Integer>();



    ArrayList<Integer> ids = new ArrayList<Integer>();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent goacceuil = new Intent(Liste.this, Acceuil.class);
                    startActivity(goacceuil);
                    return true;
                case R.id.liste:
                    return true;
                case R.id.recherche:
                    Intent gorech = new Intent(Liste.this, Recherche.class);
                    startActivity(gorech);
                    return true;
            }
            return false;
        }

    };

    private class JsonTask extends AsyncTask<String, String, String> {

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

                for(int i=0;i<data.length();i++){

                    JSONObject json_data = data.getJSONObject(i);

                    String name=json_data.getString("name");
                    String image=json_data.getString("image");
                    String etoiles=json_data.getString("etoiles");
                    String ident=json_data.getString("id");

                    int n = Integer.parseInt(ident);
                    int s = Integer.parseInt(etoiles);

                    nomhotels.add(name);
                    stars.add(s);
                    imgid.add(image);
                    ids.add(n);
                }

                CustomListAdapter adapter=new CustomListAdapter(Liste.this, nomhotels, imgid, stars);
                list=(ListView)findViewById(R.id.list);
                list.setAdapter(adapter);

                list.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {


                        Intent listtouch = null;
                        listtouch = new Intent(view.getContext(), HotelActivity.class);
                        listtouch.putExtra("id", ids.get(position));
                        startActivity(listtouch);

                    }
                });








            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        new JsonTask().execute("lien site web/webservice/liste.php");


    }
}