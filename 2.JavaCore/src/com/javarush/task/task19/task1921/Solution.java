package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = "";
        ArrayList<String> arrayList = new ArrayList<>();
        while ((string = bufferedReader.readLine()) != null) {
            String name = string.replaceAll("\\d*","").trim();
            String date  = string.replaceAll("\\D"," ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date datePerson = simpleDateFormat.parse(date);
            PEOPLE.add(new Person(name,datePerson));
        }

        bufferedReader.close();
        fileReader.close();

    }
}
