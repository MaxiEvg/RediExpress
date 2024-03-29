package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_s3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_s3);

        findViewById(R.id.chatsbutton).setOnClickListener(v -> startActivity(new Intent(this, chat.class)));


        //when customers care button is clicked change icon to customerscareblue ONLY WHEN PRESSED
        findViewById(R.id.customerscarebutton).setOnTouchListener((v, event) -> {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                findViewById(R.id.customerscarebutton).setBackgroundResource(R.drawable.wholecustomerscareclick);
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                findViewById(R.id.customerscarebutton).setBackgroundResource(R.drawable.wholecustomercare);
            }
            return false;
        });

        //when send a package button is clicked change icon to sendapackageblue
        findViewById(R.id.sendpackage).setOnTouchListener((v, event) -> {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                findViewById(R.id.sendpackage).setBackgroundResource(R.drawable.wholesendclick);
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                findViewById(R.id.sendpackage).setBackgroundResource(R.drawable.wholesend);
            }
            return false;
        });

        //when fund button is clicked change icon to fundblue
        findViewById(R.id.fundwallet).setOnTouchListener((v, event) -> {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                findViewById(R.id.fundwallet).setBackgroundResource(R.drawable.wholewalletclick);
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                findViewById(R.id.fundwallet).setBackgroundResource(R.drawable.wholefundwallet);
            }
            return false;
        });

        //when chat button is clicked change icon to chatblue
        findViewById(R.id.chatsbutton).setOnTouchListener((v, event) -> {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                findViewById(R.id.chatsbutton).setBackgroundResource(R.drawable.wholechatclick);
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                findViewById(R.id.chatsbutton).setBackgroundResource(R.drawable.wholechat);
            }
            return false;
        });



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Homenavig) {
                Intent intent = new Intent(home_s3.this, home_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Walletnavig) {
                Intent intent = new Intent(home_s3.this, wallet_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Tracknavig) {
                Intent intent = new Intent(home_s3.this, track_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Profilenavig) {
                Intent intent = new Intent(home_s3.this, profile_s3.class);
                startActivity(intent);
                return true;
            }
            return false;
        });



    }
}