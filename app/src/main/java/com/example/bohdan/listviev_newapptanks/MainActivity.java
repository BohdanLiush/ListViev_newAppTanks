package com.example.bohdan.listviev_newapptanks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    final ArrayList<MiddleTank> tanksGr = new ArrayList<>(15);
    final ArrayList<MiddleTank> tanksRd = new ArrayList<>(15);
    final ArrayList<MiddleTank> baseTn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.liste23);

        /*final int[] images = {R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won,
                R.drawable.sisty,R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won, R.drawable.sisty,
                R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won, R.drawable.sisty,
                R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won,
                R.drawable.sisty,R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won, R.drawable.sisty,
                R.drawable.tanaks, R.drawable.alex, R.drawable.sisty, R.drawable.won, R.drawable.sisty
        };*/

        final BaseAdapter baseAdapter = new BaseAdapter() {

            @Override
            public int getCount() {
                return baseTn.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View customView = getLayoutInflater().inflate(R.layout.custom, viewGroup, false);
                ImageView imageView = customView.findViewById(R.id.imageView);
                TextView comandName = customView.findViewById(R.id.textView);
                TextView numericTank = customView.findViewById(R.id.textView3);
                TextView tankLife = customView.findViewById(R.id.textView2);

                for (int k = 0; k < baseTn.size(); k++) {
                    //imageView.setImageResource(images[i]);
                    comandName.setText(baseTn.get(i).name);
                    tankLife.setText("tankLife: " + (baseTn.get(i).endurance));
                    numericTank.setText("numericTank");
                }
                return customView;
            }
        };

        for (int i = 0; i < 15; i++) {
            tanksGr.add(new MiddleTank("Jack" + i));
            tanksRd.add(new MiddleTank("Bruce" + i));
        }

        baseTn.addAll(tanksGr);
        baseTn.addAll(tanksRd);
        listView.setAdapter(baseAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                intent.putExtra("item", baseTn.get(i));
                startActivity(intent);
                baseAdapter.notifyDataSetChanged();
                listView.invalidateViews();
                listView.refreshDrawableState();
            }
        });

    }

    public void starter(View view) throws InterruptedException {
            /*for (int i = 0; i < 15; i++) {
                if (tanksGreen[i].endurance > 0)
                .setText("The winner is: " + tanksGreen[i].name);
            else if (tanksRed[i].endurance > 0)
                    expression_3.setText("The winner is: " + tanksRed[i].name);
            }*/

        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 15; i++) {
                    //while (tanksGr.get(i).endurance > 0 && tanksRd.get(i).endurance > 0) {
                    System.out.println("Player 1 health: " + tanksGr.get(i).endurance + " ***  Player 2 health: " + tanksRd.get(i).endurance);
                    tanksGr.get(i).fireTank(tanksRd.get(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (tanksGr.get(i).endurance > 0)
                        System.out.println("The winner is: " + tanksGr.get(i).name);
                }
            }
        });
        t.start();

        Thread p = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 15; i++) {
                    // while (tanksGr.get(i).endurance > 0 && tanksRd.get(i).endurance > 0) {
                    System.out.println("Player 1 health: " + tanksGr.get(i).endurance + " ***  Player 2 health: " + tanksRd.get(i).endurance);
                    System.out.println("------------------------");
                    tanksRd.get(i).fireTank(tanksGr.get(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("------------------------ * ---------------------------");
                    if (tanksRd.get(i).endurance > 0)
                        System.out.println("The winner is: " + tanksRd.get(i).name);
                }
            }
        });

        p.start();
        t.join();
        p.join();

    }

    public void deleteElement_0(View view) throws IOException {

        ArrayList<MiddleTank> templist = new ArrayList<MiddleTank>();
        for (int i = 0; i < baseTn.size(); i++) {
            if (baseTn.get(i).endurance == 0)
                templist.add(baseTn.get(i));
        }
        baseTn.removeAll(templist);

                /*for (MiddleTank tank : baseTn){
                    if (tank.endurance==0)
                        baseTn.remove(tank);
                }*/

              /* for (int i = 0; i < baseTn.size(); i++){
                   if (baseTn.get(i).endurance==0)
                       baseTn.remove(i);
               }*/
            /*int len = baseTn.size() - 1; // Precalculate it once, so that the cycle runs faster
            for (int i = len; i > 1; i--)
            {

                baseTn.remove(i);

            }*/
        /*ArrayList<MiddleTank> templist = new ArrayList<MiddleTank>();
        for (int i = 0; i < baseTn.size(); i++) {
            if (baseTn.get(i).endurance == 0)
                templist.add(baseTn.get(i));
        }
        baseTn.removeAll(templist);*/


    }
}

