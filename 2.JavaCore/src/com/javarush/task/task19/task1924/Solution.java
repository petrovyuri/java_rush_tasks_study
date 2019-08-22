package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(br.readLine());
        br.close();
        br = new BufferedReader(fr);
        ArrayList<String> arrayList = new ArrayList<>();
        String string = "";
        while ((string = br.readLine()) != null) {
            arrayList.add(string);
        }
        br.close();
        fr.close();
        for (int i = 0; i < arrayList.size(); i++) {
            String[] strings = arrayList.get(i).split("\\s");
            for (Map.Entry<Integer, String> pair : map.entrySet()) {
                for (int j = 0; j < strings.length; j++) {
                    if (strings[j].equals(String.valueOf(pair.getKey()))) {
                        strings[j] = pair.getValue();
                    }
                }
            }
            String result = String.join(" ",strings);
            System.out.println(result);
        }

    }
}
