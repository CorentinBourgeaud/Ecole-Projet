package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class MenuAnglais extends AppCompatActivity {


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_anglais);
        user = (User) getIntent().getSerializableExtra("user");

    }

    public void changeGuessAnimal(View view){
        Intent intent = new Intent(this, GuessTheAnimal.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }


    public void retour (View view){
        super.finish();
    }
}