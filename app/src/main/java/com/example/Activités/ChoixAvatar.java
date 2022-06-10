package com.example.Activités;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ChoixAvatar extends AppCompatActivity {

private User user;
private ArrayList<Integer> listAvatar = new ArrayList<>();
private ListView listeAvatar;
private ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_avatar);
        user = ((MyApplication) getApplication()).getUser() ;
        listAvatar = ((MyApplication) getApplication()).getListAvatar();

        listeAvatar.findViewById(R.id.listAvatar);
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listAvatar);
        listeAvatar.setAdapter(adapter);

    }
}
