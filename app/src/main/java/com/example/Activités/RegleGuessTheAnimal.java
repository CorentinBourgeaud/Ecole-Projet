package com.example.Activités;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class RegleGuessTheAnimal extends AppCompatActivity {

    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle_guess_the_animal);
        //user = (User) getIntent().getSerializableExtra("user");
        user = ((MyApplication) getApplication()).getUser();

    }

    public void retour (View view){
        super.finish();
    }
}