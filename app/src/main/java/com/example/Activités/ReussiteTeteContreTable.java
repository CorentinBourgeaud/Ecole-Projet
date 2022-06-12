package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Activités.model.DatabaseClient;
import com.example.Activités.model.User;
import com.example.projetandroid.R;

public class ReussiteTeteContreTable extends AppCompatActivity {

    private User user;
    private DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussite_tete_contre_table);
        user = ((MyApplication) getApplication()).getUser();
        mDb = DatabaseClient.getInstance(getApplicationContext());
        updateUser();
    }

    public void changeAcceuil(View view) {
        Intent intent = new Intent(this, Accueil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void changeChoixTeteContreTable(View view) {
        Intent intent = new Intent(this, ChoixTeteContreTable.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void updateUser(){

        class GetUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids){
                user = ((MyApplication) getApplication()).getUser();

                user.setXp(user.getXp()+1);
                user.setXpMaths(user.getXpMaths()+1);

                mDb.getAppDatabase()
                        .userDao()
                        .update(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
            }
        }
        GetUser gu = new GetUser();
        gu.execute();


    }
}