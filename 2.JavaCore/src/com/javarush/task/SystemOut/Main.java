package com.javarush.task.SystemOut;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args){
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream  = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        printSomething();
        String result = outputStream.toString();
        //Возвращаем все как было
        System.setOut(consoleStream);
        StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.reverse();
        String newResult = stringBuilder.toString();
        System.out.println(newResult);
    }

    private static void printSomething() {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }
}
