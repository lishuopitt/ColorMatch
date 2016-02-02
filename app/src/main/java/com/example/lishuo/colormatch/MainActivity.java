package com.example.lishuo.colormatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    int buttonClicked;
    int buttonClicked1;
    int buttonClicked2;
    int buttonClicked3;
    int buttonClicked4;
    int buttonClicked5;
    int buttonClicked6;
    int buttonClicked7;
    int buttonClicked8;

    int targetbuttonClicked;
    int  targetbuttonClicked1;
    int  targetbuttonClicked2;
    int  targetbuttonClicked3;
    int  targetbuttonClicked4;
    int  targetbuttonClicked5;
    int  targetbuttonClicked6;
    int  targetbuttonClicked7;
    int  targetbuttonClicked8;

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
    TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        sharedPreferences = getSharedPreferences("com.example.lishuo.colormatch", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("GAMEOVER", true).apply();
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4=(Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5=(Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6=(Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7=(Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8=(Button)findViewById(R.id.button8);
        button8.setOnClickListener(this);
        editText=(TextView)findViewById(R.id.result);
        editText.setText("");
        changeButtonColor(button,0);
        changeButtonColor(button1,0);
        changeButtonColor(button2,0);
        changeButtonColor(button3,0);
        changeButtonColor(button4,0);
        changeButtonColor(button5,0);
        changeButtonColor(button6,0);
        changeButtonColor(button7,0);
        changeButtonColor(button8,0);
    }
    public void onResume() {
        super.onResume();
        if (sharedPreferences != null) {
           targetbuttonClicked=sharedPreferences.getInt("Button", 0);
            targetbuttonClicked1=sharedPreferences.getInt("Button1", 0);
            targetbuttonClicked2=sharedPreferences.getInt("Button2", 0);
            targetbuttonClicked3=sharedPreferences.getInt("Button3", 0);
            targetbuttonClicked4=sharedPreferences.getInt("Button4", 0);
            targetbuttonClicked5=sharedPreferences.getInt("Button5", 0);
            targetbuttonClicked6=sharedPreferences.getInt("Button6", 0);
            targetbuttonClicked7=sharedPreferences.getInt("Button7", 0);
            targetbuttonClicked8=sharedPreferences.getInt("Button8", 0);
        }
        if(gameover==true){
            buttonClicked=0;
            buttonClicked1=0;
            buttonClicked2=0;
            buttonClicked3=0;
            buttonClicked4=0;
            buttonClicked5=0;
            buttonClicked6=0;
            buttonClicked7=0;
            buttonClicked8=0;
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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void goToTarget(View v){
        Intent intent = new Intent(this, TargetActivity.class);
        startActivity(intent);
        sharedPreferences.edit().putBoolean("GAMEOVER", gameover).apply();
        editText.setText("");
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                buttonClicked++;
                if(buttonClicked>3){
                    buttonClicked=1;
                }
                changeButtonColor(button,buttonClicked);
                checkIfRight();
                break;
            case R.id.button1:
                buttonClicked1++;
                if(buttonClicked1>3){
                    buttonClicked1=1;
                }
                changeButtonColor(button1,buttonClicked1);
                checkIfRight();
                break;
            case R.id.button2:
                buttonClicked2++;
                if(buttonClicked2>3){
                    buttonClicked2=1;
                }
                changeButtonColor(button2,buttonClicked2);
                checkIfRight();
                break;
            case R.id.button3:
                buttonClicked3++;
                if(buttonClicked3>3){
                    buttonClicked3=1;
                }
                changeButtonColor(button3,buttonClicked3);
                checkIfRight();
                break;
            case R.id.button4:
                buttonClicked4++;
                if(buttonClicked4>3){
                    buttonClicked4=1;
                }
                changeButtonColor(button4,buttonClicked4);
                checkIfRight();
                break;
            case R.id.button5:
                buttonClicked5++;
                if(buttonClicked5>3){
                    buttonClicked5=1;
                }
                changeButtonColor(button5,buttonClicked5);
                checkIfRight();
                break;
            case R.id.button6:
                buttonClicked6++;
                if(buttonClicked6>3){
                    buttonClicked6=1;
                }
                changeButtonColor(button6,buttonClicked6);
                checkIfRight();
                break;
            case R.id.button7:
                buttonClicked7++;
                if(buttonClicked7>3){
                    buttonClicked7=1;
                }
                changeButtonColor(button7,buttonClicked7);
                checkIfRight();
                break;
            case R.id.button8:
                buttonClicked8++;
                if(buttonClicked8>3){
                    buttonClicked8=1;
                }
                changeButtonColor(button8,buttonClicked8);
                checkIfRight();
                break;
        }
    }
    public void checkIfRight(){
        if(buttonClicked==targetbuttonClicked){
            if(buttonClicked1==targetbuttonClicked1){
                if(buttonClicked2==targetbuttonClicked2){
                    if(buttonClicked3==targetbuttonClicked3){
                        if(buttonClicked4==targetbuttonClicked4){
                            if(buttonClicked5==targetbuttonClicked5){
                                if(buttonClicked6==targetbuttonClicked6){
                                    if(buttonClicked7==targetbuttonClicked7){
                                        if(buttonClicked8==targetbuttonClicked8){
                                          //show suffcee
                                            editText.setText("Success!");
                                            gameover=true;
                                        }else{gameover=false;}
                                    }else{gameover=false;}
                                }else{gameover=false;}
                            }else{gameover=false;}
                        }else{gameover=false;}
                    }else{gameover=false;}
                }else{gameover=false;}
            }else{gameover=false;}
        }else{gameover=false;}
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
            case 0:
                clickedButton.setBackgroundColor(Color.GRAY);
                break;
        }
    }
}
