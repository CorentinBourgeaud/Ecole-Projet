package com.example.Activités;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class MenuGeographie extends AppCompatActivity {

    private User user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_geographie);
        user = (User) getIntent().getSerializableExtra("user");

    }


    public void changeTroisImagesUnPays(View v){
        Intent intent = new Intent(this, TroisImagesUnPays.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void changeUneImageUnPays(View v){
        Intent intent = new Intent (this, UnPaysTroisImage.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }
}