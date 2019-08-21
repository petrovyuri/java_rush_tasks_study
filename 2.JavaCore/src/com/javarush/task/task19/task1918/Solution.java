package com.javarush.task.task19.task1918;


/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append((char) fileReader.read());
        }
        String string = stringBuilder.toString();
        br.close();
        fileReader.close();

        Document document = Jsoup.parse(string,  "", Parser.xmlParser());
        Elements elements = document.select(args[0]);
        for (Element element: elements){
            System.out.println(element);
        }
    }
}
