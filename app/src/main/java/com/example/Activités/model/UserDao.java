package com.example.Activités.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insert(User users);

    @Insert
    long[] insertAll(User... users);

    @Update
    void update(User users);

    @Delete
    void delete(User users);

}
