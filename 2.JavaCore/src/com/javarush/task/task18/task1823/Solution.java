package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        while (true) {
            string = br.readLine();
            if (string.equals("exit")) {
                break;
            } else {
                new ReadThread(string).start();
            }
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        FileInputStream fis = null;
        String mFileName = "";
        Integer result = 0;

        public ReadThread(String fileName) throws IOException {
            mFileName = fileName;
        }

        @Override
        public void run() {
            ArrayList<Integer> arrayList = new ArrayList<>();
            try {
                fis = new FileInputStream(mFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    if (fis.available()>0){
                        arrayList.add(fis.read());
                    } else break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Integer byt = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                if (result<= Collections.frequency(arrayList, arrayList.get(i))){
                    byt = arrayList.get(i);
                    result = Collections.frequency(arrayList, arrayList.get(i));
                }
            }
            resultMap.put(mFileName, byt);
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            super.run();

        }
    }
}
