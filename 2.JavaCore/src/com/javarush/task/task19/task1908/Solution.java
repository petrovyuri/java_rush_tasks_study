package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileReader.ready()) {
            arrayList.add(fileReader.read());
        }
        fileReader.close();
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) >= 48 && arrayList.get(i) <= 57) {
            } else arrayList.set(i, 32);
            sb.append((char) arrayList.get(i).byteValue());
        }
        String[] strings = sb.toString().split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("")){

            } else System.out.print(strings[i]+" ");
        }
    }
}
