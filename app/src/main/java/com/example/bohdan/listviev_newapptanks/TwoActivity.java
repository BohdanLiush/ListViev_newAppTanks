package com.example.bohdan.listviev_newapptanks;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {

    final MiddleTank [] tanksGreen = new MiddleTank[15];
    MiddleTank tank;
    TextView textView4;
    TextView textView5;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        textView4 = findViewById(R.id.textView58);
        textView5 = findViewById(R.id.textView69);
        imageView = findViewById(R.id.imageView2);
        //Resources resources = getResources();
        tank = (MiddleTank) getIntent().getSerializableExtra("item");

        /*int gap = resources.getIdentifier(tank.name,"drawable","com.example.bohdan.new_app_tanks");
        String s = resources.getString(Integer.parseInt(tank.name));*//*
        String p = getIntent().getStringExtra(tank.name);
        String de = getIntent().getStringExtra(String.valueOf(tank.endurance));*/
        //String gap = resources.getResourceName(Integer.parseInt(tank.name));
        textView4.setText(tank.name);
        textView5.setText(String.valueOf(tank.endurance));
      /*  for (int i = 0; i < 15; i++){
            tanksGreen[i] = (MiddleTank) getIntent().getSerializableExtra("item");
            //int gap = resources.getIdentifier(tanksGreen[i].name,"drawable","com.example.bohdan.new_app_tanks");
            textView4.setText(tanksGreen[i].name);
            textView5.setText(tanksGreen[i].endurance);
        }*/
    }

    public void remvo(View view) {
        finish();
    }
}
