package com.javarush.task.task31.zip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void main(String[] args) throws IOException {

// создаем архив
        FileOutputStream zipFile = new FileOutputStream("archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

//кладем в него ZipEntry – «архивный объект»
        zip.putNextEntry(new ZipEntry("doc.txt"));


// закрываем архив
        zip.close();

    }

}
