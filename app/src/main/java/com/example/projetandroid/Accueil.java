package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

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
    
}