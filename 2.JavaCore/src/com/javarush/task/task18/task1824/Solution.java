package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        String string = "";


            try {
                while (true) {
                    string = br.readLine();
                    fis = new FileInputStream(string);
                    fis.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
