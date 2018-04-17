
package com.example.android.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class PlayGame_5x5 extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[5][5];
    private int roundCount;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private int player1Points;
    private int player2Points;
    private boolean player1Turn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game_5x5);

        textViewPlayer1 = findViewById(R.id.player_1_view);
        textViewPlayer2 = findViewById(R.id.player_2_view);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 25) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }

    private boolean checkForWin() {
        String[][] board = new String[3][3];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])
                    && board[i][0].equals(board[i][3])
                    && board[i][0].equals(board[i][4])
                    && !board[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && board[0][i].equals(board[3][i])
                    && board[0][i].equals(board[4][i])
                    && !board[0][i].equals("")) {
                return true;
            }
        }

        if (board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])
                && board[0][0].equals(board[3][3])
                && board[0][0].equals(board[4][4])
                && !board[0][0].equals("")) {
            return true;
        }

        if (board[0][4].equals(board[1][3])
                && board[0][4].equals(board[2][2])
                && board[0][4].equals(board[3][1])
                && board[0][4].equals(board[4][0])
                && !board[0][4].equals("")) {
            return true;
        }

        return false;
    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "     Player 1 wins!     ", Toast.LENGTH_LONG).show();
        updatePoints();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "     Player 2 wins!     ", Toast.LENGTH_LONG).show();
        updatePoints();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePoints() {
        textViewPlayer1.setText("Player 1: " + player1Points);
        textViewPlayer2.setText("Player 2: " + player2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame() {
        player1Points = 0;
        player2Points = 0;
        updatePoints();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }


}
