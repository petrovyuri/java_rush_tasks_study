package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newStream  = new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);
        testString.printSomething();
        System.setOut(oldStream);
        String[] strings = byteArrayOutputStream.toString().split("\\n");
        int count=0;
        for (int i = 0; i < strings.length; i++) {
            if (count==1){
                System.out.println(strings[i]);
                System.out.println("JavaRush - курсы Java онлайн");
                count=0;
            } else {
                System.out.println(strings[i]);
                count++;
            }

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
