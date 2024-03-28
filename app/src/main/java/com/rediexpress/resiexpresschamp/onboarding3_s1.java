package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class onboarding3_s1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding3_s1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton signupbutton = findViewById(R.id.signupbutton);
        signupbutton.setOnClickListener(v -> {
            Intent intent = new Intent(onboarding3_s1.this, signup_s2.class);
            startActivity(intent);
        });


        TextView signintext = findViewById(R.id.signin);
        signintext.setOnClickListener(v -> {
            Intent intent = new Intent(onboarding3_s1.this, login_s2.class);
            startActivity(intent);

        });
    }
}