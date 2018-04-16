package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        TextView play3x3 = (TextView)findViewById(R.id.play3x3);

        play3x3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create a new intent to open the {@link AboutActivity}
                        Intent intent;
                        intent  = new Intent(GameMenu.this, com.example.android.tic_tac_toe.PlayGame_3x3.class);
                        startActivity(intent);
                    }
                });

        TextView play5x5 = (TextView)findViewById(R.id.play5x5);

        play5x5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create a new intent to open the {@link AboutActivity}
                        Intent intent;
                        intent  = new Intent(GameMenu.this, com.example.android.tic_tac_toe.PlayGame_5x5.class);
                        startActivity(intent);
                    }
                });
    }
}
