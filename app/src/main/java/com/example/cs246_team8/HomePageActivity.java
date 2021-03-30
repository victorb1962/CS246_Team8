package com.example.cs246_team8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.cs246_team8.DB.GradeDAO;
import com.example.cs246_team8.DB.User;

/**
 * Home page activity.
 */
public class HomePageActivity extends AppCompatActivity {

    GradeDAO myGradeDAO;
    /**
     * My user.
     */
    User myUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button create_account_button = findViewById(R.id.create_account);
        create_account_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the create account activity
                Log.d("HomePageActivity", "onClick for create account called");
                Intent intent = new Intent(HomePageActivity.this, CreateAccountActivity.class);
                startActivity(intent);

            }
        });

        Button login_button = findViewById(R.id.login);
        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the login Activity
                Log.d("Login", "onClick for login activity called");
                Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        Button view_logs_button = findViewById(R.id.viewlogs);
        view_logs_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // call the view log activity
                Log.d("HomePageActivity", "onClick for view log called");
                Intent intent = new Intent(HomePageActivity.this, ViewLogActivity.class);
                startActivity(intent);

            }
        });

        Button exit_button = findViewById(R.id.exit);
        exit_button.setOnClickListener(new View.OnClickListener(){
            // call to exit the application
            @Override
            public void onClick(View v) {
                Log.d("Exit", "onClick for exit called");
                finish();  // make it actually close app from anywhere !!

            }
        });

    }
}
