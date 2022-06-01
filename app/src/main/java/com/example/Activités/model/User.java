package com.example.Activités.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "User")

public class User {

    @PrimaryKey(autoGenerate = true)
    private int numProfil;

    private String login;
    private String password;
    //private Date dateNaissance;

    User(String login, String password/*Date dateNaissance*/){
        this.login = login;
        this.password = password;
   //     this.dateNaissance = dateNaissance;
    }

    public void setNumProfil(int numProfil) {
        this.numProfil = numProfil;
    }

    protected int getNumProfil() { return numProfil; }

    protected String getLogin(){
        return login;
    }
    protected String getPassword(){
        return password;
    }
    //protected Date getDateNaissance(){
    //    return dateNaissance;
    //}


}
