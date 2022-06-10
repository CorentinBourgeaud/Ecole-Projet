package com.example.Activités.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "User")

public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int numProfil;
    @ColumnInfo
    private String login;
    @ColumnInfo
    private String prénom;
    @ColumnInfo
    private int xp;
    @ColumnInfo
    private int xpGeo;
    @ColumnInfo
    private int xpAnglais;
    @ColumnInfo
    private int xpMaths;

    public User(){}

    public User getUser(){
        return this;
    }

    public void setNumProfil(int numProfil) {
        this.numProfil = numProfil;
    }

    public int getNumProfil() { return numProfil; }

    public String getLogin(){
        return login;
    }
    protected String getPrénom(){
        return prénom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpGeo() {
        return xpGeo;
    }

    public void setXpGeo(int xpGeo) {
        this.xpGeo = xpGeo;
    }

    public int getXpAnglais() {
        return xpAnglais;
    }

    public void setXpAnglais(int xpAnglais) {
        this.xpAnglais = xpAnglais;
    }

    public int getXpMaths() {
        return xpMaths;
    }

    public void setXpMaths(int xpMaths) {
        this.xpMaths = xpMaths;
    }
}
