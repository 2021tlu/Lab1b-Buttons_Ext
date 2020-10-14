package com.luthomas.lab1b_buttonsextension;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    // TextView title = findViewById(R.id.title);
    TextView numText;
    TextView turnText;
    int count = 0;
    int turn = 0;
    int overFlag = 0;
    /* Button one = findViewById(R.id.one);
    Button two = findViewById(R.id.two);
    Button three = findViewById(R.id.three); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numText = findViewById(R.id.numText);
        turnText = findViewById(R.id.turnText);
    }
    public void resetGame(View view){
        count = 0;
        turn = 0;
        overFlag = 0;
        numText.setText("" + count);
        turnText.setText(getTurnText(turn));
    }
    public void changeNumText(View view) {
        Log.i("buttonResponse:", (String) view.getTag());
        count += Integer.parseInt((String) view.getTag());
        if (count >= 21) {
            if (overFlag == 0) {
                overFlag = 1;
                numText.setText("" + count);
                String overText = getOverText(turn); // find over text with current turn
                turnText.setText(overText);
            }
        }
        else {
            turn += 1;
            numText.setText("" + count); //+ funText(count));
            turnText.setText(getTurnText(turn));
        }
    }
    public String funText(int count){
        String fun = " :D";
        for(int i = 1; i < count/5; i++)
            fun += "D";
        return fun;
    }
    public String getTurnText(int turn){
        return "Player " + ((turn%2)+1) + "'s Turn";
    }
    public String getOverText(int turn){ // turn given is loser's turn
        return "Player " + (((turn+1)%2)+1) + " Wins!";
    }
}