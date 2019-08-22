package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        StringBuilder stringBuilder = new StringBuilder();

        while (fileReader.ready()) {
            stringBuilder.append((char) fileReader.read());
        }
        fileReader.close();
        String[] string = stringBuilder.toString().split("[\\s\\n\\r]");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(string));
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(arrayList.get(i));
            if (matcher.find()) {
                resultList.add(arrayList.get(i));
            }
        }
        for (String s:resultList){
            fileWriter.write(s+" ");
        }
        fileWriter.close();
    }
}
