package com.company;


import java.io.*;
import java.util.*;


public class Vocabulary {
    public static void main(String[] args) {
        File folder = new File("./vocabulary");
        if (folder.mkdir()) {
            System.out.println("Папка создана");
        } else {
            System.out.println("Ошибка в создании папки");
        }
        File vocabulary = new File(folder, "./vocabulary.txt");
        try {
            if (vocabulary.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл не создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try (FileReader fileReader = new FileReader(("C:\\Users\\Lena & Vlad\\Desktop\\My Java education\\Home Work\\vocabulary.txt"));
                 FileWriter fileWriter = new FileWriter(("C:\\Users\\Lena & Vlad\\Desktop\\My Java education\\Home Work\\D.Z.10CopyPictureVocabularyIOStreams\\vocabulary\\vocabulary.txt"))
            ) {
                int temp;
                while ((temp = fileReader.read()) != -1) {
                    fileWriter.write(temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> words = new HashMap<>();


        try (Scanner scr = new Scanner(new FileInputStream("C:\\Users\\Lena & Vlad\\Desktop\\My Java education\\Home Work\\D.Z.10CopyPictureVocabularyIOStreams\\vocabulary\\vocabulary.txt"))) {
            String temp;
            System.out.println("Вы используете словарь. С какого языка Вам необходим перевод?");
            System.out.println("Если с Английского на Русский нажмите 2, с Русского на Английский 1");
            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();
            while ((scr.hasNextLine())) {
                temp = scr.nextLine();
                String[] a = temp.split(" ", 2);
                if (b == 1) {
                    words.put(a[0], a[1]);
                } else {
                    words.put(a[1], a[0]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Выберите слово необходимое для перевода и введите его вручную:");
        for (String s : words.keySet()) {
            System.out.println(s);
        }
        Scanner word = new Scanner(System.in);
        String d = word.nextLine();
        System.out.println(words.get(d));
    }
}




