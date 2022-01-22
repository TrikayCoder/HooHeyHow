package com.example.hooheyhow.logic;

import java.util.ArrayList;
import java.util.Random;

public class Logic implements LogicInterface {
    ArrayList<Player> player = new ArrayList<>();
    @Override
    public int makeRandom() {
        Random rd = new Random();
        return rd.nextInt(7);
    }

    public void copyObj(ArrayList<Player> oldObj){
        player.addAll(oldObj);
    }


}
