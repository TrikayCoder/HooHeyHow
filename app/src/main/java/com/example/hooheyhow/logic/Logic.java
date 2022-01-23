package com.example.hooheyhow.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Logic {

    public int makeRandom() {
        Random rd = new Random();
        return rd.nextInt(7);
    }

    public int returnMoney(int result1, int result2, int result3 , Player playerData){
        int money = 0;
       if(playerData.getPlayer(result1) > 0){
           money += playerData.getPlayer(result1) * 2;
       }
       if(playerData.getPlayer(result2) > 0){
           money += playerData.getPlayer(result2) * 2;
       }
       if(playerData.getPlayer(result3) > 0){
           money += playerData.getPlayer(result3) * 2;
       }
       return money;
    }

    public String logicResult(int result1, int result2, int result3, ArrayList<Player> player){
        String finalResult = "";
        for(int i=0;i<player.size();i++){
            String playerTH = Integer.toString(i+1);
            String moneyPlayerTH = Integer.toString(returnMoney(result1,result2,result3,player.get(i)));
            finalResult += "Nguoi choi thu: " + playerTH + "con lai so tien sau van choi la: " + moneyPlayerTH +"|";
        }
        return  finalResult;
    }

}
