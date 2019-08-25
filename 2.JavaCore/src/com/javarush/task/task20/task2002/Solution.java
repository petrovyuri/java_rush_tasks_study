package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
            List<User> users = javaRush.users;
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.users = users;
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if (javaRush.equals(loadedObject)) {
                System.out.println("ok");
            }

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
            User user1 = new User();
            user1.setMale(true);
            user1.setFirstName("Yura");
            user1.setLastName("Petrov");
            user1.setCountry(User.Country.RUSSIA);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date birthDate = simpleDateFormat.parse("18-02-1984");
            user1.setBirthDate(birthDate);
            users.add(user1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(user1.getFirstName() + "-");
            stringBuilder.append(user1.getLastName() + "-");
            stringBuilder.append(user1.isMale() + "-");
            stringBuilder.append(user1.getCountry() + "-");
            stringBuilder.append(user1.getBirthDate());
            byte[] string = stringBuilder.toString().getBytes();
            outputStream.write(string);
            outputStream.write(32);
        }

        public void load(InputStream inputStream) throws Exception {

            User user = new User();
            if (users.size() > 0) {
               user.setBirthDate(users.get(0).getBirthDate());
               user.setCountry(users.get(0).getCountry());
               user.setMale(users.get(0).isMale());
               user.setFirstName(users.get(0).getFirstName());
               user.setLastName(users.get(0).getLastName());
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String string = br.readLine();
                String[] strings = string.split("-");
                user.setFirstName(strings[0]);
                user.setLastName(strings[1]);
                user.setMale(Boolean.parseBoolean(strings[2]));
                user.setCountry(User.Country.valueOf(strings[3]));
                SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                Date date = formatter.parse(strings[4]);
                user.setBirthDate(date);
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
