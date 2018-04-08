package com.achraf.hotelstunisia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    private static int TIME_SPLASH_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(Splash.this, Acceuil.class);
                startActivity(homeintent);
                finish();

            }
        },TIME_SPLASH_OUT);
    }
}
