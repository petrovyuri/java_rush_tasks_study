package com.javarush.task.task20.task2024;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("2024");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Solution solution = new Solution();
        oos.writeObject(solution);
        fos.close();
        oos.close();
    }
}
