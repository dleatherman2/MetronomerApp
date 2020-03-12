package com.example.metronomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView metMove;
    private ImageButton metButton;
    private MoveBank moveBank;
    private List<String> moveList = new ArrayList<String>();
    private String filename = "move_list";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveBank = new MoveBank(this);
        moveList = moveBank.readLines(filename);


        /*moveList.add("Focus Punch!");
        moveList.add("Destiny Bond!");
        moveList.add("Mirror Coat!");
        moveList.add("Relic Song!");
        moveList.add("I need your list of moves if you want more moves!");
*/
        metMove = findViewById((R.id.metMove));
        metButton = findViewById(R.id.metButton);
        metButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useMetronome(view);
            }
        });
    }

    public void useMetronome(View view) {
        Random random = new Random();

        metMove.setText(moveList.get(random.nextInt(moveList.size())) + "!");
    }

    private void readFileAsList() {
        String file = "/move_list.txt";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line !=null) {
                moveList.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
