package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()){
            int integer = bufferedReader.read();
            stringBuilder.append((char)integer);
            Pattern pattern = Pattern.compile("\\p{Punct}");
        }
        String string = stringBuilder.toString().replaceAll("\\p{Punct}","");

        bufferedWriter.write(string);
        bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();
    }
}
