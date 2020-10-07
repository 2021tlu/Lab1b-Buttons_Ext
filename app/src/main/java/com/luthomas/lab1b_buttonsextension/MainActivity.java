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
    TextView numText = findViewById(R.id.numText);
    TextView turnText = findViewById(R.id.turnText);
    int count = 0;
    int turn = 0;
    /* Button one = findViewById(R.id.one);
    Button two = findViewById(R.id.two);
    Button three = findViewById(R.id.three); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void changeNumText(View view){
        Log.i("buttonResponse:", (String) view.getTag());
        count += Integer.parseInt((String) view.getTag());
        turn += 1;
        numText.setText("" + count + funText(count));
        turnText.setText(getTurnText(turn));
    }
    public String funText(int count){
        String fun = ":O";
        for(int i = 1; i < count/5; i++)
            fun += "O";
        return fun;
    }
    public String getTurnText(int count){
        return "Player " + ((count%2)+1) + "'s Turn";
    }
}