package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkConnect(View view){
        EditText loginView = findViewById(R.id.conn_login);
        String nom = loginView.getText().toString();
        Intent intent = new Intent(this, accueil.class);
        intent.putExtra("nom", nom);
        startActivity(intent);
    }
}

