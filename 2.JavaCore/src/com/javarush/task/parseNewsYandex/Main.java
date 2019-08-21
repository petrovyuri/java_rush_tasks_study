package com.javarush.task.parseNewsYandex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://yandex.ru/")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        Elements listNews = doc.select("div#tabnews_newsc.content-tabs__items.content-tabs__items_active_true");
        System.out.println(listNews);
    }
}
