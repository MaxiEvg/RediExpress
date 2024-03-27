package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class onboarding4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //skip to onboarding3
        ImageButton skipbutton = findViewById(R.id.skipbutton);
        skipbutton.setOnClickListener(v -> {
            Intent intent = new Intent(onboarding4.this, onboarding3.class);
            startActivity(intent);
        });

        //move to next activity
        ImageButton nextbutton = findViewById(R.id.nextbutton);
        nextbutton.setOnClickListener(v -> {
            Intent intent = new Intent(onboarding4.this, onboarding3.class);
            startActivity(intent);
        });
    }
}