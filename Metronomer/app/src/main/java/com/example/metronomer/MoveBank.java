package com.example.metronomer;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MoveBank {

    private Context context;

    public MoveBank(Context c) {
        this.context = c;
    }

    public List<String> readLines(String filename) {
        List<String> moves = new ArrayList<String>();

        AssetManager assetManager = context.getAssets();

        try {
            InputStream inputStream = assetManager.open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();

            while (line != null) {
                moves.add(line);
                line = reader.readLine();
            }
            inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

        return moves;
    }
}
