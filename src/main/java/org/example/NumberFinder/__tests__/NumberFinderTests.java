package org.example.NumberFinder.__tests__;

import org.example.NumberFinder.NumberFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberFinderTests {

    @Test
    public void testLowestNumberFinder() {
        //given
        Integer[][] numbers = {{1000, 6, 3}, {9, 100, 6}, {71, 8, 119}};

        //when
        NumberFinder.SortedNumbers<Integer> result = NumberFinder.lowestNumberFinder(numbers);

        //then
        Assertions.assertEquals(3, result.getLowestNumber());
        Assertions.assertEquals(Arrays.asList(3, 6, 1000), result.getSortedNumbers());
    }

    @Test
    public void testLowestNumberFinder_EmptyArray() {
        //given
        Integer[][] numbers = {};
        String expectedMsg = "Array is empty";

        //then
        Exception exception = assertThrows(RuntimeException.class, () -> NumberFinder.lowestNumberFinder(numbers));
        String actualMsg = exception.getMessage();
        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    public void testLowestNumberFinder_SingleArray() {
        //given
        Integer[][] numbers = {{9, 3, 6, 2}};

        //when
        NumberFinder.SortedNumbers<Integer> result = NumberFinder.lowestNumberFinder(numbers);

        //then
        Assertions.assertEquals(2, result.getLowestNumber());
        Assertions.assertEquals(Arrays.asList(2, 3, 6, 9), result.getSortedNumbers());
    }

    @Test
    public void testLowestNumberFinder_NegativeNumbers() {
        //given
        Integer[][] numbers = {{-5, -10, -3}, {-2, -8, -1}, {-7, -4, -9}};

        //when
        NumberFinder.SortedNumbers<Integer> result = NumberFinder.lowestNumberFinder(numbers);

        //then
        Assertions.assertEquals(-10, result.getLowestNumber());
        Assertions.assertEquals(Arrays.asList(-10, -5, -3), result.getSortedNumbers());
    }
}
