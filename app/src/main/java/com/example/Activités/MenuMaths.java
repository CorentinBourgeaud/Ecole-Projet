package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projetandroid.R;

public class MenuMaths extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_maths);
    }

    public void changeTeteContreTable(View view) {
        Intent intent = new Intent(this, TeteContreTable.class);
        startActivity(intent);
    }

    public void changeCalculeMoiSiTuPeux(View view) {
        Intent intent = new Intent(this, CalculeMoiSiTuPeux.class);
        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }
}