package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties propertie = new Properties();

    public  void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = br.readLine();
        FileInputStream fs = new FileInputStream(br.readLine());
//        FileOutputStream fos = new FileOutputStream(fileName);
        load(fs);
        br.close();
//        fos.close();
        fs.close();
    }

    public  void save(OutputStream outputStream) throws Exception {
        for (Map.Entry<String,String> pair : properties.entrySet()){
            propertie.setProperty(pair.getKey(),pair.getValue());
        }
        propertie.store(outputStream, null);
    }

    public  void load(InputStream inputStream) throws Exception {
        propertie.load(inputStream);
        for (String name : propertie.stringPropertyNames()) {
            properties.put(name, propertie.getProperty(name));
        }
    }

    public static void main(String[] args) throws Exception {
    }
}
