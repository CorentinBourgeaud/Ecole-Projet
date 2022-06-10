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

public class TeteContreTable extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tete_contre_table);
        user = ((MyApplication) getApplication()).getUser();
    }

    public void changeChoixTeteContreTable(View view) {
        Intent intent = new Intent(this, ChoixTeteContreTable.class);
        startActivity(intent);
    }

    public void changeRegleTeteContreTable(View view) {
        Intent intent = new Intent(this, RegleTeteContreTable.class);
        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }
}