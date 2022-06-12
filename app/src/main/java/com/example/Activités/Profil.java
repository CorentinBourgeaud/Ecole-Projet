package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.util.ArrayList;


public class Profil extends AppCompatActivity {

    private User user;
    private ArrayList<Integer> listAvatar = new ArrayList<>();
    private TextView text;
    private ImageView img;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        user = ((MyApplication) getApplication()).getUser();
        listAvatar = ((MyApplication) getApplication()).getListAvatar();

        text = findViewById(R.id.titreProfil);
        text.setText(text.getText() + " " + user.getLogin());

        text = findViewById(R.id.login);
        text.setText(text.getText() + " " + user.getLogin());
        text = findViewById(R.id.prenom);
        text.setText(text.getText() + " " + user.getPrénom());


        text = findViewById(R.id.nvGeneral);
        text.setText(text.getText() + " " + (int)user.getXp()/50);
        text = findViewById(R.id.nvMaths);
        text.setText(text.getText() + " " + (int)user.getXpMaths()/25);
        text = findViewById(R.id.nvGeo);
        text.setText(text.getText() + " " + (int)user.getXpGeo()/25);
        text = findViewById(R.id.nvAnglais);
        text.setText(text.getText() + " " + (int)user.getXpAnglais()/25);

        img = findViewById(R.id.avatar);
        img.setImageResource(listAvatar.get(user.getNumProfil()));






    }


    public void deconnexion(View v){
        Intent intent = new Intent(Profil.this, Connexion.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Toast.makeText(getApplicationContext(), "Déconnexion réussie.", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    public void retour(View v){
        super.finish();
    }



}
