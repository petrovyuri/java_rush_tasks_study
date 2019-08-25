package com.javarush.task.lv10lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Cat {
    public String name;
    public int age;
    public int weight;

    public void save(PrintWriter writer) throws IOException{
        writer.println(name);
        writer.println(age);
        writer.println(weight);
    }
    public void load(BufferedReader reader) throws IOException{
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }
}
