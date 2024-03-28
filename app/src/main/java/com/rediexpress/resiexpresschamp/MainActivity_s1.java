package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity_s1 extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_s1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //change srcCompat from framewhite to frameblue after 1.5 sec
        new Handler().postDelayed(() -> findViewById(R.id.framewhite).setBackgroundResource(R.drawable.frameblue), 1500);

        //change main background color to primary_color after 1.5 sec
        new Handler().postDelayed(() -> findViewById(R.id.main).setBackgroundColor(getColor(R.color.primary_color)), 1500);

        // automatically moves to onboarding1_s1 after 3 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity_s1.this, onboarding1_s1.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);

    }


}