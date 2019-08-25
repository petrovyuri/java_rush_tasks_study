package com.javarush.task.lv10lesson1;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Human {

    public Cat cat;
    public Dog dog;


    public void save(PrintWriter writer) throws Exception {
        if (cat != null)
            cat.save(writer);
        if (dog != null)
            dog.save(writer);
    }

    public void load(BufferedReader reader) throws Exception {
        cat = new Cat();
        cat.load(reader);
       // dog.load(reader);
    }
}
