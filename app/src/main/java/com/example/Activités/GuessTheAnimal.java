package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class GuessTheAnimal extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_animal);
        //user = (User) getIntent().getSerializableExtra("user");
        user = ((MyApplication) getApplication()).getUser();
    }

    public void changeChoixGuessTheAnimal(View view) {
        Intent intent = new Intent(this, ChoixGuessTheAnimal.class);
        //intent.putExtra("user", user);
        startActivity(intent);
    }

    public void changeRegleGuessTheAnimal(View view) {
        Intent intent = new Intent(this, RegleGuessTheAnimal.class);
        //intent.putExtra("user", user);
        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }
}

