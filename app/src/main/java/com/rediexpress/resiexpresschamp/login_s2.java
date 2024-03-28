package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_s2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_s2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.forgotpasswordtextbutton).setOnClickListener(v -> startActivity(new Intent(this, forgotpass_s2.class)));
        findViewById(R.id.sign_up).setOnClickListener(v -> startActivity(new Intent(this, signup_s2.class)));

        EditText emailaddres = findViewById(R.id.imailaddr);
        emailaddres.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String email = emailaddres.getText().toString().trim();
                    if (!isValidEmail(email)) {
                        emailaddres.setBackgroundResource(R.drawable.inputfieldred);
                    } else {
                        emailaddres.setBackgroundResource(R.drawable.inputfieldgray);
                    }
                }
            }
            public boolean isValidEmail(String email) {
                // Check if the email address is valid
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
        });

        // check if password is valid
        EditText ipassword = findViewById(R.id.loginpassowrd);
        ipassword.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String password = ipassword.getText().toString().trim();
                if (password.isEmpty() && !isValidLoginPassword(password)) {
                    ipassword.setBackgroundResource(R.drawable.inputfieldred);
                } else {
                    ipassword.setBackgroundResource(R.drawable.inputfieldgray);
                }
            }
        });

        // Check if the password and email address are valid make login_s2 button active for every 0.5 sec

        new Thread(() -> {
            while (true) {
                try {Thread.sleep(500);} catch (InterruptedException e) { e.printStackTrace();}
                runOnUiThread(() -> {
                    Button signUpButton = findViewById(R.id.loginbutton);
                    if (!isValidEmail(emailaddres.getText().toString().trim())
                            || !isValidLoginPassword(ipassword.getText().toString().trim())) {
                        signUpButton.setEnabled(false);
                        signUpButton.setBackgroundResource(R.drawable.logininactive);
                    } else {
                        signUpButton.setEnabled(true);
                        signUpButton.setBackgroundResource(R.drawable.login);
                    }
                });
            }
        }).start();

        findViewById(R.id.loginbutton).setOnClickListener(v -> startActivity(new Intent(this, home_s2.class)));
    }

    public boolean isValidEmail(String email) {
        // Check if the email address is valid
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public boolean isValidLoginPassword(String password) {
        // Check if the password is at least 8 characters long
        return password.length() >= 8;
    }
}