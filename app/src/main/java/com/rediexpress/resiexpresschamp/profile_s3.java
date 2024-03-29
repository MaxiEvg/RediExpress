package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile_s3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_s3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Homenavig) {
                Intent intent = new Intent(profile_s3.this, home_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Walletnavig) {
                Intent intent = new Intent(profile_s3.this, wallet_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Tracknavig) {
                Intent intent = new Intent(profile_s3.this, track_s3.class);
                startActivity(intent);
                return true;
            }

            // hide balance with ***** if selected
            CheckBox balance = findViewById(R.id.hidebalance);
            if (balance.isChecked()) {
                TextView balance2 = findViewById(R.id.balance);
                balance2.setText("*****");
            }

            //intent to editprofile
        /*

        ImageView editprofile = findViewById(R.id.smallarrow);
        editprofile.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, editprofile_s3.class);
            startActivity(intent);
        });

        //intent statements
        ImageView statementsandpeports = findViewById(R.id.smallarrow1);
        statementsandpeports.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, statementsandpeports_s3.class);
            startActivity(intent);
        });
        */

        //intent notifications
            TextView notification = findViewById(R.id.notificationssettings);
        notification.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, notifications_s3.class);
            startActivity(intent);
        });
        FrameLayout notifications = findViewById(R.id.notificationsettingsbox);
        notifications.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, notifications_s3.class);
            startActivity(intent);
        });


        // intent to card view
            TextView cards = findViewById(R.id.cardnadbankacc);
        cards.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, addpayment_s3.class);
            startActivity(intent);
        });

        FrameLayout cardview = findViewById(R.id.cardeditbox);
        cardview.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, addpayment_s3.class);
            startActivity(intent);
        });
        /*
        //intent to refferals
        ImageView refer = findViewById(R.id.smallarrow4);
        refer.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, refferals.class);
            startActivity(intent);
        });

        //intent to aboutus
        ImageView aboutus = findViewById(R.id.smallarrow5);
        aboutus.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, aboutus_s3.class);
            startActivity(intent);
        });
        */

        //intent to logout
            TextView logouts = findViewById(R.id.logout);
        logouts.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, login_s2.class);
            startActivity(intent);
        });
        FrameLayout logout = findViewById(R.id.logoutbox);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, login_s2.class);
            startActivity(intent);
        });
            return false;
        });
    }
}
