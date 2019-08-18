package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        while (true) {
            String s = bufferedReader.readLine();
            bufferedWriter.write(s);
            if (s.equals("exit")) {
                break;
            }
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
