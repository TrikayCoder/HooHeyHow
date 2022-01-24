package com.example.hooheyhow.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Logic {

    public int makeRandom() {
        Random rd = new Random();
        return rd.nextInt((6-1) + 1) + 1;
    }

    public int returnMoney(int result1, int result2, int result3 , Player playerData){
        int money = 0;
        ArrayList<Integer> listTemp = new ArrayList<>();
        int[] arr = new int[3];
        arr[0] = result1;
        arr[1] = result2;
        arr[2] = result3;
       if(playerData.getPlayer(result1) > 0){
           money += playerData.getPlayer(result1);
       }
       if(playerData.getPlayer(result2) > 0){
           money += playerData.getPlayer(result2);
       }
       if(playerData.getPlayer(result3) > 0){
           money += playerData.getPlayer(result3);
       }
        listTemp.add(arr[0]);
        for(int i=1;i<3;i++){
            int checkTemp = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[i] == arr[j]){
                    checkTemp--;
                }
            }
            if(checkTemp == 0){
                listTemp.add(arr[i]);
            }

        }
        for(int i=0;i<listTemp.size();i++){
            money+= playerData.getPlayer(listTemp.get(i));
        }
       return money;
    }

    public String logicResult(int result1, int result2, int result3, ArrayList<Player> player){
        String finalResult = "";
        for(int i=0;i<player.size();i++){
            String moneyPlayerTH = Integer.toString(returnMoney(result1,result2,result3,player.get(i)));
            finalResult += "Con lai so tien sau van choi la: " + moneyPlayerTH +"|";
        }
        return  finalResult;
    }



}
