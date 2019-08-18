package com.javarush.task.task19.task1908;

/* 
Выделяем числа из строки
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        FileReader fileReader = new FileReader(fileName1);
        BufferedReader br2 = new BufferedReader(fileReader);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (br2.ready()) {
            arrayList.add(fileReader.read());
        }
        fileReader.close();
        br.close();
        br2.close();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append((char)arrayList.get(i).byteValue());
        }

        String[] strings = stringBuilder.toString().split(" ");

        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (int i = 0; i < strings.length; i++) {
            try {
                Integer integer = Integer.valueOf(strings[i]);
                fileWriter.write(integer+" ");
            } catch (Exception e){

            }
        }

        fileWriter.close();
        bw.close();


    }
}
