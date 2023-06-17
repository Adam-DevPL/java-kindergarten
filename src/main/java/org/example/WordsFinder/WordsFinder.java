package org.example.WordsFinder;

import java.util.*;

public class WordsFinder {
    public static void main(String[] args) {
        String example = "Ala ma kota, kot koduje w Javie Kota";
        System.out.println(wordsFinder(example));
    }

    public static Map<String, Integer> wordsFinder(String text) {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }

        Map<String, Integer> result = new TreeMap<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }

        return result;
    }
}
