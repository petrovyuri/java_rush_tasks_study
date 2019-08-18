package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream saveStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);
        testString.printSomething();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < byteArrayOutputStream.size(); i++) {
           try {
               char tempInt = (char)byteArrayOutputStream.toByteArray()[i];
               integerArrayList.add(Integer.parseInt(String.valueOf(tempInt)));
           } catch (Exception e){

           }
        }
        System.setOut(saveStream);
        for (Integer integer: integerArrayList){
            System.out.print(integer);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
