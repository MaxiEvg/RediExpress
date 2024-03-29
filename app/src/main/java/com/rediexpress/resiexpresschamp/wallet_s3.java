package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class wallet_s3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wallet_s3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Homenavig) {
                Intent intent = new Intent(wallet_s3.this, home_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Walletnavig) {
                Intent intent = new Intent(wallet_s3.this, wallet_s3.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.Profilenavig) {
                Intent intent = new Intent(wallet_s3.this, profile_s3.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}