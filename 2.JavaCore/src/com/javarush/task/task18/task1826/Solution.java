package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case "-e":
                encryptionFile(args);
                break;
            case "-d":
                decryptionFile(args);
                break;
            default:
                break;
        }
    }

    private static void decryptionFile(String[] args) throws IOException {
        String decryptionFile = args[1];
        String decryptionResult = args[2];
        FileInputStream fis = new FileInputStream( decryptionFile);
        FileOutputStream fos = new FileOutputStream(decryptionResult);
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available()>0){
            list.add(fis.read());
        }

        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            temp -= 10;
            list.set(i, temp);
        }
        byte[]bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i]=list.get(i).byteValue();
        }
        fos.write(bytes);
        fis.close();
        fos.close();
    }

    private static void encryptionFile(String[] args) throws IOException {
        String encryptionFile = args[1];
        String encryptionResult = args[2];
        FileInputStream fis = new FileInputStream(encryptionFile);
        FileOutputStream fos = new FileOutputStream(encryptionResult);
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            list.add(fis.read());
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            temp += 10;
            list.set(i, temp);
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i).byteValue();
        }
        fos.write(bytes);
        fis.close();
        fos.close();
    }

}
