package com.javarush.task.task20.task2001;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream(new File("2001.html"));
            InputStream inputStream = new FileInputStream(new File("2001.html"));

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            if (ivanov.equals(somePerson)){
                System.out.println("OK");
            } else System.out.println("PROBLEM");

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<Person><name>" + this.name + "</name>");
            for (int i = 0; i < assets.size(); i++) {
                stringBuilder.append("<asset>" + assets.get(i).getName() + " " + assets.get(i).getPrice() + "</asset>");

            }
            stringBuilder.append("</Person>");
            byte[] bytes = stringBuilder.toString().getBytes();
            outputStream.write(bytes);
            outputStream.write(10);
        }

        public void load(InputStream inputStream) throws Exception {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String string = "";

            while ((string = bufferedReader.readLine()) != null) {
                Document document = Jsoup.parse(string, "", Parser.xmlParser());
                this.name = document.select("name").text();
                Elements elements = document.select("asset");
                for (Element element : elements) {
                    String [] strings = element.text().split("\\s");
                    assets.add(new Asset(strings[0],Double.parseDouble(strings[1])));
                }
            }


        }
    }
}
