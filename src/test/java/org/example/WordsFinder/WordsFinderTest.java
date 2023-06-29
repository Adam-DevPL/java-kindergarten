package org.example.WordsFinder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordsFinderTest {

    @Test
    public void testWordsFinder() {

        //given
        String example = "Ala ma kota, kot koduje w Javie Kota";

        //when
        Map<String, Integer> result = WordsFinder.wordsFinder(example);

        //then
        Assertions.assertEquals(7, result.size());
        Assertions.assertEquals(1, result.get("ala"));
        Assertions.assertEquals(2, result.get("kota"));
        Assertions.assertEquals(1, result.get("ma"));
        Assertions.assertEquals(1, result.get("kot"));
        Assertions.assertEquals(1, result.get("koduje"));
        Assertions.assertEquals(1, result.get("javie"));
        Assertions.assertEquals(1, result.get("w"));
    }

    @Test
    public void testWordsFinderWithEmptyText() {

        //given
        String emptyText = "";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> WordsFinder.wordsFinder(emptyText));
    }

    @Test
    public void testWordsFinderWithNullText() {

        //given
        String nullText = null;

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> WordsFinder.wordsFinder(nullText));
    }

    @Test
    public void testWordsFinderWithSpecialCharacters() {

        //given
        String text = "Hello, world! How are you? Are you doing well?";

        //when
        Map<String, Integer> result = WordsFinder.wordsFinder(text);


        //then
        Assertions.assertEquals(7, result.size());
        Assertions.assertEquals(1, result.get("hello"));
        Assertions.assertEquals(1, result.get("world"));
        Assertions.assertEquals(1, result.get("how"));
        Assertions.assertEquals(2, result.get("are"));
        Assertions.assertEquals(2, result.get("you"));
        Assertions.assertEquals(1, result.get("doing"));
        Assertions.assertEquals(1, result.get("well"));
    }

    @Test
    public void testWordsFinderWithMultipleSpaces() {

        //given
        String text = "   This    text  has    multiple  spaces    ";

        //when
        Map<String, Integer> result = WordsFinder.wordsFinder(text);

        //then
        Assertions.assertEquals(5, result.size());
        Assertions.assertEquals(1, result.get("this"));
        Assertions.assertEquals(1, result.get("text"));
        Assertions.assertEquals(1, result.get("has"));
        Assertions.assertEquals(1, result.get("multiple"));
        Assertions.assertEquals(1, result.get("spaces"));
    }

}