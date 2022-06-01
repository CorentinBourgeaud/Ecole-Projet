package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.R;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        String nom = getIntent().getStringExtra("nom");
        Button profil = findViewById(R.id.profil);
        profil.setText("Profil de " + nom);

    }

    public void changeMaths(View view) {
        Intent intent = new Intent(this, MenuMaths.class);
        startActivity(intent);
    }

    public void changeGeographie(View view) {
        Intent intent = new Intent(this, MenuGeographie.class);
        startActivity(intent);
    }

    public void changeAnglais(View view) {
        Intent intent = new Intent(this, MenuAnglais.class);
        startActivity(intent);
    }
    
}