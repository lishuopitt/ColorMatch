package com.example.lishuo.colormatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;

import java.util.Random;

public class TargetActivity extends AppCompatActivity {
    int buttonClicked;
    int buttonClicked1;
    int buttonClicked2;
    int buttonClicked3;
    int buttonClicked4;
    int buttonClicked5;
    int buttonClicked6;
    int buttonClicked7;
    int buttonClicked8;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    SharedPreferences sharedPreferences;
    boolean gameover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);

        sharedPreferences = getSharedPreferences("com.example.lishuo.colormatch", Context.MODE_PRIVATE);
        gameover=sharedPreferences.getBoolean("GAMEOVER", false);
        if(gameover==true){
            buttonClicked = 1 + (int)(Math.random() * 3);
            buttonClicked1 = 1 + (int)(Math.random() * 3);
            buttonClicked2 = 1 + (int)(Math.random() * 3);
            buttonClicked3 = 1 + (int)(Math.random() * 3);
            buttonClicked4 = 1 + (int)(Math.random() * 3);
            buttonClicked5 = 1 + (int)(Math.random() * 3);
            buttonClicked6= 1 + (int)(Math.random() * 3);
            buttonClicked7 = 1 + (int)(Math.random() * 3);
            buttonClicked8 = 1 + (int)(Math.random() * 3);
        }else{
            buttonClicked=sharedPreferences.getInt("Button", 0);
            buttonClicked1=sharedPreferences.getInt("Button1", 0);
            buttonClicked2=sharedPreferences.getInt("Button2", 0);
            buttonClicked3=sharedPreferences.getInt("Button3", 0);
            buttonClicked4=sharedPreferences.getInt("Button4", 0);
            buttonClicked5=sharedPreferences.getInt("Button5", 0);
            buttonClicked6=sharedPreferences.getInt("Button6", 0);
            buttonClicked7=sharedPreferences.getInt("Button7", 0);
            buttonClicked8=sharedPreferences.getInt("Button8", 0);
        }
        changeButtonColor(button,buttonClicked);
        changeButtonColor(button1,buttonClicked1);
        changeButtonColor(button2,buttonClicked2);
        changeButtonColor(button3,buttonClicked3);
        changeButtonColor(button4,buttonClicked4);
        changeButtonColor(button5,buttonClicked5);
        changeButtonColor(button6,buttonClicked6);
        changeButtonColor(button7,buttonClicked7);
        changeButtonColor(button8,buttonClicked8);

    }

    public void changeButtonColor(Button clickedButton, int buttonValue){
        switch(buttonValue) {
            case 1:
                clickedButton.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                clickedButton.setBackgroundColor(Color.RED);
                break;
            case 3:
                clickedButton.setBackgroundColor(Color.GREEN);
                break;
        }
    }
    public void goToMainActivity(View v){
        //Intent intent = new Intent(this, MainActivity.class);
     //   startActivity(intent);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lishuo.colormatch", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Button",buttonClicked).apply();
        sharedPreferences.edit().putInt("Button1",buttonClicked1).apply();
        sharedPreferences.edit().putInt("Button2",buttonClicked2).apply();
        sharedPreferences.edit().putInt("Button3",buttonClicked3).apply();
        sharedPreferences.edit().putInt("Button4",buttonClicked4).apply();
        sharedPreferences.edit().putInt("Button5",buttonClicked5).apply();
        sharedPreferences.edit().putInt("Button6",buttonClicked6).apply();
        sharedPreferences.edit().putInt("Button7",buttonClicked7).apply();
        sharedPreferences.edit().putInt("Button8",buttonClicked8).apply();

        finish();
    }
}
