package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        FileInputStream fis = new FileInputStream(fileName1);
        Scanner scanner = new Scanner(fis);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            arrayList.add((int) Math.round(scanner.nextDouble()));
        }
        scanner.close();
        fis.close();

        FileOutputStream fos = new FileOutputStream(fileName2);

        for (int i = 0; i < arrayList.size(); i++) {

            fos.write(Integer.toString(arrayList.get(i)).getBytes());
            fos.write(32);
        }
        fos.close();
    }
}
