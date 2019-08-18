package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();
        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);
        BufferedReader br2 = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        while (br2.ready()){
            int integer = br2.read();
            if (integer==46){
                bw.write(33);
            } else bw.write(integer);
        }
        br2.close();
        bw.close();
        fr.close();
        fw.close();

    }
}
