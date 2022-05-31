package model;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Profil.class, version = 1)
public abstract class ProfilDatabase extends RoomDatabase {

    private static ProfilDatabase instance;

    public abstract ProfilDAO profilDao();

    public static synchronized ProfilDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProfilDatabase.class, "profil_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
