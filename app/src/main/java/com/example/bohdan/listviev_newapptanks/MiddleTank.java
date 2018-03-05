package com.example.bohdan.listviev_newapptanks;

import java.io.Serializable;

/** Created by bohdan on 23.02.2018. */

public class MiddleTank extends Tank implements Serializable {

    public String name;
   /* public String image;
    public int armor = 100;
    public int speed = 80;*/
    //public int endurance;
   /* public int precision = 80;
    public int  shotPower = 50;*/
    //public int endurance;

    public MiddleTank(String s) {
       this.name = s;
       //this.endurance = 100;
    }

    /*public MiddleTank(String name){
        this.name = name;
        armor = 100;
        speed = 80;
        endurance = 100;
        precision = 80;
        shotPower = 50;
    }*/

    public MiddleTank(String name, String image) {
        this.name = name;
        armor = 100;
        speed = 80;
        endurance = 100;
        precision = 80;
        shotPower = 50;
        this.image = image;
    }

    /*public MiddleTank(int speed, int sheetArmor, int endurance, int precision) {
        super(speed, sheetArmor, endurance, precision);
    }*/
}
