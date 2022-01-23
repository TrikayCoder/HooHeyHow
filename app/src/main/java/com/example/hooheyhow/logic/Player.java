package com.example.hooheyhow.logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Player {
    ArrayList<Integer> list = new ArrayList<>();
    public Player(ArrayList<Integer> listTemp){
        list.addAll(listTemp);
    }
    /*
    list[0] is tiger
    list[1] is chicken
    list[2] is calabash
    list[3] is crab
    list[4] is fish
    list[5] is shrimp
     */
    public int getPlayer(int index){
        return list.get(index);
    }

    public void setPlayer(int index, int value){
        list.set(index,value);
    }


}
