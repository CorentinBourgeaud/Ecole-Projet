package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projetandroid.R;

import java.util.ArrayList;

public class ErreurTeteContreTable extends AppCompatActivity {

    public static final String TABLE_KEY = "table_key";
    public static final String VAL_ERREUR = "valerreur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur_tete_contre_table);
    }

    public void changeChoixTeteContreTable(View view) {
        Intent intent = new Intent(this, ChoixTeteContreTable.class);
        startActivity(intent);
    }

    public void changeMultiplicationTeteContreTable(View view) {
        ArrayList<Integer> val_erreur= getIntent().getIntegerArrayListExtra(VAL_ERREUR);
        Intent intent = new Intent(this, MultiplicationsTeteContreTable.class);
        intent.putExtra(MultiplicationsTeteContreTable.VAL_ERREUR,val_erreur);
        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }

}