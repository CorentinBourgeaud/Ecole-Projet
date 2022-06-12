package com.example.Activités;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.DatabaseClient;
import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.util.ArrayList;
import java.util.Random;

public class UnPaysTroisImage extends AppCompatActivity {

    private User user;



    private static ArrayList<Integer> listDrapeau = new ArrayList<>();
    private static ArrayList<String> listDrapeauStr = new ArrayList<>();
    public Random rand = new Random();
    public Random rand2 = new Random();
    public Random rand3 = new Random();

    public int flagCorrect = rand.nextInt(28);
    public int flag2 = rand2.nextInt(28);
    public int flag3 = rand3.nextInt(28);

    public int nbRound;
    public int roundWin;
    public int roundLose;

    public boolean dejaJoue=false;

    public int randChoix;

    private DatabaseClient mDb;


    public ImageView img;
    public ImageView img2;
    public ImageView img3;

    public Button btn;
    public TextView texte;

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_une_image_trois_pays);
        user = ((MyApplication) getApplication()).getUser();
        mDb = DatabaseClient.getInstance(getApplicationContext());

        //va chercher dans la variable globale les tableaux contenant les Resource Id des images, ainsi que les string qui vont avec
        listDrapeau = ((MyApplication) getApplication()).getListDrapeau();
        listDrapeauStr = ((MyApplication) getApplication()).getListDrapeauStr();

    }

    public void randomFlag(View v){
        dejaJoue=false;

        flagCorrect =rand.nextInt(29);
        flag2 = rand2.nextInt(29);;
        flag3 = rand3.nextInt(29);



        while(flagCorrect == flag2 || flag3 == flagCorrect || flag2 == flag3){
            flag2 = rand2.nextInt(29);
            flag3 = rand3.nextInt(29);
        }

        randChoix = rand.nextInt(3);

        //rend les boutons de jeu visible
        btn4 = findViewById(R.id.btnPlay1);
        btn4.setVisibility(v.INVISIBLE);
        btn1 = findViewById(R.id.btn001);
        btn1.setVisibility(v.VISIBLE);
        btn2 = findViewById(R.id.btn002);
        btn2.setVisibility(v.VISIBLE);
        btn3 = findViewById(R.id.btn003);
        btn3.setVisibility(v.VISIBLE);

        texte=findViewById(R.id.textPlay01);
        texte.setText("Nombre de rounds joués : "+nbRound);

        texte=findViewById(R.id.consigne);
        texte.setVisibility(v.VISIBLE);

        //rend le drapeau consigne visible avec la nouvelle valeur
        img = findViewById(R.id.drapeau);
        img.setImageResource(listDrapeau.get(flagCorrect));
        img.setVisibility(v.VISIBLE);



        //Choisis aléatoirement quelle réponse est la bonne
        if(randChoix==1) {
            btn1.setText(listDrapeauStr.get(flagCorrect));
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    win(v);
                }
            });
            btn2.setText(listDrapeauStr.get(flag2));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            btn3.setText(listDrapeauStr.get(flag3));
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
        }
        else if(randChoix==2){
            btn1.setText(listDrapeauStr.get(flag2));
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            btn2.setText(listDrapeauStr.get(flagCorrect));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    win(v);
                }
            });
            btn3.setText(listDrapeauStr.get(flag3));
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
        }
        else{
            btn1.setText(listDrapeauStr.get(flag2));
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            btn2.setText(listDrapeauStr.get(flag3));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            btn3.setText(listDrapeauStr.get(flagCorrect));
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    win(v);
                }
            });
        }
        nbRound++;


    }

    public void retour (View view){
        super.finish();
    }

    public void win(View v){
        if (!dejaJoue) {
            roundWin++;
            dejaJoue=true;

            texte=findViewById(R.id.textWin01);
            texte.setText("Nombre de rounds gagnés : "+roundWin);
            texte=findViewById(R.id.txtWin1);
            texte.setVisibility(v.VISIBLE);
            texte.setText("C'est gagné ! Bien joué.");
        }
        //Appelle la dao pour mettre à jour l'utilisateur
        updateUser();
        randomFlag(v);
    }

    public void lose(View v){
        if(!dejaJoue) {
            roundLose++;
            dejaJoue=true;
            texte=findViewById(R.id.textLose01);
            texte.setText("Nombre de rounds perdus : "+roundLose);
            texte=findViewById(R.id.txtWin1);
            texte.setVisibility(v.VISIBLE);
            texte.setText("C'est perdu... Dommage !");
        }
        randomFlag(v);
    }

    private void updateUser(){

        class GetUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids){
                user = ((MyApplication) getApplication()).getUser();

                user.setXp(user.getXp()+1);
                user.setXpGeo(user.getXp()+1);

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