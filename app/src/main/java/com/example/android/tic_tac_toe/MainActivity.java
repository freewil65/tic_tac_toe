package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView  play = (TextView)findViewById(R.id.play);

        play.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create a new intent to open the {@link GameMenu}
                        Intent playintent;
                        playintent  = new Intent(MainActivity.this, GameMenu.class);
                        startActivity(playintent);
                    }
                });

        TextView  about = (TextView)findViewById(R.id.about);

        about.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create a new intent to open the {@link AboutActivity}
                        Intent intent;
                        intent  = new Intent(MainActivity.this, com.example.android.tic_tac_toe.AboutActivity.class);
                        startActivity(intent);
                    }
                });

    }
}
