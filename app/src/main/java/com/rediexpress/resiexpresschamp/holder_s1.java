package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class holder_s1 extends AppCompatActivity {
    private static final long SPLASH_DELAY = 50; // 50 ms
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_holder_s1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // automatically moves to login_s2
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(holder_s1.this, login_s2.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);

    }
}