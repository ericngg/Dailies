package com.example.dailies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().equals("")) {
                    Toast.makeText(LoginActivity.this, "Username cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (etPassword.getText().equals("")) {
                    Toast.makeText(LoginActivity.this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    loginUser(etUsername.getText().toString(), etPassword.getText().toString());
                }
            }
        });
    }

    public void loginUser(String username, String password) {
        ParseUser.logInInBackground(username, password, (user, e) -> {
            if (user != null) {
                // Hooray! The user is logged in.

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            } else {
                // Login failed. Look at the ParseException to see what happened.
                Log.e(TAG, "error: " + e.getMessage());

                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}