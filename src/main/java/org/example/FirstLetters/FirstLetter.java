package org.example.FirstLetters;

import java.util.ArrayList;
import java.util.List;

public class FirstLetter {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("programming");

        List<String> result = changeFirstLetter(words);
        System.out.println(result);
    }

    public static List<String> changeFirstLetter(List<String> words) {

        if (words == null || words.isEmpty()) {
            throw new NullPointerException ("List is empty");
        }

        List<String> result = new ArrayList<>(words);

        for (int i = 0; i < result.size(); i++) {
            String word = result.get(i);

            if (!Character.isLetter(word.charAt(0))) {
                continue;
            }

            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            result.set(i, word);
        }

        return result;
    }
}
