package com.example.a15_puzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Board board;
    private Button[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the board and buttons
        board = new Board();
        buttons = new Button[4][4];
        buttons[0][0] = findViewById(R.id.button_1);
        buttons[0][1] = findViewById(R.id.button_2);
        buttons[0][2] = findViewById(R.id.button_3);
        buttons[0][3] = findViewById(R.id.button_4);
        buttons[1][0] = findViewById(R.id.button_5);
        buttons[1][1] = findViewById(R.id.button_6);
        buttons[1][2] = findViewById(R.id.button_7);
        buttons[1][3] = findViewById(R.id.button_8);
        buttons[2][0] = findViewById(R.id.button_9);
        buttons[2][1] = findViewById(R.id.button_10);
        buttons[2][2] = findViewById(R.id.button_11);
        buttons[2][3] = findViewById(R.id.button_12);
        buttons[3][0] = findViewById(R.id.button_13);
        buttons[3][1] = findViewById(R.id.button_14);
        buttons[3][2] = findViewById(R.id.button_15);
        buttons[3][3] = findViewById(R.id.button_16);

        // Calls the shuffleBoard method
        shuffleBoard();

        // Update the button text with the initial state of the board
        updateButtons();

        // Set click listeners for the buttons
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int row = i;
                final int col = j;
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Check if the clicked button is adjacent to the empty space
                        if (isAdjacentToEmptySpace(row, col)) {
                            // Move the tile to the empty space
                            board.moveTile(row, col, getEmptySpaceRow(), getEmptySpaceCol());
                            // Update the button text and check for win condition
                            updateButtons();
                            if (board.isSolved()) {
                                Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        }
    }

    private void updateButtons() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int value = board.getTile(i, j);
                buttons[i][j].setText(value == 0 ? "" : Integer.toString(value));
            }
        }
    }

    private boolean isAdjacentToEmptySpace(int row, int col) {
        int emptySpaceRow = getEmptySpaceRow();
        int emptySpaceCol = getEmptySpaceCol();
        return (row == emptySpaceRow && Math.abs(col - emptySpaceCol) == 1) ||
                (col == emptySpaceCol && Math.abs(row - emptySpaceRow) == 1);
    }

    private int getEmptySpaceRow() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.getTile(i, j) == 0) {
                    return i;
                }
            }
        }
        return -1; // should never happen
    }

    private int getEmptySpaceCol() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.getTile(i, j) == 0) {
                    return j;
                }
            }
        }
        // If there is no empty space, return -1 to indicate an error
        return -1;
    }
    private void shuffleBoard() {
        Random random = new Random();

        // Shuffle the board by making a random number of moves
        int numMoves = random.nextInt(100) + 50; // shuffle at least 50 times
        for (int i = 0; i < numMoves; i++) {
            int emptySpaceRow = getEmptySpaceRow();
            int emptySpaceCol = getEmptySpaceCol();

            // Choose a random tile to move
            int direction = random.nextInt(4);
            int tileRow = emptySpaceRow;
            int tileCol = emptySpaceCol;
            switch (direction) {
                case 0: // move up
                    tileRow--;
                    break;
                case 1: // move down
                    tileRow++;
                    break;
                case 2: // move left
                    tileCol--;
                    break;
                case 3: // move right
                    tileCol++;
                    break;
            }

            // Check if the move is valid
            if (tileRow >= 0 && tileRow < 4 && tileCol >= 0 && tileCol < 4) {
                board.moveTile(emptySpaceRow, emptySpaceCol, tileRow, tileCol);
            }
        }

        // Update the button text and background to match the board state
        updateButtons();
    }

}
