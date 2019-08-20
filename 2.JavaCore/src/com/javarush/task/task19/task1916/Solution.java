package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();
        List<String> fileList1 = fileToList(file1);
        List<String> fileList2 = fileToList(file2);
        List<String> addFiles = new ArrayList<>(fileList2);

        int count = 0;
        while (fileList1.size() > 0) {
            for (int i = 0; i < fileList2.size(); i++) {
                try {
                    if (fileList1.get(count).equals(fileList2.get(i))) {
                        lines.add(new LineItem(Type.SAME, fileList1.get(count)));
                        fileList1.remove(count);
                    } else {
                        if (fileList1.size() > 1) {
                            if (fileList1.get(count + 1).equals(fileList2.get(i))) {
                                lines.add(new LineItem(Type.REMOVED, fileList1.get(count)));
                                fileList1.remove(count);
                                i--;
                            } else {
                                lines.add(new LineItem(Type.ADDED, fileList2.get(i)));
                            }
                        } else {
                            lines.add(new LineItem(Type.REMOVED, fileList1.get(count)));
                            fileList1.remove(count);
                        }
                    }

                } catch (IndexOutOfBoundsException e) {
                    lines.add(new LineItem(Type.ADDED,fileList2.get(i)));
                }
            }
        }
        for (LineItem lineItem : lines) {
            System.out.println(lineItem.type + " " + lineItem.line);
        }
    }

    private static List<String> fileToList(String file1) throws IOException {
        FileReader fileReader = new FileReader(file1);
        BufferedReader br = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        String string = "";
        while ((string = br.readLine()) != null) {
            list.add(string);
        }
        br.close();
        fileReader.close();
        return list;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
