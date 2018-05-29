package com.example.hamza.tictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class game extends Activity {
    Button b,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    boolean player1 = true;
    boolean gameOver = false;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
    }

    public void buttonClicked(View view) {
        b = findViewById(view.getId());
        if(!gameOver) {
            if(b.isClickable()) {
                count++;
                if(player1) {
                    b.setBackgroundResource(R.drawable.check);
                    b.setText("10");
                    b.setTextColor(0x0033cc);
                }
                else {
                    b.setBackgroundResource(R.drawable.x);
                    b.setText("11");
                    b.setTextColor(0x0033cc);
                }
                player1=!player1;
            }
            b.setClickable(false);
            check();
        }
    }

    public void check() {
        //rows
        if(b1.getText().equals(b2.getText()) &&
                b2.getText().equals(b3.getText())) {
            endGame(b1,b2,b3);
        }
        else if(b4.getText().equals(b5.getText()) &&
                b5.getText().equals(b6.getText())) {
            endGame(b4,b5,b6);
        }
        else if(b7.getText().equals(b8.getText()) &&
                b8.getText().equals(b9.getText())) {
            endGame(b7,b8,b9);
        }
        //coloumns
        else if(b1.getText().equals(b4.getText()) &&
                b4.getText().equals(b7.getText())) {
            endGame(b1,b4,b7);
        }
        else if(b2.getText().equals(b5.getText()) &&
                b5.getText().equals(b8.getText())) {
            endGame(b2,b5,b8);
        }
        else if(b3.getText().equals(b6.getText()) &&
                b6.getText().equals(b9.getText())) {
            endGame(b3,b6,b9);
        }
        //diagnal
        else if(b1.getText().equals(b5.getText()) &&
                b5.getText().equals(b9.getText())) {
            endGame(b1,b5,b9);
        }
        else if(b3.getText().equals(b5.getText()) &&
                b5.getText().equals(b7.getText())) {
            endGame(b3,b5,b7);
        }
        else if(count == 9) {
            Toast toast = Toast.makeText(getApplicationContext(), "Draw", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void endGame(Button ob, Button sb, Button tb) {
        String text;
        if(!player1)
            text="Player 1 won";
        else
            text="Player 2 won";
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
        toast.show();
        ob.setAlpha((float)0.15);
        ob.setText("");
        ob.setBackgroundColor(Color.BLUE);
        sb.setAlpha((float)0.15);
        sb.setText("");
        sb.setBackgroundColor(Color.BLUE);
        tb.setAlpha((float)0.15);
        tb.setText("");
        tb.setBackgroundColor(Color.BLUE);
        gameOver=true;
    }

}
