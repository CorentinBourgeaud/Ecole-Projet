package com.example.Activités;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetandroid.R;

import com.example.Activités.model.DatabaseClient;
import com.example.Activités.model.AppDatabase;
import com.example.Activités.model.User;
import com.example.Activités.model.UserDao;

public class TestUtilisateur extends AppCompatActivity {

    private DatabaseClient mDb;

    private EditText editTextLogin;
    private EditText editTextMdp;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_utilisateur);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        editTextLogin = findViewById(R.id.login);
        editTextMdp = findViewById(R.id.mdp);
        valider = findViewById(R.id.conn_valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });
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
                user.setPassword(sMdp);

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
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

            }
        }
        SaveTask st = new SaveTask();
        st.execute();

    }
}



