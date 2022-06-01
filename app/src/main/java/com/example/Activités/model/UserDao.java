package com.example.Activités.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<com.example.Activités.model.User> getAll();

    @Insert
    void insert(com.example.Activités.model.User users);

    @Insert
    long[] insertAll(com.example.Activités.model.User... users);

    @Update
    void update(com.example.Activités.model.User users);

    @Delete
    void delete(com.example.Activités.model.User users);

}
