package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream saveStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);
        testString.printSomething();
        String[] strings = byteArrayOutputStream.toString().trim().split(" ");
        int result=0;

        if (strings[1].equals("+")){
             result = Integer.parseInt(strings[0])+Integer.parseInt(strings[2]);
        } else if (strings[1].equals("-")){
            result = Integer.parseInt(strings[0])-Integer.parseInt(strings[2]);
        } else if (strings[1].equals("*")){
            result = Integer.parseInt(strings[0])*Integer.parseInt(strings[2]);
        }

        System.setOut(saveStream);

        System.out.println(strings[0]+" "+strings[1]+" "+strings[2]+" "+strings[3]+" "+result);
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

