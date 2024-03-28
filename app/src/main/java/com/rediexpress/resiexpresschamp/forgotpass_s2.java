package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class forgotpass_s2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgotpass_s2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText emailaddres = findViewById(R.id.forgetemail);

        emailaddres.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String email = emailaddres.getText().toString().trim();
                if (!isValidEmail(email)) {
                    emailaddres.setBackgroundResource(R.drawable.inputfieldred);
                } else {
                    emailaddres.setBackgroundResource(R.drawable.inputfieldgray);
                }
            }
        });


        // Check if the password and email address are valid make login_s2 button active for every 0.5 sec
        new Thread(() -> {
            while (true) {
                try { Thread.sleep(500); } catch (InterruptedException e) {e.printStackTrace();}
                runOnUiThread(() -> {
                    ImageButton signUpButton = findViewById(R.id.setnewpass);
                    if (!isValidEmail(emailaddres.getText().toString().trim())) {
                        signUpButton.setEnabled(false);
                        signUpButton.setBackgroundResource(R.drawable.sendotpinactive);
                    } else {
                        signUpButton.setEnabled(true);
                        signUpButton.setBackgroundResource(R.drawable.sendotpactive);
                    }
                });
            }
        }).start();

        findViewById(R.id.signin).setOnClickListener(v -> startActivity(new Intent(this, login_s2.class)));

        findViewById(R.id.setnewpass).setOnClickListener(v -> {
            startActivity(new Intent(this, otpverification_s2.class));
        });


    }
    public boolean isValidEmail(String email) {
        // Check if the email address is valid
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
