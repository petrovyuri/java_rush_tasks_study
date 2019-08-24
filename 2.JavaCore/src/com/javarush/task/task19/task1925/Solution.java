package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append((char)fileReader.read());
        }

        String[] strings = stringBuilder.toString().split("[\\s-\\n]");
        boolean first = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length()>6){
              if (first){
                  fileWriter.write(strings[i]);
                  first = false;
              } else {
                  fileWriter.write(","+strings[i]);
              }
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
