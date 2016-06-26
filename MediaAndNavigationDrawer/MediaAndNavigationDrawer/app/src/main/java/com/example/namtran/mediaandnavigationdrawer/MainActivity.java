package com.example.namtran.mediaandnavigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

    Button btnstop,btnstart,btnpause,btntangvolumn,btngiamvolumn;
    SeekBar skbmusic,skbvolumn;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    int totalTime;
    int currentTime;
    TextView txtgetTime,txtFullTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstop = (Button) findViewById(R.id.btnstop);
        btnstart = (Button) findViewById(R.id.btnstart);
        btnpause = (Button) findViewById(R.id.btnpause);
        btntangvolumn = (Button) findViewById(R.id.btntangvolumn);
        btngiamvolumn = (Button) findViewById(R.id.btngiamvolumn);

        txtgetTime = (TextView) findViewById(R.id.txtgetTime);
        txtFullTime = (TextView) findViewById(R.id.txtFulltime);

        skbmusic = (SeekBar) findViewById(R.id.skbmusic);
        skbvolumn = (SeekBar) findViewById(R.id.skbvolumn);


        mediaPlayer = MediaPlayer.create(this,R.raw.hug);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        btnstart.setOnClickListener(this);
        btnpause.setOnClickListener(this);
        btnstop.setOnClickListener(this);
        btntangvolumn.setOnClickListener(this);
        btngiamvolumn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnstart)
        {
            mediaPlayer.start();
        }
        else if (id == R.id.btnpause)
        {
            mediaPlayer.pause();
        }else if (id == R.id.btnstop)
        {
            mediaPlayer.stop();
        }else if (id == R.id.btntangvolumn)
        {

        }else if (id == R.id.btngiamvolumn)
        {

        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        totalTime = mediaPlayer.getDuration();
        currentTime = mediaPlayer.getCurrentPosition();

        txtFullTime.setText(stringForTime(totalTime));
        skbmusic.setMax(totalTime);
        skbmusic.setProgress(currentTime);
        txtgetTime.setText(stringForTime(currentTime));

        skbvolumn.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        skbvolumn.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

    }
    private String stringForTime( int time)
    {
        int totalseconds = time/1000;

        int second = totalseconds %60;
        int minute = (totalseconds/60)%60;
        return String.format("%02d:%02d",minute,second).toString();
    }
}
