package com.example.speakout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
MediaPlayer mp1,mp2;
int count=0;
ImageButton ib1;
public void playSong(View view) {
    ++count;
    ImageButton ib2=(ImageButton)view;
    Log.i("button pressed",ib2.getTag().toString());
        mp2 = MediaPlayer.create(this, getResources().getIdentifier(ib2.getTag().toString(), "raw", getPackageName()));

        if(count>1) {
            ib1.animate().scaleX(1).scaleY(1).setDuration(300);
            ib2.animate().scaleX(1.5f).scaleY(1.5f).setDuration(1000);
            if (mp1.isPlaying()) {
                mp1.stop();
                mp2.start();
            }
            else
            {
                mp2.start();
            }
        }
        else
        { mp2.start();
            ib2.animate().scaleX(1.5f).scaleY(1.5f).setDuration(1000);
        }
    ib1=ib2;
    mp1=mp2;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}