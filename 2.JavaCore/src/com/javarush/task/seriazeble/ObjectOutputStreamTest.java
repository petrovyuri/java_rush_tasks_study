package com.javarush.task.seriazeble;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        List<String> data = new ArrayList<>();
        data.add("One");
        data.add("Two");
        data.add("Three");
        oos.writeObject(data);
        data.clear();
        // 1
        //data = new ArrayList<>();
        data.add("Ein");
        data.add("Zwei");
        data.add("Drei");
        // 2
        oos.reset();
        oos.writeObject(data);
        oos.flush();
        oos.close();
        baos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        List<String> newData = (List<String>)ois.readObject();
        System.out.println(newData);
        newData = (List<String>)ois.readObject();
        System.out.println(newData);
    }
}
