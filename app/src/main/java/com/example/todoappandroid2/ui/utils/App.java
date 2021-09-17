package com.example.todoappandroid2.ui.utils;

import android.app.Application;

import androidx.room.Room;

import com.example.todoappandroid2.room.AppDataBase;

public class App extends Application {
    public static App instance;

    private AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance= this;
        dataBase = Room.databaseBuilder(this,AppDataBase.class,"database").allowMainThreadQueries().build();
    }
    public static App getInstance(){
        return instance;
    }
    public AppDataBase getDataBase(){
        return dataBase;
    }
}
