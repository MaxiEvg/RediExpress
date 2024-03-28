package com.rediexpress.resiexpresschamp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup_s2 extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_s2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //change text color to @color/warning_color
        TextView TaCapp = findViewById(R.id.TaCapp);
        SpannableString spannableString = new SpannableString("By ticking this box, you agree to our Terms and conditions and private policy");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.warning_color)), 38, 77, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TaCapp.setText(spannableString);;

        //open local pdf of TaCapp when clicked
        TaCapp.setOnClickListener(v -> {
            Intent intent = new Intent(signup_s2.this, tacapp.class);
            startActivity(intent);
        });


        //make sure if name is valid and if its not change background to @drawable/errorfield
        //if wrong change background to @drawable/errorfield
        EditText ifullname = findViewById(R.id.ifullname);
        ifullname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String name = ifullname.getText().toString().trim();
                    if (name.isEmpty() || !isValidName(name)) {
                        ifullname.setBackgroundResource(R.drawable.inputfieldred);
                    } else {
                        ifullname.setBackgroundResource(R.drawable.inputfieldgray);
                    }
                }
            }

            //check for valid name
            public boolean isValidName(String name) {
                // if length is less than 3 characters then it is not valid
                return name.length() >= 3;
            }
        });

            /*
        make sure if phonenumber is valid and if its not change background to @drawable/errorfield
        if wrong change background to @drawable/errorfield
        check if it starts with +7 or 8 and has 11 characters
            */
        EditText iphonenum = findViewById(R.id.iphonenum);
        iphonenum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String phoneNumber = iphonenum.getText().toString().trim();
                    if (phoneNumber.isEmpty() || !isValidPhoneNumber(phoneNumber)) {
                        iphonenum.setBackgroundResource(R.drawable.inputfieldred);
                    } else {
                        iphonenum.setBackgroundResource(R.drawable.inputfieldgray);
                    }
                }
            }
            public boolean isValidPhoneNumber(String phoneNumber) {
                // Check if the phone number starts with +7 and has 12 characters
                // or starts with 8 and has 11 characters
                return (phoneNumber.startsWith("+7") && phoneNumber.length() == 12)
                        || (phoneNumber.startsWith("8") && phoneNumber.length() == 11);
            }
        });

        // проверка email на корректность (соответствие паттерну «name@domenname.ru», где имя и доменное имя может состоять только из маленьких букв и цифр)
        EditText emailaddres = findViewById(R.id.imailaddr);
        emailaddres.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String email = emailaddres.getText().toString().trim();
                    if (email.isEmpty() || !isValidEmail(email)) {
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


        //make sure password is valid and if its not change background to @drawable/errorfield
        //if wrong change background to @drawable/errorfield
        EditText password1 = findViewById(R.id.ipassword1);
        password1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String pass = password1.getText().toString().trim();
                    if (pass.isEmpty() || !isValidPassword1(pass)) {
                        password1.setBackgroundResource(R.drawable.inputfieldred);
                    } else {
                        password1.setBackgroundResource(R.drawable.inputfieldgray);
                    }
                }
            }

            public boolean isValidPassword1(String password) {
                // Check if the password is at least 8 characters long
                return password.length() >= 8;
            }
        });

        //make sure password is valid and if its not change background to @drawable/errorfield
        //if wrong change background to @drawable/errorfield
        EditText password2 = findViewById(R.id.ipassword2);
        password2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String pass = password2.getText().toString().trim();
                    if (pass.isEmpty() || !isValidPassword2(pass)) {
                        password2.setBackgroundResource(R.drawable.inputfieldred);
                    } else {
                        password2.setBackgroundResource(R.drawable.inputfieldgray);
                    }
                }
            }

            public boolean isValidPassword2(String password) {
                // Check if the password is at least 8 characters long
                return password.length() >= 8;
            }
        });

        //check for matching password1 and ipassword2
        password2.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String pass1 = password1.getText().toString().trim();
                String pass2 = password2.getText().toString().trim();
                if (!pass1.equals(pass2)) {
                    password2.setBackgroundResource(R.drawable.inputfieldred);
                } else {
                    password2.setBackgroundResource(R.drawable.inputfieldgray);
                }
            }
        });


        //check if checkbox is checked
        CheckBox TaCappbox = findViewById(R.id.TaCappbox);
        TaCappbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ImageButton signUpButton = findViewById(R.id.sign_up);
            signUpButton.setEnabled(isChecked);
        });


        //if full name, phone number, email address, passwords are not valid or empty and TaCapp is not checked make button inactive and make it @drawable/signup_inactive check true every 0.5 second
        new Thread(() -> {
            while (true) {
                try { Thread.sleep(500); } catch (InterruptedException e) {e.printStackTrace();}
                runOnUiThread(() -> {
                    ImageButton signUpButton = findViewById(R.id.sign_up);
                    if (!isValidName(ifullname.getText().toString().trim())
                            || !isValidPhoneNumber(iphonenum.getText().toString().trim())
                            || !isValidEmail(emailaddres.getText().toString().trim())
                            || password1.getText().toString().trim().isEmpty()
                            || password2.getText().toString().trim().isEmpty()
                            || !TaCappbox.isChecked()) {
                        signUpButton.setEnabled(false);
                        signUpButton.setBackgroundResource(R.drawable.signupgray);
                    } else {
                        signUpButton.setEnabled(true);
                        signUpButton.setBackgroundResource(R.drawable.signup);
                    }
                });
            }
        }).start();


        //transfer
        findViewById(R.id.sign_up).setOnClickListener(v -> {
            startActivity(new Intent(this, login_s2.class));
        });
        findViewById(R.id.signin).setOnClickListener(v -> {
            startActivity(new Intent(this, login_s2.class));
        });
    }

    //check for valid email
    private boolean isValidEmail(String email) {
        // Check if the email address is valid
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    //check for valid phone number
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number starts with +7 and has 12 characters
        // or starts with 8 and has 11 characters
        return (phoneNumber.startsWith("+7") && phoneNumber.length() == 12)
                || (phoneNumber.startsWith("8") && phoneNumber.length() == 11);
    }
    //check for valid name
    private boolean isValidName(String fullName) {
        // if length is less than 3 characters then it is not valid
        return fullName.length() >= 3;
    }
}
