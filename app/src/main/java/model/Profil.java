package model;

import android.content.ContentValues;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "Profil")

public class Profil {

    @PrimaryKey(autoGenerate = true)
    private int numProfil;

    private String login;
    private String password;
    private Date dateNaissance;

    Profil(String login, String password, Date dateNaissance){
        this.login = login;
        this.password = password;
        this.dateNaissance = dateNaissance;
    }

    public void setNumProfil(int numProfil) {
        this.numProfil = numProfil;
    }

    protected int getNumProfil() { return numProfil; }
    protected String getLogin(){
        return login;
    }
    private String getPassword(){
        return password;
    }
    protected Date getDateNaissance(){
        return dateNaissance;
    }


}
