package com.example.cs246_team8.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AssignmentDAO {
    @Insert
    void addAssignment( Assignment Assignment);

    @Update
    void update(Assignment... Assignments);
    @Delete
    void delete(Assignment Assignment);

    @Query("select * from " + AppDatabase.ASSIGNMENT_TABLE)
    List<Assignment> getAssignments();

    @Query("select * from AssignmentTable  where CategoryID = :category_id")
    List<Assignment> getAssignmentsByCategory(int category_id);

    @Query("select * from AssignmentTable  where AssignmentID = :AssignmentID")
    Assignment getAssignmentByID(int AssignmentID);

//    @Query("select * from assignmentTable natural join gradeTable where CategoryID=:CategoryID and UserID=:UserID")
//    List <Assignment> getAssignmentsByCategory(Integer CategoryID, Integer UserID);

    @Query("select * from LogRecord order by time desc")
    List<LogRecord> getAllLogRecords();

    @Insert
    void addLogRecord(LogRecord rec);

}
