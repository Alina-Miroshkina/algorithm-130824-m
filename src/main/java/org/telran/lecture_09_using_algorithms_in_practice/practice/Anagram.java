package org.telran.lecture_09_using_algorithms_in_practice.practice;

// Даны две строки.
// Проверить, являются ли они анаграммами (состоят из одних и тех же букв, но в разном порядке).

public class Anagram {
}

Решение:
import java.util.Arrays;

public class Anagram {

    // Метод для проверки, являются ли две строки анаграммами
    public static boolean areAnagrams(String str1, String str2) {
        // Удаляем пробелы и приводим строки к нижнему регистру
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Если длины строк не равны, они не могут быть анаграммами
        if (str1.length() != str2.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Сортируем массивы символов
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Сравниваем отсортированные массивы символов
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " и " + str2 + " являются анаграммами.");
        } else {
            System.out.println(str1 + " и " + str2 + " не являются анаграммами.");
        }
    }
}
