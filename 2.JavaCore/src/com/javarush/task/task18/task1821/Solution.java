package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> values = new ArrayList<>();
        while (fis.available() > 0) {
            values.add(fis.read());
        }
        fis.close();
        for (int i = 0; i <values.size(); i++) {
            map.put(values.get(i), Collections.frequency(values, values.get(i)));
        }

        fis.close();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int value = pair.getKey();
            System.out.println((char)value + " " + pair.getValue());
        }
    }
}
