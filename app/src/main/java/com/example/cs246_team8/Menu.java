package com.example.cs246_team8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {
    SharedPreferences preferences;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
/*
        preferences = getSharedPreferences("PREFERENCE",Context.MODE_PRIVATE);
        ApiAsyncTask apiAsync = new ApiAsyncTask(preferences);
        apiAsync.execute();
        //saveApiToSharedPrefs();
    }

    public void continueToSchool(View view) {

        Intent intent = new Intent(this, ItemDisplay.class);
        startActivity(intent);

    }

    public void continueToClasses(View view) {
        Intent intent = new Intent(this, ItemDisplay.class);
        startActivity(intent);

    }

    public void continueToCourses(View view) {
        Intent intent = new Intent(this, ItemDisplay.class);
        startActivity(intent);

    }

    public void continueToGrades(View view) {
        Intent intent = new Intent(this, ItemDisplay.class);
        startActivity(intent);

    }

    public void goToCheckout(View view) {
        Intent intent = new Intent(this, Shopping_list.class);
        startActivity(intent);
    }
*/
    /**
     * Places a call to the API. Places the API response json string into
     * shared preferences.
     */
/*
    public void saveApiToSharedPrefs() {
        APIcall dairyData = new APIcall();
        // String ApiData = dairyData.getApiData();
//        String ApiData = "test string";
        // Initilizes Shared Preferences
        //SharedPreferences prefs = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = prefs.edit();

        // Saves data to with key --> walmart
//        editor.putString("walmart", ApiData);
//        editor.apply();

        // This code is to test if the data was saved in Shared Pref
        // String result = prefs.getString("walmart", null);
        //Log.d("Shared Pref Results: ", result);
    }
*/
}