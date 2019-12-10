package com.company;

import java.io.*;

public class Picture {

    public static void main(String[] args) {
        File dir = new File("./picture");
        if (dir.mkdir()) {
            System.out.println("Папка создана");
        } else {
            System.out.println("Проблемы в создании папки");
        }

        File file = new File(dir, "./picture.jpeg");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Проблема в создании файла");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try (FileInputStream fileInputStream = new FileInputStream(("C:\\Users\\Lena & Vlad\\Desktop\\My Java education\\Home Work\\picture.jpg"));
                 FileOutputStream fileOutputStream = new FileOutputStream(("C:\\Users\\Lena & Vlad\\Desktop\\My Java education\\Home Work\\D.Z.10CopyPictureVocabularyIOStreams\\picture\\picture.jpeg"))
            ) {
                int temp;
                while ((temp = fileInputStream.read()) != -1) {
                    System.out.print((char) temp);
                    fileOutputStream.write(temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

