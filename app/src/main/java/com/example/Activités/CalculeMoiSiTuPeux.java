package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class CalculeMoiSiTuPeux extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcule_moi_si_tu_peux);
        //user = (User) getIntent().getSerializableExtra("user");

        user = ((MyApplication) getApplication()).getUser();

    }

    public void retour (View view){
        super.finish();
    }
}