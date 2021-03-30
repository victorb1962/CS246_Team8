package com.example.cs246_team8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.List;

import com.example.cs246_team8.DB.AppDatabase;
import com.example.cs246_team8.DB.Course;
import com.example.cs246_team8.DB.GradeCategory;
import com.example.cs246_team8.DB.GradeCategoryDAO;

/**
 * The type Add grade category activity.
 */
public class AddGradeCategoryActivity extends AppCompatActivity {
    /**
     * The constant TAG.
     */
    public static final String TAG = "AddGradeCategoryAct";
    private List<Course> all_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade_category);
        final Button start_date = findViewById(R.id.start_date);
        final Button end_date = findViewById(R.id.end_date);

        all_courses = AppDatabase.getAppDatabase(AddGradeCategoryActivity.this).
                courseDAO().getCoursesAvailable();

        if (all_courses.size() == 0){
            alert("Please add a course before viewing this page.", true);
        }
        int course_id = all_courses.get(0).getCourseID();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                course_id = extras.getInt("course_id");
            }
        } else {
            course_id = (int) savedInstanceState.getSerializable("course_id");
        }

        final Spinner course_spinner = findViewById(R.id.course_spinner);

        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,
                android.R.layout.simple_spinner_item, all_courses);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        course_spinner.setAdapter(adapter);

        for (int i=0; i<all_courses.size(); i++) {
            if (all_courses.get(i).getCourseID() == course_id) {
                course_spinner.setSelection(i);
                break;
            }
        }

        //button is created attached to a setOnClickListener to be able to see when the button submit course is being clicked
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "submit clicked");

                EditText title = findViewById(R.id.title);
                EditText weight = findViewById(R.id.weight);

                String category_title = title.getText().toString();
                String weight_text = weight.getText().toString();
                if (category_title.equals("") || weight_text.equals("")){
                    alert("Please fill in all fields.", false);
                    return;
                }
                float category_weight = Float.parseFloat(weight_text);
                Course selected_course = (Course) course_spinner.getSelectedItem();

                // add the new Grade Category into the database
                GradeCategory newGradeCategory = new GradeCategory(category_title, category_weight, selected_course.getCourseID());
                GradeCategoryDAO gradeCategoryDAO = AppDatabase.getAppDatabase(AddGradeCategoryActivity.this).gradeCategoryDAO();
                gradeCategoryDAO.addGradeCategory(newGradeCategory);

                    //  Show in the log record that a new account was created
//                    Date now = new Date();
//                    LogRecord rec = new LogRecord(now, LogRecord.TYPE_NEW_ACCOUNT, name, "");
//                    user_dao.addLogRecord(rec);

                // inform user that new account has been created
                utils.display_toast(getApplicationContext(), "Grade Category created successfully", true);
                finish();
            }
        });

    }
    /**
     * Alert.
     * @param error the error
     * @param finish_activity the boolean
     */
    public void alert(String error, final boolean finish_activity) {
        Log.d(TAG, "alerting error");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(error)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (finish_activity){
                            finish();
                        }
                    }
                });
        builder.create();
        builder.show();
    }

    /**
     * Informs user by a message that the grade category is set.
     * @param msg the msg
     */
//informs user
    public void inform(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddGradeCategoryActivity.this);
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
