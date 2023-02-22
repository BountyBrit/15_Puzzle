package com.example.gridclikr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[4][4];

        gameView.addButton(0,0,findViewById(R.id.b_11);
        gameView.addButton(0,1, findViewById(R.id.b_12);
        gameView.addButton(0,2, findViewById(R.id.b_13);
        gameView.addButton(0,3, findViewById(R.id.b_14);
        gameView.addButton(1,0, findViewById(R.id.b_21);
        gameView.addButton(1,1, findViewById(R.id.b_22);
        gameView.addButton(1,2, findViewById(R.id.b_23);
        gameView.addButton(1,3, findViewById(R.id.b_24);
        gameView.addButton(2,0, findViewById(R.id.b_31);
        gameView.addButton(2,1, findViewById(R.id.b_32);
        gameView.addButton(2,2, findViewById(R.id.b_33);
        gameView.addButton(2,3, findViewById(R.id.b_34);
        gameView.addButton(3,0, findViewById(R.id.b_41);
        gameView.addButton(3,1, findViewById(R.id.b_42);
        gameView.addButton(3,2, findViewById(R.id.b_43);
        gameView.addButton(3,3, findViewById(R.id.b_44);

        Random rng = new Random();
        int row = rng.nextInt(4);
        int col = rng.nextInt(4);

        buttons[row][col].setVisibility(View.VISIBLE);
        buttons[row][col].setClickable(true);

    }
}