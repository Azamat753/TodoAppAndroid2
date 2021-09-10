package com.example.todoappandroid2.ui.home.model;

import java.io.Serializable;

public class TaskModel implements Serializable {
    public String title;
    public String createdDate;

    public TaskModel(String title, String createdDate) {
        this.title = title;
        this.createdDate = createdDate;
    }
}
