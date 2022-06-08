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

    public User(){}

    public User getUser(){
        return this;
    }

    public void setNumProfil(int numProfil) {
        this.numProfil = numProfil;
    }

    protected int getNumProfil() { return numProfil; }

    public String getLogin(){
        return login;
    }
    protected String getPassword(){
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
