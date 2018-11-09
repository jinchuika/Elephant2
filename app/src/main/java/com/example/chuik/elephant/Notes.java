package com.example.chuik.elephant;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Notes {
    private List<HashMap<String, String>> notesList;
    private List<Button> buttonList = new ArrayList<>();
    private Context context;

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    public Notes(Context context, List<HashMap<String, String>> notesList){
        this.context = context;
        this.notesList = notesList;
        this.setButtonList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setButtonList(){
        for (final HashMap note : notesList){
            Button newButton = new Button(context);
            newButton.setText((String) note.get("text"));
            buttonList.add(newButton);
            newButton.setOnContextClickListener(new View.OnContextClickListener() {
                @Override
                public boolean onContextClick(View v) {
                    showImage("dva");
                    return false;
                }
            });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setOnClickButton(Button button, String noteId, boolean useImage, boolean playMusic){
        final MediaPlayer noteSound = createPlayer(noteId);
        button.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                noteSound.start();
                return false;
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setOnClickActions(boolean useImage, boolean playMusic){
        // TODO: set an adapter
        //ArrayAdapter itemsAdapter = new ArrayAdapter(this, R.layout.activity_level_two, notesList);
        for (int i = 0; i < notesList.size(); i++) {
            HashMap note = notesList.get(i);
            setOnClickButton(buttonList.get(i), (String) note.get("resource"), useImage, playMusic);
        }
    }

    public void renderButtons(LinearLayout linearLayout){
        for (Button button : buttonList){
            linearLayout.addView(button);
        }
    }

    public MediaPlayer createPlayer(String resString){
        int resId = getResId(resString, R.raw.class);
        return MediaPlayer.create(context, resId);
    }

    public void showImage(String image_name) {
        Dialog builder = new Dialog(context);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(context);
        imageView.setImageURI(Uri.parse("android.resource://" + context.getPackageName() + "/drawable/" + image_name));

        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
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
