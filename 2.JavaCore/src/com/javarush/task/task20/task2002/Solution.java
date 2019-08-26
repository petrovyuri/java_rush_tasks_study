package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream(new File("2002"));
            InputStream inputStream = new FileInputStream("2002");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            users.add(user);
            users.add(user1);

            for (int i = 0; i < users.size(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(users.get(i).getFirstName() + " ");
                stringBuilder.append(users.get(i).getLastName() + " ");
                stringBuilder.append(users.get(i).getBirthDate().getTime() + " ");
                stringBuilder.append(users.get(i).isMale() + " ");
                stringBuilder.append(users.get(i).getCountry() + " ");
                byte[] bytes = stringBuilder.toString().getBytes();
                outputStream.write(bytes);
                outputStream.write(10);
            }

        }

        public void load(InputStream inputStream) throws Exception {
            if (users != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String s = "";
                while ((s = br.readLine()) != null) {
                    String[] strings = s.split(" ");
                    User user = new User();
                    user.setFirstName(strings[0]);
                    user.setLastName(strings[1]);
                    Date date = new Date();
                    date.setTime(Long.parseLong(strings[2]));
                    user.setBirthDate(date);
                    user.setMale(Boolean.parseBoolean(strings[3]));
                    user.setCountry(User.Country.valueOf(strings[4]));
                    users.add(user);
                }
                br.close();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
