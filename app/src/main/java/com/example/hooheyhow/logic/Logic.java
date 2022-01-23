package com.example.hooheyhow.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Logic {
    ArrayList<Player> player = new ArrayList<>();

    public int makeRandom() {
        Random rd = new Random();
        return rd.nextInt(7);
    }
    public void copyObj(ArrayList<Player> oldObj){
        player.addAll(oldObj);
    }

    public void getObj(ArrayList<Player> oldObj){
        oldObj.addAll(player);
    }

}
