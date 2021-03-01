package com.example.cs246_team8;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

public class Sample extends AppCompatActivity {
    // TAG to use for debug messages
    private static final String TAG = "TEAM8_ACTIVITY";

    ListView listView;
    String[] values = {
            "   Final   Credits Course",
            "Course Grade   Earned  GPA",
            "Lab Science Courses            ",
            "Biology & Lab: 96  1.0 4.00",
            "Chemistry & Lab:   92  1.0 4.00",
            "Physics & Lab: 89  1.0 3.00",
            "DE Biology & Lab:  90  1.0 4.50",
            "Foreign Language & Elective Courses            ",
            "French 1:  92  1.0 4.00",
            "French 2:  89  1.0 3.00",
            "French 3:  88  1.0 3.00",
            "French 4:  87  1.0 3.00",
            "Honors Latin:  89  1.0 3.50",
            "Journalism:    88  1.0 3.00",
            "Drama: 97  0.5 4.00",
            "Computer Keyboard: 95  0.5 4.00",
            "CPR & First Aid:   100 0.5 4.00",
            "World Religion:    93  1.0 4.00",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        //initiate the gridView
        listView = findViewById(R.id.list);
        // initiate the gridView
        ListAdapter listAdapter = new ListAdapter(this, values);
        listView.setAdapter(listAdapter);
    }
}