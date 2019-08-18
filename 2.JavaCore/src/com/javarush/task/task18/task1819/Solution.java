package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);

        ArrayList<Byte> file1 = new ArrayList<>();
        while (fis1.available() > 0) {
            file1.add((byte) fis1.read());
        }
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        ArrayList<Byte> file2 = new ArrayList<>();
        while (fis2.available() > 0) {
            file2.add((byte) fis2.read());
        }
        fis1.close();
        fis2.close();

        file2.addAll(file1);
        byte[] bytes = new byte[file2.size()];
        for (int i = 0; i < file2.size(); i++) {
            bytes[i] = file2.get(i);
        }

        fos1.write(bytes);

        fos1.close();
    }

}
