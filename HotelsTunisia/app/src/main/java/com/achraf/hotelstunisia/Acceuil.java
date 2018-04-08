package com.achraf.hotelstunisia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.achraf.hotelstunisia.classes.Hotel;
import com.achraf.hotelstunisia.classes.HotelsAdapter;

public class Acceuil extends AppCompatActivity {


    private Hotel[] hotels = {
            new Hotel(R.string.hotel1, R.string.ville1, R.drawable.hotel1),
            new Hotel(R.string.hotel2, R.string.ville2, R.drawable.hotel2),
            new Hotel(R.string.hotel3, R.string.ville3, R.drawable.hotel3),
            new Hotel(R.string.hotel4, R.string.ville4, R.drawable.hotel7),
            new Hotel(R.string.hotel5, R.string.ville5, R.drawable.hotel5),
            new Hotel(R.string.hotel6, R.string.ville6, R.drawable.hotel6),
            new Hotel(R.string.hotel7, R.string.ville7, R.drawable.hotel7),
            new Hotel(R.string.hotel8, R.string.ville8, R.drawable.hotel8),
    };



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    return true;
                case R.id.liste:
                    Intent goliste = new Intent(Acceuil.this, Liste.class);
                    startActivity(goliste);
                    return true;
                case R.id.recherche:
                    Intent gorech = new Intent(Acceuil.this, Recherche.class);
                    startActivity(gorech);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        GridView gridView = (GridView)findViewById(R.id.gridview);
        HotelsAdapter hotelsAdapter = new HotelsAdapter(this, hotels);
        gridView.setAdapter(hotelsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {


                Intent Gridtouch = null;
                Gridtouch = new Intent(view.getContext(), HotelActivity.class);
                Gridtouch.putExtra("id", position+1);
                startActivity(Gridtouch);


            }
        });
    }

}
