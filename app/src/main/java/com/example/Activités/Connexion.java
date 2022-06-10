package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Activités.model.UsersAdapter;
import com.example.projetandroid.R;

import com.example.Activités.model.DatabaseClient;
import com.example.Activités.model.User;

import java.util.ArrayList;
import java.util.List;

public class Connexion extends AppCompatActivity {

    private UsersAdapter adapter;
    private DatabaseClient mDb;
    private ListView listUser;
    ;

    private EditText editTextLogin;
    private EditText editTextMdp;
    private Button valider;

    public User user;

    public static final ArrayList<Integer> listeAvatar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        listeAvatar.add(R.drawable.pikachu);

        mDb = DatabaseClient.getInstance(getApplicationContext());


        listUser = findViewById(R.id.listUser);

        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = adapter.getItem(i);
                Toast.makeText(Connexion.this, "Clic sur " + user.getLogin(), Toast.LENGTH_SHORT).show();

                ((MyApplication) getApplication()).setUser(user);

                Intent intent = new Intent(Connexion.this, Accueil.class);
                startActivity(intent);

            }
        });

        mDb = DatabaseClient.getInstance(getApplicationContext());

        editTextLogin = findViewById(R.id.conn_login_inscription);
        editTextMdp = findViewById(R.id.conn_mdp_inscription);
        valider = findViewById(R.id.inscription_valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }


        });
    }


    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                adapter.clear();
                adapter.addAll(users);

                adapter.notifyDataSetChanged();

            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        GetUsers gt = new GetUsers();
        gt.execute();
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des taches
        getUsers();

    }

    private void saveUser() {
        final String sLogin = editTextLogin.getText().toString().trim();
        final String sMdp = editTextMdp.getText().toString().trim();

        if (sLogin.isEmpty()) {
            editTextLogin.setError("Login nécessaire");
            editTextLogin.requestFocus();
            return;
        }

        if (sMdp.isEmpty()) {
            editTextMdp.setError("Mot de passe nécessaire");
            editTextMdp.requestFocus();
            return;
        }

        class SaveTask extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setLogin(sLogin);
                user.setPrénom(sMdp);
                user.setXp(0);
                user.setXpMaths(0);
                user.setXpAnglais(0);
                user.setXpGeo(0);

                // adding to database
                mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                setResult(RESULT_OK);
                Toast.makeText(getApplicationContext(), "Inscription sauvegardée.<", Toast.LENGTH_LONG).show();

            }

        }
        SaveTask st = new SaveTask();
        st.execute();
        Intent intent = new Intent(Connexion.this, Connexion.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

}
