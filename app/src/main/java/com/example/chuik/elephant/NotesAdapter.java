package com.example.chuik.elephant;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<Button> {
    public NotesAdapter(Context context, ArrayList<Button> buttonList){
        super(context, 0, buttonList);
    }

}
