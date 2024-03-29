package com.rediexpress.resiexpresschamp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class otpverification_s2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otpverification_s2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText digit1 = findViewById(R.id.digit1);
        EditText digit2 = findViewById(R.id.digit2);
        EditText digit3 = findViewById(R.id.digit3);
        EditText digit4 = findViewById(R.id.digit4);
        EditText digit5 = findViewById(R.id.digit5);
        EditText digit6 = findViewById(R.id.digit6);

        // check if all digits are not empty
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(() -> {
                    changeFocusOnFilledInput();
                    if (digit1.getText().toString().trim().isEmpty() ||
                            digit2.getText().toString().trim().isEmpty() ||
                            digit3.getText().toString().trim().isEmpty() ||
                            digit4.getText().toString().trim().isEmpty() ||
                            digit5.getText().toString().trim().isEmpty() ||
                            digit6.getText().toString().trim().isEmpty()) {
                        Button verify = findViewById(R.id.setnewpass);
                        verify.setEnabled(false);
                        verify.setBackgroundResource(R.drawable.setnewpassinactive);
                    } else {
                        Button verify = findViewById(R.id.setnewpass);
                        verify.setEnabled(true);
                        verify.setBackgroundResource(R.drawable.setnewpassactive);
                    }
                });
            }
        }).start();
    }

    // Function that changes focus on the next input field when the current one is filled
    private void changeFocusOnFilledInput() {
        EditText digit1 = findViewById(R.id.digit1);
        EditText digit2 = findViewById(R.id.digit2);
        EditText digit3 = findViewById(R.id.digit3);
        EditText digit4 = findViewById(R.id.digit4);
        EditText digit5 = findViewById(R.id.digit5);
        EditText digit6 = findViewById(R.id.digit6);

        digit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    digit2.requestFocus();
                    digit1.setBackgroundResource(R.drawable.numberholderfilled);
                } else {
                    digit1.setBackgroundResource(R.drawable.numberholder);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        digit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    digit3.requestFocus();
                    digit2.setBackgroundResource(R.drawable.numberholderfilled);
                } else {
                    digit2.setBackgroundResource(R.drawable.numberholder);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        digit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    digit4.requestFocus();
                    digit3.setBackgroundResource(R.drawable.numberholderfilled);
                } else {
                    digit3.setBackgroundResource(R.drawable.numberholder);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        digit4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    digit5.requestFocus();
                    digit4.setBackgroundResource(R.drawable.numberholderfilled);
                }
                else {
                    digit4.setBackgroundResource(R.drawable.numberholder);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        digit5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    digit6.requestFocus();
                    digit5.setBackgroundResource(R.drawable.numberholderfilled);
                }
                else {
                    digit5.setBackgroundResource(R.drawable.numberholder);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        digit6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    digit6.setBackgroundResource(R.drawable.numberholderfilled);
                    // Close the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(digit6.getWindowToken(), 0);
                }
                else {
                    digit6.setBackgroundResource(R.drawable.numberholder);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        findViewById(R.id.setnewpass).setOnClickListener(v -> startActivity(new Intent(this, setnewpass_s2.class)));
    }
}