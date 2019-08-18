package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> myTreeSet = new TreeSet<>();
        String str;
        while (!(str = br.readLine()).equals("end")){
            myTreeSet.add(str);
        }
        FileOutputStream fos = new FileOutputStream("1");
        for (String s: myTreeSet){
            FileInputStream fis  = new FileInputStream(s);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
            fis.close();
        }
        fos.close();

    }
}
