package com.example.bohdan.listviev_newapptanks;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {

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

        Resources resources = getResources();
        tank = (MiddleTank) getIntent().getSerializableExtra("item");

        int gap = resources.getIdentifier(tank.image,"drawable","com.example.bohdan.listviev_newapptanks");

        textView4.setText(tank.name);
        textView5.setText(String.valueOf(tank.endurance));
        imageView.setImageResource(gap);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //startActivity(new Intent(this, MainActivity.class));
                onBackPressed();  // цей метод працює
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
