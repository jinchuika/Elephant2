package com.example.chuik.elephant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLevelOne(View view) {
        Intent intent = new Intent(this, LevelOneActivity.class);
        startActivity(intent);
    }

    public void goToLevelTwo(View view) {
        Intent intent = new Intent(this, LevelTwoActivity.class);
        startActivity(intent);
    }

}
