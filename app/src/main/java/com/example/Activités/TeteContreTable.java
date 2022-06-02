package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projetandroid.R;

public class TeteContreTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tete_contre_table);
    }

    public void changeChoixTeteContreTable(View view) {
        Intent intent = new Intent(this, ChoixTeteContreTable.class);
        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }
}