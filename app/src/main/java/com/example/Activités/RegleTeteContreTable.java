package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class RegleTeteContreTable extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle_tete_contre_table);
        user = ((MyApplication) getApplication()).getUser();
    }

    public void retour (View view){
        super.finish();
    }
}