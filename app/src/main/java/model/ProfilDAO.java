package model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfilDAO {

    @Insert
    static void insert(Profil profil);

    @Update
    void update(Profil profil);

    @Delete
    void delete(Profil profil);

    @Query("DELETE FROM profil")
    void deleteAllProfil();

    @Query("SELECT * FROM Profil ORDER BY numProfil")
    LiveData<List<Profil>> getAllProfil();
}
