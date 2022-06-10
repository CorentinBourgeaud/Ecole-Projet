package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class Accueil extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        user = (User) getIntent().getSerializableExtra("user");
        Button profil = findViewById(R.id.profil);
        profil.setText("Profil de " + user.getLogin());

    }

    public void changeMaths(View view) {
        Intent intent = new Intent(this, MenuMaths.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void changeGeographie(View view) {
        Intent intent = new Intent(this, MenuGeographie.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void changeAnglais(View view) {
        Intent intent = new Intent(this, MenuAnglais.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void changeProfil(View view) {
        Intent intent = new Intent(this, MediaTest.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
    
}