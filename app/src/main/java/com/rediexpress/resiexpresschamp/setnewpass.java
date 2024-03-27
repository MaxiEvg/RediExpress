package com.rediexpress.resiexpresschamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class setnewpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setnewpass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //if inewpass1 isnt valid make its background @errorfield
        if (!isValidNewPass1(((EditText) findViewById(R.id.inewpass1)).getText().toString())) {
            findViewById(R.id.inewpass1).setBackgroundResource(R.drawable.inputfieldred);
        }

        //if inewpass2 isnt valid make its background @errorfield
        if (!isValidNewPass2(((EditText) findViewById(R.id.inewpass2)).getText().toString())) {
            findViewById(R.id.inewpass2).setBackgroundResource(R.drawable.inputfieldred);
        }

        // if passowrds match each other and they are valid make login button @loginbuttonactvie
        Button loginButton = findViewById(R.id.loginbutton);

        // Check if passwords match and are valid
       new Thread(() -> {
            while (true) {
                try {Thread.sleep(500);} catch (InterruptedException e) { e.printStackTrace();}
                runOnUiThread(() -> {
                    if (passwordsMatch() && passwordsValid()) {
                        loginButton.setEnabled(true);
                        findViewById(R.id.inewpass1).setBackgroundResource(R.drawable.inputfieldgray);
                        findViewById(R.id.inewpass2).setBackgroundResource(R.drawable.inputfieldgray);
                        loginButton.setBackgroundResource(R.drawable.login);
                    } else {
                        loginButton.setEnabled(false);
                        findViewById(R.id.inewpass1).setBackgroundResource(R.drawable.inputfieldred);
                        findViewById(R.id.inewpass2).setBackgroundResource(R.drawable.inputfieldred);
                        loginButton.setBackgroundResource(R.drawable.logininactive);
                    }
                });
            }
        }).start();

        findViewById(R.id.loginbutton).setOnClickListener(v -> {
            startActivity(new Intent(this,login.class));
        });
    }
    public boolean passwordsMatch() {
        EditText password1 = findViewById(R.id.inewpass1);
        EditText password2 = findViewById(R.id.inewpass2);
        return password1.getText().toString().equals(password2.getText().toString());
    }
    public boolean passwordsValid() {
        EditText password1 = findViewById(R.id.inewpass1);
        EditText password2 = findViewById(R.id.inewpass2);
        return isValidNewPass1(password1.getText().toString()) && isValidNewPass2(password2.getText().toString());
    }
    public boolean isValidNewPass1(String inewpass1) {
        findViewById(R.id.inewpass1).setBackgroundResource(R.drawable.inputfieldgray);
        return inewpass1.length() >= 8;
    }
    public boolean isValidNewPass2(String inewpass2){
        findViewById(R.id.inewpass2).setBackgroundResource(R.drawable.inputfieldgray);
        return inewpass2.length() >= 8;
    }


}
