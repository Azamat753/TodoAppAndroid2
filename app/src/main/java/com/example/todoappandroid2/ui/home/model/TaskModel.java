package com.example.todoappandroid2.ui.home.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class TaskModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String createdDate;

    public TaskModel(String title, String createdDate) {
        this.title = title;
        this.createdDate = createdDate;
    }
}
