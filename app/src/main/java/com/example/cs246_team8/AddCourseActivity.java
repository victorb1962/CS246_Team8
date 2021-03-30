/*
 * The AddCourseActivity will help in tracking the courses being added and will be integrated into the database
 */
package com.example.cs246_team8;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cs246_team8.DB.AppDatabase;
import com.example.cs246_team8.DB.Course;
import com.example.cs246_team8.DB.CourseDAO;
import com.example.cs246_team8.DB.GradeCategory;
import com.example.cs246_team8.DB.GradeCategoryDAO;
import com.example.cs246_team8.DB.TypeConverter.DateTypeConverter;

import java.util.Calendar;

/**
 * Add Course Activity allows the user to add a course and will show a calendar to select the start and end date of the course.
 */
public class AddCourseActivity extends AppCompatActivity {

    /**
     * The constant TAG.
     */
    public static final String TAG = "AddCourseActivity";


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called");
        //On Create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        final Button start_date = findViewById(R.id.start_date);
        final Button end_date = findViewById(R.id.end_date);


        final Calendar s_c = Calendar.getInstance();
        final Calendar e_c = Calendar.getInstance();

        start_date.setText(utils.format_date(s_c));
        end_date.setText(utils.format_date(e_c));

        final DatePickerDialog start_datepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        s_c.set(year, monthOfYear, dayOfMonth);
                        start_date.setText(utils.format_date(s_c));

                    }
                }, s_c.get(Calendar.YEAR), s_c.get(Calendar.MONTH), s_c.get(Calendar.DAY_OF_MONTH));
        final DatePickerDialog end_datepicker = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        e_c.set(year, monthOfYear, dayOfMonth);
                        end_date.setText(utils.format_date(e_c));

                    }
                }, e_c.get(Calendar.YEAR), e_c.get(Calendar.MONTH), e_c.get(Calendar.DAY_OF_MONTH));
        start_date.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        start_datepicker.show();
                    }

                }
        );

        end_date.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        end_datepicker.show();
                    }

                }
        );

        //button is created attached to a setOnClickListener to be able to see when the button submit course is being clicked
        Button submit_button = findViewById(R.id.submit);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "submit clicked");

                EditText Title = findViewById(R.id.Title);
                EditText descriptionbox = findViewById(R.id.descriptionbox);
                EditText Instructor = findViewById(R.id.Instructor);

                String course_title = Title.getText().toString();
                String course_desc = descriptionbox.getText().toString();
                String course_instructor = Instructor.getText().toString();

                long start = DateTypeConverter.convertDateToLong(s_c);
                long end = DateTypeConverter.convertDateToLong(e_c);

                // add the new Course into the database
                Course new_course = new Course(course_instructor, course_title, course_desc);
                CourseDAO courseDAO = AppDatabase.getAppDatabase(AddCourseActivity.this).courseDAO();
                courseDAO.addCourse(new_course);

                utils.display_toast(getApplicationContext(), "Course " + course_title + " created successfully");
                finish();

            }
        });
    }

    /**
     * Alert: In case of error on the on click method will provide an alert dialog.
     * @param error creates an error to alert user
     */

    public void alert(String error) {
        Log.d(TAG, "alerting error");
        AlertDialog.Builder builder = new AlertDialog.Builder(AddCourseActivity.this);
        builder.setTitle("Error");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setMessage(error);
        dialog.show();
    }

    /**
     * Inform.
     * @param msg the msg
     */

    public void inform(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddCourseActivity.this);
        builder.setTitle("Success");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setMessage(msg);
        dialog.show();
    }

}