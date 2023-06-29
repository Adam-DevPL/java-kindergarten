package org.example.FibbonaciSequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibbonaciSequenceTest {

    @Test
    @DisplayName("generate Fibonacci sequence")
    public void sequenceTest() {
        //given
        List<Integer> firstNumbers = List.of(1, 2, 3);
        int size = 10;
        int[] expected = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

        //when
        int[] result = FibbonaciSequence.sequence(firstNumbers, size);

        //then
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("first number is not in Fibonacci sequence")
    public void sequenceTest2() {
        //given
        List<Integer> firstNumbers = List.of(3, 3, 5);
        int size = 10;
        String expectedMsg = "[3, 3, 5] is NOT in Fibonacci sequence";

        //then
        assertThrowsExactly(RuntimeException.class, () -> FibbonaciSequence.sequence(firstNumbers, size), expectedMsg);
    }

    @Test
    @DisplayName("next number is not in Fibonacci sequence")
    public void sequenceTest4() {
        //given
        List<Integer> firstNumbers = List.of(1, 2, 8);
        int size = 10;
        String expectedMsg = "[1, 2, 8] is NOT in Fibonacci sequence";

        //then
        assertThrowsExactly(RuntimeException.class, () -> FibbonaciSequence.sequence(firstNumbers, size), expectedMsg);
    }

    @Test
    @DisplayName("size is less than 3")
    public void sequenceTest3() {
        //given
        List<Integer> firstNumbers = List.of(1, 2, 3);
        int size = 2;
        String expectedMsg = "Size must be at least 3";

        //then
        Exception exception = assertThrowsExactly(RuntimeException.class, () -> FibbonaciSequence.sequence(firstNumbers, size), expectedMsg);
    }
}