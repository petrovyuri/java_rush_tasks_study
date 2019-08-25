package com.javarush.task.lv10lesson1;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Dog {
    public String name;
    public int age;

    public void save(PrintWriter writer) throws Exception {
        writer.println(name);
        writer.println(age);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
    }
}
