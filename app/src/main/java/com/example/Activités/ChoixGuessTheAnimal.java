package com.example.Activités;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.DatabaseClient;
import com.example.Activités.model.User;
import com.example.projetandroid.R;

import java.util.ArrayList;
import java.util.Random;

public class ChoixGuessTheAnimal extends AppCompatActivity {
    MediaPlayer player;
    public int random;
    public int random2;
    public int random3;
    public int randChoice;

    public static  ArrayList<Integer> listAnimals = new ArrayList<>();
    public static  ArrayList<String> listAnimalStr = new ArrayList<>();
    public static  ArrayList<Integer> listPhotoAnimals = new ArrayList<>();

    private DatabaseClient mDb;

    private int round = 0;
    private int roundWin = 0;
    private int roundLose = 0;


    public ImageView img;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView textWin;
    private TextView textLose;
    private TextView textPlay;
    private TextView textGame;

    public boolean flag = true;

    private User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_guess_the_animal);
        //user = (User) getIntent().getSerializableExtra("user");
        user = ((MyApplication) getApplication()).getUser();

        listAnimals = ((MyApplication) getApplication()).getListAnimals();
        listAnimalStr = ((MyApplication) getApplication()).getListAnimalStr();
        listPhotoAnimals = ((MyApplication) getApplication()).getListPhotoAnimals();

        mDb = DatabaseClient.getInstance(getApplicationContext());

    }



    public void play(View v) {
        stopPlayer();
        flag = true;
        img = findViewById(R.id.imgwin);
        img.setVisibility(v.INVISIBLE);
        textGame = findViewById(R.id.textGame);
        textGame.setVisibility(v.INVISIBLE);
        random = new Random().nextInt(10);
        random2 = random;
        random3 = random;
        if (player == null) {
            player = MediaPlayer.create(this, listAnimals.get(random));
        }
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        while(random2==random || random3==random || random2 == random3) {
            random3 = new Random().nextInt(10);
            random2 = new Random().nextInt(10);
        }

        randChoice = new Random().nextInt(3);

        btn1.setVisibility(v.VISIBLE);
        btn2.setVisibility(v.VISIBLE);
        btn3.setVisibility(v.VISIBLE);

        if(randChoice==1){
                btn1.setText(listAnimalStr.get(random));
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        win(v);
                    }
                });
                btn2.setText(listAnimalStr.get(random2));
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lose(v);
                    }
                });
                btn3.setText(listAnimalStr.get(random3));
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lose(v);
                    }
                });
            }
        else if(randChoice==2){
                btn1.setText(listAnimalStr.get(random2));
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lose(v);
                    }
                });
                btn2.setText(listAnimalStr.get(random));
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        win(v);
                    }
                });
                btn3.setText(listAnimalStr.get(random3));
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lose(v);
                    }
                });
            }
        else{
                btn1.setText(listAnimalStr.get(random2));
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lose(v);
                    }
                });
                btn2.setText(listAnimalStr.get(random3));
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lose(v);
                    }
                });
                btn3.setText(listAnimalStr.get(random));
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        win(v);
                    }
                });
            }


        player.start();

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
        });
        round++;
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "Media player released", Toast.LENGTH_SHORT).show();
        }
    }

    public void retour(View view){
        stopPlayer();
        super.finish();
    }

    public void win(View view){
        if (flag == true) {
            img.setImageResource(listPhotoAnimals.get(random));
            img.setVisibility(view.VISIBLE);
            textGame = findViewById(R.id.textGame);
            textGame.setText("\n   You won!\n   It was a "+ listAnimalStr.get(random)+"!!");
            textGame.setVisibility(view.VISIBLE);

            roundWin++;
            textWin = findViewById(R.id.textWin);
            textWin.setText("Nombre de rounds gagnés : " + roundWin);
            textPlay = findViewById(R.id.textPlay);
            textPlay.setText("Nombre de rounds joués : " + round);
            flag = false;
            updateUser();
        }


    }

    public void lose(View view){
        if (flag == true) {
            img = findViewById(R.id.imgwin);
            img.setImageResource(listPhotoAnimals.get(random));
            img.setVisibility(view.VISIBLE);
            textGame = findViewById(R.id.textGame);
            textGame.setText("\n   You lost...\n   It was a "+ listAnimalStr.get(random)+"!!");
            textGame.setVisibility(view.VISIBLE);

            roundLose++;
            textLose = findViewById(R.id.textLose);
            textLose.setText("Nombre de rounds perdus : " + roundLose);
            textPlay = findViewById(R.id.textPlay);
            textPlay.setText("Nombre de rounds joués : " + round);
            flag = false;
        }

    }

    private void updateUser(){

        class GetUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids){
                user = ((MyApplication) getApplication()).getUser();

                user.setXp(user.getXp()+1);
                user.setXpAnglais(user.getXpAnglais()+1);


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
