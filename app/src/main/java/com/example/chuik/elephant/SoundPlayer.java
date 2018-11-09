package com.example.chuik.elephant;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer {

    public static void playSound(Context context, int resId){
        MediaPlayer mp = MediaPlayer.create(context, resId);
        mp.start();
    }

    public static MediaPlayer createPlayer(Context context, int resId){
        return MediaPlayer.create(context, resId);
    }
}
