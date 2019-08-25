package com.javarush.task.lv10lesson1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Human human = new Human();
        human.load(new BufferedReader(new FileReader("human")));
       // human.save(new PrintWriter("human"));
    }
}
