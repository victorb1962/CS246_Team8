/**
 * class for creating the GradeCategory object
 * @PrimaryKey: categoryID
 * @takes in the CourseID foreign key from the Course table
 * Gives us the GCTitle (name of the grade category. eg. Exam, Quiz, Lab),
 * Weight (What percentage of the total grade this grade category is worth),
 * and Assigned Date
 */
package com.example.cs246_team8.DB;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = AppDatabase.GRADE_CATEGORY_TABLE)

public class GradeCategory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int categoryID;

    private String Title;
    private float Weight;
    private int CourseID; //GradeID ?

    public GradeCategory() {    }

    @Ignore
    public GradeCategory(String Title, float Weight, int CourseID) {
        this.Title=Title;
        this.Weight=Weight;
        this.CourseID = CourseID;

    }

    @Override
    public String toString() {
        return Title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
