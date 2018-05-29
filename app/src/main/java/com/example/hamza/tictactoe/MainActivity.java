package com.example.hamza.tictactoe;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    boolean player1 = true;
    boolean gameOver = false;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
    }

    public void buttonClicked(View view) {
        b = (Button)findViewById(view.getId());
        if(!gameOver) {
            if(b.isClickable()) {
                count++;
                if(player1) {
                    b.setBackgroundResource(R.drawable.check);
                    b.setText("10");
                }
                else {
                    b.setBackgroundResource(R.drawable.x);
                    b.setText("11");
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
        if(b4.getText().equals(b5.getText()) &&
                b5.getText().equals(b6.getText())) {
            endGame(b4,b5,b6);
        }
        if(b7.getText().equals(b8.getText()) &&
                b8.getText().equals(b9.getText())) {
            endGame(b7,b8,b9);
        }
        //coloumns
        if(b1.getText().equals(b4.getText()) &&
                b4.getText().equals(b7.getText())) {
            endGame(b1,b4,b7);
        }
        if(b2.getText().equals(b5.getText()) &&
                b5.getText().equals(b8.getText())) {
            endGame(b2,b5,b8);
        }
        if(b3.getText().equals(b6.getText()) &&
                b6.getText().equals(b9.getText())) {
            endGame(b3,b6,b9);
        }
        //diagnal
        if(b1.getText().equals(b5.getText()) &&
                b5.getText().equals(b9.getText())) {
            endGame(b1,b5,b9);
        }
        if(b3.getText().equals(b5.getText()) &&
                b5.getText().equals(b7.getText())) {
            endGame(b3,b5,b7);
        }
        if(count == 9) {
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
        ob.setBackgroundColor(Color.CYAN);
        sb.setAlpha((float)0.15);
        sb.setText("");
        sb.setBackgroundColor(Color.CYAN);
        tb.setAlpha((float)0.15);
        tb.setText("");
        tb.setBackgroundColor(Color.CYAN);
        gameOver=true;
    }
}
