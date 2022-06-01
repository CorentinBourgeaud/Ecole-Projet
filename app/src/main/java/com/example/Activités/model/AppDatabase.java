package com.example.Activités.model;


import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}