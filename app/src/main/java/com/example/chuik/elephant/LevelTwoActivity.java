package com.example.chuik.elephant;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LevelTwoActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);

        LinearLayout linearLayout = this.findViewById(R.id.linearLvl2);
        List<HashMap<String, String>> notesList = new ArrayList<>();

        notesList.add(new HashMap<String, String>() {{
            put("text", "Do");
            put("resource", "c");
            put("image", "dva");
        }});
        notesList.add(new HashMap<String, String>() {{
            put("text", "Re");
            put("resource", "d");
            put("image", "rein");
        }});
        notesList.add(new HashMap<String, String>() {{
            put("text", "Mi");
            put("resource", "e");
            put("image", "mercy");
        }});
        notesList.add(new HashMap<String, String>() {{
            put("text", "Fa");
            put("resource", "f");
            put("image", "dva");
        }});

        Notes noteRender = new Notes(this, notesList);
        noteRender.setOnClickActions(true, true);
        noteRender.renderButtons(linearLayout);
    }
}
