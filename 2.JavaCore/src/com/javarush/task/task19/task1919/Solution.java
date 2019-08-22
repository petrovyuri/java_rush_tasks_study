package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fileReader);
        Map<String, Double> map = new TreeMap<>();
        String string = "";
        while (!((string = br.readLine()) == null)) {
           String[] strings = string.split(" ");
           if (map.containsKey(strings[0])){
               map.put(strings[0],(map.get(strings[0])+Double.parseDouble(strings[1])));
           } else map.put(strings[0], Double.valueOf(strings[1]));
        }
        br.close();
        fileReader.close();

        /*for (int i = 0; i < allStrings.size(); i++) {
            Pattern pattern = Pattern.compile("\\d.*");
            Matcher matcher = pattern.matcher(allStrings.get(i));
            while (matcher.find()) {
                String s = matcher.group();
                String name = allStrings.get(i).replaceAll("\\d.*", " ").trim();

                //Измение значения в Map
                map.merge(name, Double.valueOf(s),(a, b)->a+Double.parseDouble(s));
            }
        }*/
        // Сортировка Map
      /*LinkedHashMap<String,Double> sortedMap = map
              .entrySet()
              .stream()
              .sorted(comparingByKey())
              .collect(toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));*/

       /*map.forEach((a,b)-> System.out.println(a+" "+b));*/

        for (Map.Entry<String,Double> pair:map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }
}
