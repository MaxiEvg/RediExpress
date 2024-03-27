package com.rediexpress.resiexpresschamp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //make terms and conditions clickable and leads to pdf file and make it yellow color
        /*
        findViewById(R.id.TaCapp).setOnClickListener(v -> {
            Intent intent = new Intent(signup.this, termsandconditions.class);
            startActivity(intent);
        });
        */

        findViewById(R.id.TaCapp).setBackgroundColor(R.color.warning_color);
    }
}