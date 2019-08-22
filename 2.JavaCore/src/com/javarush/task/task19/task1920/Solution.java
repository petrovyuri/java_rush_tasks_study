package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = "";
        Map<String, Double> map = new HashMap<>();
        while ((string = bufferedReader.readLine()) != null) {
            String[] strings = string.split(" ");
            if (map.containsKey(strings[0])) {
                map.put(strings[0], (map.get(strings[0]) + Double.parseDouble(strings[1])));
            } else map.put(strings[0], Double.valueOf(strings[1]));
        }
        bufferedReader.close();
        fileReader.close();

        ArrayList<String> arrayList = new ArrayList<>();
        double salary = 0;

        for (Map.Entry<String,Double> pair: map.entrySet()){
            if (pair.getValue()>=salary){
                salary=pair.getValue();
            }
        }

        for (Map.Entry<String,Double> pair:map.entrySet()){
            if (pair.getValue().equals(salary)){
                arrayList.add(pair.getKey());
            }
        }

        Collections.sort(arrayList);
        arrayList.forEach((a)-> System.out.println(a));

    }

}
