package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.R;

public class MenuAnglais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_anglais);
    }

    public void changeGuessAnimal(View view){
        Intent intent = new Intent(this, GuessTheAnimal.class);
        startActivity(intent);
    }


    public void retour (View view){
        super.finish();
    }
}