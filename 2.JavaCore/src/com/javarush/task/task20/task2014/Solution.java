package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("2014");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Solution savedObject = new Solution(4);
        oos.writeObject(savedObject);
        fos.close();
        oos.close();
        FileInputStream fis = new FileInputStream("2014");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution loadedObject = new Solution(16);
        loadedObject = (Solution) ois.readObject();
        fis.close();
        ois.close();

        System.out.println(savedObject.string.equals(loadedObject.string));

        System.out.println(new Solution(4));
    }

    transient  private final String pattern = "dd MMMM yyyy, EEEE";
    transient  private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;
        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
