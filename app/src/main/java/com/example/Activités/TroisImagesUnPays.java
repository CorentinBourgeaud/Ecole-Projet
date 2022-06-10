package com.example.Activités;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.DatabaseClient;
import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.util.ArrayList;
import java.util.Random;

public class TroisImagesUnPays extends AppCompatActivity {

    private User user;

    private static final ArrayList<Integer> listDrapeau = new ArrayList<>();
    private static final ArrayList<String> listDrapeauStr = new ArrayList<>();
    public Random rand = new Random();
    public Random rand2 = new Random();
    public Random rand3 = new Random();

    public int flagCorrect = rand.nextInt(28);
    public int flag2 = rand2.nextInt(28);
    public int flag3 = rand3.nextInt(28);

    public int nbRound=0;
    public int roundWin;
    public int roundLose;

    public boolean dejaJoue=false;

    private DatabaseClient mDb;

    public int randChoix;


    public ImageView img;
    public ImageView img2;
    public ImageView img3;

    public Button btn;
    public TextView texte;

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;

    public ContentValues cv = new ContentValues();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_trois_images_un_pays);
        //user = (User) getIntent().getSerializableExtra("user");
        user = ((MyApplication) getApplication()).getUser();
        mDb = DatabaseClient.getInstance(getApplicationContext());



        listDrapeau.add(R.drawable.austria); listDrapeauStr.add("Autriche");
        listDrapeau.add(R.drawable.belgium); listDrapeauStr.add("Belgique");
        listDrapeau.add(R.drawable.bulgaria); listDrapeauStr.add("Bulgarie");
        listDrapeau.add(R.drawable.croatia); listDrapeauStr.add("Croatie");
        listDrapeau.add(R.drawable.cyprus);listDrapeauStr.add("Chypre");
        listDrapeau.add(R.drawable.czech);listDrapeauStr.add("République Tchèque");
        listDrapeau.add(R.drawable.denmark);listDrapeauStr.add("Danemark");
        listDrapeau.add(R.drawable.estonia);listDrapeauStr.add("Estonie");
        listDrapeau.add(R.drawable.europe);listDrapeauStr.add("Union Européenne");
        listDrapeau.add(R.drawable.finland);listDrapeauStr.add("Finlande");
        listDrapeau.add(R.drawable.france);listDrapeauStr.add("France");
        listDrapeau.add(R.drawable.germany);listDrapeauStr.add("Allemagne");
        listDrapeau.add(R.drawable.greece);listDrapeauStr.add("Grèce");
        listDrapeau.add(R.drawable.hungary);listDrapeauStr.add("Hongrie");
        listDrapeau.add(R.drawable.ireland);listDrapeauStr.add("Irlande");
        listDrapeau.add(R.drawable.italy);listDrapeauStr.add("Italie");
        listDrapeau.add(R.drawable.latvia);listDrapeauStr.add("Lettonie");
        listDrapeau.add(R.drawable.lithuania);listDrapeauStr.add("Lituanie");
        listDrapeau.add(R.drawable.luxembourg);listDrapeauStr.add("Luxembourg");
        listDrapeau.add(R.drawable.malta);listDrapeauStr.add("Malte");
        listDrapeau.add(R.drawable.netherlands);listDrapeauStr.add("Pays Bas");
        listDrapeau.add(R.drawable.poland);listDrapeauStr.add("Pologne");
        listDrapeau.add(R.drawable.portugal);listDrapeauStr.add("Portugal");
        listDrapeau.add(R.drawable.romania);listDrapeauStr.add("Roumanie");
        listDrapeau.add(R.drawable.slovakia);listDrapeauStr.add("Slovaquie");
        listDrapeau.add(R.drawable.slovenia);listDrapeauStr.add("Slovénie");
        listDrapeau.add(R.drawable.spain);listDrapeauStr.add("Espagne");
        listDrapeau.add(R.drawable.sweden);listDrapeauStr.add("Suède");
        listDrapeau.add(R.drawable.uk);listDrapeauStr.add("Royaume Uni");


    }

    public void randomFlag(View v){


        dejaJoue=false;
        flagCorrect =rand.nextInt(29);
        flag2 = rand2.nextInt(29);
        flag3 = rand3.nextInt(29);


        while(flagCorrect == flag2 || flag3 == flagCorrect || flag2 == flag3){
            flag2 = rand2.nextInt(29);
            flag3 = rand3.nextInt(29);
        }

        texte=findViewById(R.id.textPlay1);
        texte.setText("Nombre de rounds joués : "+nbRound);
        nbRound++;

        randChoix = rand.nextInt(3);


        btn4 = findViewById(R.id.btnPlay);
        btn4.setVisibility(v.INVISIBLE);
        btn1 = findViewById(R.id.btn01);
        btn1.setVisibility(v.VISIBLE);
        btn2 = findViewById(R.id.btn02);
        btn2.setVisibility(v.VISIBLE);
        btn3 = findViewById(R.id.btn03);
        btn3.setVisibility(v.VISIBLE);

        texte=findViewById(R.id.nomPays);
        texte.setVisibility(v.VISIBLE);
        texte.setText(listDrapeauStr.get(flagCorrect));
        texte=findViewById(R.id.consigne);
        texte.setVisibility(v.VISIBLE);


        img = findViewById(R.id.img1);
        img.setVisibility(v.VISIBLE);

        img2 = findViewById(R.id.img2);
        img2.setVisibility(v.VISIBLE);

        img3 = findViewById(R.id.img3);
        img3.setVisibility(v.VISIBLE);


        if(randChoix==1) {
            img.setImageResource(listDrapeau.get(flagCorrect));
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    win(v);
                }
            });
            img2.setImageResource(listDrapeau.get(flag2));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            img3.setImageResource(listDrapeau.get(flag3));
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
        }
        else if(randChoix==2){
            img.setImageResource(listDrapeau.get(flag2));
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            img2.setImageResource(listDrapeau.get(flagCorrect));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    win(v);
                }
            });
            img3.setImageResource(listDrapeau.get(flag3));
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
        }
        else{
            img.setImageResource(listDrapeau.get(flag3));
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            img2.setImageResource(listDrapeau.get(flag2));
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lose(v);
                }
            });
            img3.setImageResource(listDrapeau.get(flagCorrect));
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    win(v);
                }
            });
        }

    }

    public void retour (View view){
        super.finish();
    }

    public void win(View v){
        if (!dejaJoue) {
            roundWin++;
            dejaJoue=true;
            texte=findViewById(R.id.textWin1);
            texte.setText("Nombre de rounds gagnés : "+roundWin);
            texte=findViewById(R.id.txtWin);
            texte.setVisibility(v.VISIBLE);
            texte.setText("C'est gagné ! Bien joué.");
            TextView testxp = findViewById(R.id.txtWin);
            user.setXp(user.getXp()+1);
            //testxp.setText(user.getXp());
            //mDb.getAppDatabase().userDao().update(user);
            //mDb.getAppDatabase().userDao().update(user.getXp(), user.getNumProfil());

            //((MyApplication) getApplication()).setUser(user);

            randomFlag(v);
        }
    }

    public void lose(View v){
        if(!dejaJoue) {
            roundLose++;
            dejaJoue=true;
            texte=findViewById(R.id.textLose1);
            texte.setText("Nombre de rounds perdus : "+roundLose);
            texte=findViewById(R.id.txtWin);
            texte.setVisibility(v.VISIBLE);
            texte.setText("C'est perdu... Dommage !");
            randomFlag(v);
        }
    }


}