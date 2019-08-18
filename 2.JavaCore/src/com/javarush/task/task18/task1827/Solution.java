package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        switch (args[0]) {
            case "-c":
                addCruid(args);
                break;
            default:
                break;
        }
    }

    private static void addCruid(String[] args) throws IOException {
        String tempProductName = args[1];
        String tempPrice = args[2];
        String tempQuantity = args[3];
        BufferedReader br = new BufferedReader(new FileReader("cruid"));
        ArrayList<String> strings = new ArrayList<>();
        String string = "";
        while (true) {
            if ((string = br.readLine()) != null) {
                strings.add(string);

            } else break;
        }
        br.close();

        String id = maxID(strings);
        String productName = convertString(tempProductName, 30);
        String price = convertString(tempPrice, 8);
        String quantity = convertString(tempQuantity, 4);


    }

    private static String convertString(String string, int i) {
        return null;
    }

    private static String maxID(ArrayList<String> strings) {
        String result = "";
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i).substring(0,7);
            char[] strs = s.toCharArray();
            char[] numbers = new char[strs.length];
            for (int j = 0; j < strs.length; j++) {
                if (strs[i]!=32){
                    numbers[i]=strs[i];
                }
            }
            String num = new String(numbers);
            Integer integer = Integer.valueOf(num);
            System.out.println(integer);
        }

        return null;
    }
}
