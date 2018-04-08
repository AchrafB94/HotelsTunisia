package com.achraf.hotelstunisia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.achraf.hotelstunisia.classes.CustomListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class CommentActivity extends AppCompatActivity {

    Button OK;
    EditText cnom,comm;
    RatingBar reviewbar;

    private  int idhotel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        OK = (Button) findViewById(R.id.ok);
        cnom = (EditText) findViewById(R.id.cnom);
        comm = (EditText) findViewById(R.id.comm);
        cnom.setSingleLine(); comm.setSingleLine();
        reviewbar = (RatingBar) findViewById(R.id.reviewBar);
        idhotel = getIntent().getExtras().getInt("id");


        OK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String commentaire = comm.getText().toString();
                final String nom = cnom.getText().toString();
                final int r = reviewbar.getNumStars();

                final String njoom =  String.valueOf(r);
                Date currentTime = Calendar.getInstance().getTime();
                final String date = currentTime.toString();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream os = null;
                        InputStream is = null;
                        HttpURLConnection conn = null;
                        try {
                            //constants
                            URL url = new URL("lien du site web/webserivce/commentaire.php");
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("commentaire", commentaire);
                            jsonObject.put("nom", nom);
                            jsonObject.put("njoom", r);
                            jsonObject.put("date", date);
                            jsonObject.put("idhotel", idhotel);
                            String message = jsonObject.toString();

                            conn = (HttpURLConnection) url.openConnection();
                            conn.setReadTimeout( 10000 /*milliseconds*/ );
                            conn.setConnectTimeout( 15000 /* milliseconds */ );
                            conn.setRequestMethod("POST");
                            conn.setDoInput(true);
                            conn.setDoOutput(true);
                            conn.setFixedLengthStreamingMode(message.getBytes().length);


                            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

                            //open
                            conn.connect();

                            //setup send
                            os = new BufferedOutputStream(conn.getOutputStream());
                            os.write(message.getBytes());
                            //clean up
                            os.flush();


                            is = conn.getInputStream();

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } finally {
                            //clean up
                            try {
                                os.close();
                                is.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            conn.disconnect();
                        }
                    }
                }).start();





                Toast.makeText( CommentActivity.this, "Votre commentaire à ete ajouté.", Toast.LENGTH_LONG ).show();

                Intent goback = new Intent(CommentActivity.this, HotelActivity.class);
                goback.putExtra("id",idhotel);
                startActivity(goback);





            }
        });





    }
}
