package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class ChoixTeteContreTable extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_tete_contre_table);

        user = ((MyApplication) getApplication()).getUser();

        NumberPicker picker = findViewById(R.id.TCT_nbrPicker);

        picker.setMaxValue(9);
        picker.setMinValue(1);
    }

    public void TCT_valider_choix(View view){
        NumberPicker picker = findViewById(R.id.TCT_nbrPicker);
        int valeurnbrpicker = picker.getValue();

        Intent intent = new Intent(this, MultiplicationsTeteContreTable.class);
        intent.putExtra(MultiplicationsTeteContreTable.TABLE_KEY, valeurnbrpicker);

        startActivity(intent);
    }

    public void retour (View view){
        super.finish();
    }
}