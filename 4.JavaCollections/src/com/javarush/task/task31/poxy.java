package com.javarush.task.task31;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class poxy {
    public static void main(String[] args) {
        //Создаем оригинальный объект
        Man vasia = new Man("Вася", 30, "Санкт-Петербург", "Россия");

        ClassLoader classLoader = vasia.getClass().getClassLoader();
        Class[] interFaces = vasia.getClass().getInterfaces();

        Person proxyVasia = (Person) Proxy.newProxyInstance(classLoader, interFaces, new PersonInvocationHandler(vasia));
        proxyVasia.introduce(vasia.getName());

    }

    public static class PersonInvocationHandler implements InvocationHandler {
        private Person person;

        public PersonInvocationHandler(Person person) {
            this.person = person;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Hello");
            return null;
        }
    }


    public interface Person {

        public void introduce(String name);

        public void sayAge(int age);

        public void sayFrom(String city, String country);
    }

    public static class Man implements Person {

        private String name;
        private int age;
        private String city;
        private String country;

        public Man(String name, int age, String city, String country) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }

        @Override
        public void introduce(String name) {

            System.out.println("Меня зовут " + this.name);
        }

        @Override
        public void sayAge(int age) {
            System.out.println("Мне " + this.age + " лет");
        }

        @Override
        public void sayFrom(String city, String country) {

            System.out.println("Я из города " + this.city + ", " + this.country);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
