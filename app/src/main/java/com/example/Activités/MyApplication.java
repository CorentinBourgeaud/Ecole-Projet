package com.example.Activités;

import android.app.Application;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyApplication extends Application implements Serializable {

    private User user;

    private static final ArrayList<Integer> listDrapeau = new ArrayList<>();
    private static final ArrayList<String> listDrapeauStr = new ArrayList<>();

    public static final ArrayList<Integer> listAnimals = new ArrayList<>();
    public static final ArrayList<String> listAnimalStr = new ArrayList<>();
    public static final ArrayList<Integer> listPhotoAnimals = new ArrayList<>();

    public static final ArrayList<Integer> listAvatar = new ArrayList<>();



    public ArrayList<Integer> getListDrapeau() {
        listDrapeau.add(R.drawable.austria);
        listDrapeau.add(R.drawable.belgium);
        listDrapeau.add(R.drawable.bulgaria);
        listDrapeau.add(R.drawable.croatia);
        listDrapeau.add(R.drawable.cyprus);
        listDrapeau.add(R.drawable.czech);
        listDrapeau.add(R.drawable.denmark);
        listDrapeau.add(R.drawable.estonia);
        listDrapeau.add(R.drawable.europe);
        listDrapeau.add(R.drawable.finland);
        listDrapeau.add(R.drawable.france);
        listDrapeau.add(R.drawable.germany);
        listDrapeau.add(R.drawable.greece);
        listDrapeau.add(R.drawable.hungary);
        listDrapeau.add(R.drawable.ireland);
        listDrapeau.add(R.drawable.italy);
        listDrapeau.add(R.drawable.latvia);
        listDrapeau.add(R.drawable.lithuania);
        listDrapeau.add(R.drawable.luxembourg);
        listDrapeau.add(R.drawable.malta);
        listDrapeau.add(R.drawable.netherlands);
        listDrapeau.add(R.drawable.poland);
        listDrapeau.add(R.drawable.portugal);
        listDrapeau.add(R.drawable.romania);
        listDrapeau.add(R.drawable.slovakia);
        listDrapeau.add(R.drawable.slovenia);
        listDrapeau.add(R.drawable.spain);
        listDrapeau.add(R.drawable.sweden);
        listDrapeau.add(R.drawable.uk);
        return listDrapeau;
    }
    public ArrayList<String> getListDrapeauStr(){
        listDrapeauStr.add("Autriche");
        listDrapeauStr.add("Belgique");
        listDrapeauStr.add("Bulgarie");
        listDrapeauStr.add("Croatie");
        listDrapeauStr.add("Chypre");
        listDrapeauStr.add("République Tchèque");
        listDrapeauStr.add("Danemark");
        listDrapeauStr.add("Estonie");
        listDrapeauStr.add("Union Européenne");
        listDrapeauStr.add("Finlande");
        listDrapeauStr.add("France");
        listDrapeauStr.add("Allemagne");
        listDrapeauStr.add("Grèce");
        listDrapeauStr.add("Hongrie");
        listDrapeauStr.add("Irlande");
        listDrapeauStr.add("Italie");
        listDrapeauStr.add("Lettonie");
        listDrapeauStr.add("Lituanie");
        listDrapeauStr.add("Luxembourg");
        listDrapeauStr.add("Malte");
        listDrapeauStr.add("Pays Bas");
        listDrapeauStr.add("Pologne");
        listDrapeauStr.add("Portugal");
        listDrapeauStr.add("Roumanie");
        listDrapeauStr.add("Slovaquie");
        listDrapeauStr.add("Slovénie");
        listDrapeauStr.add("Espagne");
        listDrapeauStr.add("Suède");
        listDrapeauStr.add("Royaume Uni");


        return listDrapeauStr;
    }

    public ArrayList<Integer> getListAnimals(){
        listAnimals.add(R.raw.dog);
        listAnimals.add(R.raw.cat);
        listAnimals.add(R.raw.horse);
        listAnimals.add(R.raw.cow);
        listAnimals.add(R.raw.lion);
        listAnimals.add(R.raw.duck);
        listAnimals.add(R.raw.tiger);
        listAnimals.add(R.raw.frog);
        listAnimals.add(R.raw.pig);
        listAnimals.add(R.raw.coq);

        return listAnimals;
    }
    public ArrayList<String> getListAnimalStr(){
        listAnimalStr.add("dog");
        listAnimalStr.add("cat");
        listAnimalStr.add("horse");
        listAnimalStr.add("cow");
        listAnimalStr.add("lion");
        listAnimalStr.add("duck");
        listAnimalStr.add("tiger");
        listAnimalStr.add("frog");
        listAnimalStr.add("pig");
        listAnimalStr.add("rooster");
        return  listAnimalStr;
    }
    public ArrayList<Integer> getListPhotoAnimals(){
        listPhotoAnimals.add(R.drawable.dog);
        listPhotoAnimals.add(R.drawable.cat);
        listPhotoAnimals.add(R.drawable.horse);
        listPhotoAnimals.add(R.drawable.cow);
        listPhotoAnimals.add(R.drawable.lion);
        listPhotoAnimals.add(R.drawable.duck);
        listPhotoAnimals.add(R.drawable.tiger);
        listPhotoAnimals.add(R.drawable.frog);
        listPhotoAnimals.add(R.drawable.pig);
        listPhotoAnimals.add(R.drawable.rooster);
        return listPhotoAnimals;
    }

    public ArrayList<Integer> getListAvatar(){

        listAvatar.add(R.drawable.pikachu);
        listAvatar.add(R.drawable.link);
        listAvatar.add(R.drawable.rondoudou);
        listAvatar.add(R.drawable.pikachu);
        listAvatar.add(R.drawable.link);
        listAvatar.add(R.drawable.rondoudou);
        listAvatar.add(R.drawable.pikachu);
        listAvatar.add(R.drawable.link);
        listAvatar.add(R.drawable.rondoudou);


        return listAvatar;
    }

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

}
