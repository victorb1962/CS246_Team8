package com.example.cs246_team8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/*
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
*/
public class Menu extends AppCompatActivity {
    // TAG to use for debug messages
    private static final String TAG = "TEAM8_ACTIVITY";

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
*/

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

    public void goToContinue(View view) {
        Intent intent = new Intent(this, Grade_List.class);
        startActivity(intent);
    }

    /**
     * Places a call to the API. Places the API response json string into shared preferences.
     */
/*
    public void saveApiToSharedPrefs() {
        APIcall schoolData = new APIcall();
        // String ApiData = schoolData.getApiData();
//        String ApiData = "test string";
        // Initilizes Shared Preferences
        //SharedPreferences prefs = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = prefs.edit();

        // Saves data to with key --> yeAcademy
//        editor.putString("yeAcademy", ApiData);
//        editor.apply();

        // This code is to test if the data was saved in Shared Pref
        // String result = prefs.getString("yeAcademy", null);
        //Log.d("Shared Pref Results: ", result);
    }
*/
}