package com.example.chuik.elephant;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LevelFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        LinearLayout main_layout = this.findViewById(R.id.linear);

        List<HashMap<String, String>> object = new ArrayList<>();
        object.add(new HashMap<String, String>() {{
            put("text", "do");
            put("resource", "c");
            put("image", "tren");
        }});
        object.add(new HashMap<String, String>() {{
            put("text", "re");
            put("resource", "d");
            put("image", "rein");
        }});
        object.add(new HashMap<String, String>() {{
            put("text", "mi");
            put("resource", "e");
            put("image", "mercy");
        }});
        object.add(new HashMap<String, String>() {{
            put("text", "fa");
            put("resource", "f");
            put("image", "dva");
        }});
        object.add(new HashMap<String, String>() {{
            put("text", "sol");
            put("resource", "g");
            put("image", "genji");
        }});
        object.add(new HashMap<String, String>() {{
            put("text", "la");
            put("resource", "a");
            put("image", "rein");
        }});
        object.add(new HashMap<String, String>() {{
            put("text", "si");
            put("resource", "b");
            put("image", "mercy2");
        }});

        for (final HashMap reg : object){
            ImageButton nuevo = new ImageButton(this);
            //nuevo.setBackgroundResource(R.drawable.boton);
            nuevo.setImageResource(getResId("nota_" + reg.get("text"), R.drawable.class));
            nuevo.setBackgroundColor(Color.argb(0, 255,  255, 255));
            //nuevo.setImageURI(Uri.parse("android.resource://" + getPackageName() + "/drawable/nota_" + reg.get("text") + ".png"));
            main_layout.addView(nuevo);
            final int resId = getResId((String) reg.get("resource"), R.raw.class);
            nuevo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playRandomSound(resId);
                }
            });
        }
    }


    private void playRandomSound(int resId) {
        SoundPlayer.playSound(this, resId);
    }



    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
