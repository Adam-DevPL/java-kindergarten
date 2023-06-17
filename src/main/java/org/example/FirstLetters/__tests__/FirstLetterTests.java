package org.example.FirstLetters.__tests__;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.FirstLetters.FirstLetter.changeFirstLetter;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstLetterTests {

    @Test
    @DisplayName("Test changeFirstLetter")
    public void testChangeFirstLetter() {

        //given
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("programming");

        List<String> expected = new ArrayList<>();
        expected.add("Hello");
        expected.add("World");
        expected.add("Java");
        expected.add("Programming");

        //when
        List<String> result = changeFirstLetter(words);

        //then
        assert Arrays.equals(expected.toArray(), result.toArray());
    }

    @Test
    @DisplayName("Test changeFirstLetter with empty list")
    public void testChangeFirstLetterWithEmptyList() {

        //given
        List<String> words = new ArrayList<>();
        String expectedMsg = "List is empty";

        //then
        Exception exception = assertThrows(RuntimeException.class, () -> changeFirstLetter(words));
        String actualMsg = exception.getMessage();
        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    @DisplayName("Test changeFirstLetter with null list")
    public void testChangeFirstLetterWithNullList() {

        //given
        List<String> words = null;
        String expectedMsg = "List is empty";

        //then
        Exception exception = assertThrows(RuntimeException.class, () -> changeFirstLetter(words));
        String actualMsg = exception.getMessage();
        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    @DisplayName("Test changeFirstLetter with first character not a letter")
    public void testChangeFirstLetterWithFirstCharacterNotALetter() {

        //given
        List<String> words = new ArrayList<>();
        words.add("1hello");
        String expectedMsg = "First character is not a letter";

        //then
        Exception exception = assertThrows(RuntimeException.class, () -> changeFirstLetter(words));
        String actualMsg = exception.getMessage();
        assertTrue(actualMsg.contains(expectedMsg));
    }
}
