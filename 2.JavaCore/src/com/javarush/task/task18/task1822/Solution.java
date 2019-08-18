package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis));

        String string = br2.readLine();
        while (!string.equals("")) {
            String[] arrayString = string.split(" ");
            if (arrayString[0].equals(args[0])) {
                System.out.println(string);
                break;
            }
            string = br2.readLine();
        }

        br.close();
        br2.close();
        fis.close();
    }
}
