package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(br.readLine());
        br.close();
        br = new BufferedReader(fileReader);
        String string = "";
        while ((string = br.readLine()) != null) {
            String result = new StringBuffer(string).reverse().toString();
            System.out.println(result);
        }
        br.close();
        fileReader.close();

    }
}
