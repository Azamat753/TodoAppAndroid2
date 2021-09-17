package com.example.todoappandroid2.room;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.todoappandroid2.ui.home.model.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(TaskModel taskModel);

    @Query("SELECT * FROM taskmodel")
    List<TaskModel> getAll();

}
