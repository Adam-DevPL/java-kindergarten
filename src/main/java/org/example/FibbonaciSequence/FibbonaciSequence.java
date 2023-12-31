package org.example.FibbonaciSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibbonaciSequence {
    public static void main(String[] args) {

        if (args.length != 4) {
            throw new RuntimeException("Expected 4 arguments, got " + args.length);
        }

        List<Integer> firstNumbers = new ArrayList<>();
        int finalSizeOfFibonacciSeq = 0;

        try {
            finalSizeOfFibonacciSeq = Integer.parseInt(args[3]);
            for (int i = 0; i < 3; i++) {
                Integer arg = Integer.parseInt(args[i]);
                firstNumbers.add(arg);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error " + e);
            System.exit(1);
        }

        int[] result = sequence(firstNumbers, finalSizeOfFibonacciSeq);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sequence(List<Integer> firstNumbers, int finalSizeOfFibonacciSeq) {

        if (finalSizeOfFibonacciSeq < 3) {
            throw new RuntimeException("Size must be at least 3");
        }

        if (!isFibonacci(firstNumbers)) {
            throw new RuntimeException(firstNumbers + " is NOT in Fibonacci sequence");
        }


        int[] result = new int[finalSizeOfFibonacciSeq];
        for (int i = 0; i < firstNumbers.size(); i++) {
            result[i] = firstNumbers.get(i);
        }
        for (int i = firstNumbers.size(); i < finalSizeOfFibonacciSeq; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    private static boolean isFibonacci(List<Integer> n) {

        int firstNumberFromSequence = n.get(0);

        if (!checkNumberIfFibonacci(firstNumberFromSequence)) {
            return false;
        }

        for (int i = 0; i < n.size() - 1; i++) {
            double a = n.get(i) * (1 + Math.sqrt(5)) / 2.0;

            if (n.get(i + 1) != Math.round(a)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkNumberIfFibonacci(int n) {
        final int binetSimplification4 = 4;
        final int binetSimplification5 = 5;
        return (isPerfectSquare(binetSimplification5 * n * n + binetSimplification4) || isPerfectSquare(binetSimplification5 * n * n - binetSimplification4));
    }

    private static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }
}
