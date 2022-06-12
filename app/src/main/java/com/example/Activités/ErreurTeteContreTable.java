package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.util.ArrayList;

public class ErreurTeteContreTable extends AppCompatActivity {

    public static final String TABLE_KEY = "table_key";
    public static final String VAL_ERREUR = "valerreur";

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur_tete_contre_table);
        user = ((MyApplication) getApplication()).getUser();

    }

    public void changeChoixTeteContreTable(View view) {
        Intent intent = new Intent(this, ChoixTeteContreTable.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
    }

    public void retry(View view) {
        super.finish();
    }

    public void retour (View view){
        super.finish();
    }

}