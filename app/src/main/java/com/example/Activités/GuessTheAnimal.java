package com.example.Activités;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.R;

import java.util.ArrayList;
import java.util.Random;

public class GuessTheAnimal extends AppCompatActivity {
    MediaPlayer player;
    public int random;
    public static final ArrayList<Integer> listAnimals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_animal);
        //listAnimals = new ArrayList<>();
        listAnimals.add(R.raw.dog);
        listAnimals.add(R.raw.cat);
        listAnimals.add(R.raw.horse);
        listAnimals.add(R.raw.cow);
        listAnimals.add(R.raw.lion);
        listAnimals.add(R.raw.duck);
        listAnimals.add(R.raw.tiger);

    }



    public void play(View v){
        random = new Random().nextInt(6);
        if(player == null){
            player = MediaPlayer.create(this, listAnimals.get(random));
        }
        player.start();

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlayer();
            }
        });
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "Media player released", Toast.LENGTH_SHORT).show();
        }
    }





}
