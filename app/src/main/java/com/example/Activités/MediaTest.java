package com.example.Activités;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Activités.model.User;
import com.example.projetandroid.R;


public class MediaTest extends AppCompatActivity {
    MediaPlayer player;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player_test);
    }

    public void play(View v){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.song);
        }
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlayer();
            }
        });
    }

    public void pause(View v){
        if (player != null){
            player.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "Media player released", Toast.LENGTH_SHORT).show();
        }
    }



}
