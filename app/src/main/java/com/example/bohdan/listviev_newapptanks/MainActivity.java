package com.example.bohdan.listviev_newapptanks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View customView = getLayoutInflater().inflate(R.layout.custom, viewGroup, false);
                ImageView imageView = customView.findViewById(R.id.imageView);
                TextView comandName = customView.findViewById(R.id.textView);
                TextView numericTank = customView.findViewById(R.id.textView3);
                TextView tankLife = customView.findViewById(R.id.textView2);

                //Example
                imageView.setImageResource(images[i]);
                comandName.setText("comaName");
                numericTank.setText("numericTank");
                tankLife.setText("tankLife");
                for (int k = 0; k < 15; k++){
                    comandName.setText();
                }

                return customView;
            }
        };
        listView.setAdapter(baseAdapter);*/
    }


        public void starter(View view) throws InterruptedException {

            final MiddleTank [] tanksGreen = new MiddleTank[15];
            final MiddleTank [] tanksRed = new MiddleTank[15];

            for (int i = 0; i < 15; i++){
                tanksGreen[i] = new MiddleTank("Jack"+i);
                tanksRed[i] = new MiddleTank("Bruce"+i);
            }

            //final MiddleTank tank0 = new MiddleTank("one");
            //final MiddleTank tank1 = new MiddleTank("two");



            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 15; i++) {
                        while (tanksGreen[i].endurance > 0 && tanksRed[i].endurance > 0) {
                            System.out.println("Player 1 health: " + tanksGreen[i].endurance + " ***  Player 2 health: " + tanksRed[i].endurance);
                            tanksGreen[i].fireTank(tanksRed[i]);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (tanksGreen[i].endurance > 0)
                            System.out.println("The winner is: " + tanksGreen[i].name);
                    }
                }
            });

            t.start();

            Thread p  =  new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 15; i++) {
                        while (tanksGreen[i].endurance > 0 && tanksRed[i].endurance > 0) {
                            System.out.println("Player 1 health: " + tanksGreen[i].endurance + " ***  Player 2 health: " + tanksRed[i].endurance);
                            System.out.println("------------------------");
                            tanksRed[i].fireTank(tanksGreen[i]);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("------------------------ * ---------------------------");
                        if (tanksRed[i].endurance > 0)
                            System.out.println("The winner is: " + tanksGreen[i].name);
                    }
                }
            });

            p.start();
            t.join();
            p.join();
            /*for (int i = 0; i < 15; i++) {
                if (tanksGreen[i].endurance > 0)
                .setText("The winner is: " + tanksGreen[i].name);
            else if (tanksRed[i].endurance > 0)
                    expression_3.setText("The winner is: " + tanksRed[i].name);
            }*/
            ListView listView = findViewById(R.id.liste23);
            final int[] images = {R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won,
                                  R.drawable.sisty,R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won, R.drawable.sisty,
                                  R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won, R.drawable.sisty,};
            BaseAdapter baseAdapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    return images.length;
                }

                @Override
                public Object getItem(int i) {
                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    View customView = getLayoutInflater().inflate(R.layout.custom, viewGroup, false);
                    ImageView imageView = customView.findViewById(R.id.imageView);
                    TextView comandName = customView.findViewById(R.id.textView);
                    TextView numericTank = customView.findViewById(R.id.textView3);
                    TextView tankLife = customView.findViewById(R.id.textView2);

                    //Example
                    /*comandName.setText("comaName");
                    numericTank.setText("numericTank");
                    tankLife.setText("tankLife")*/;
                    for (int k = 0; k < 15; k++){
                        imageView.setImageResource(images[i]);
                        comandName.setText(tanksGreen[i].name);
                        comandName.setText(tanksRed[i].name);
                        tankLife.setText("tankLife: " + tanksGreen[i].endurance);
                        numericTank.setText("numericTank");
                    }

                    return customView;
                }
            };
            listView.setAdapter(baseAdapter);
        }
    }

