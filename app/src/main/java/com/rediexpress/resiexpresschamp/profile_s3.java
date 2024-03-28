package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        //change profile

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

        //intent notifications
        ImageView notifications = findViewById(R.id.smallarrow2);
        notifications.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, notifications_s3.class);
            startActivity(intent);
        });

         */

        // intent to card view
        ImageView cardview = findViewById(R.id.smallarrow3);
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

        //intent to logout
        ImageView logout = findViewById(R.id.smallarrow6);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(profile_s3.this, login_s2.class);
            startActivity(intent);
        });

        */
    }
}