package com.example.cs246_team8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // TAG to use for debug messages
    private static final String TAG = "TEAM8_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogin(View view) {
        startActivity(new Intent(this, LogIn.class));
    }

    public void continueWithoutLogin(View view) {
        startActivity(new Intent(this, Menu.class));
    }
}