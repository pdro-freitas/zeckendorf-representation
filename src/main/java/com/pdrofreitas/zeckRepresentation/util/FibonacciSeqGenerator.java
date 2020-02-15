package com.pdrofreitas.zeckRepresentation.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciSeqGenerator {
    private static List<Integer> getFibonacciSequence(final int maxValue, List<Integer> fibonacciNumbers) {
        int nextFibonacciNumber = 2;
        while (nextFibonacciNumber <= maxValue) {
            fibonacciNumbers.add(nextFibonacciNumber);
            nextFibonacciNumber += fibonacciNumbers.get(fibonacciNumbers.size() - 2);
        }
        return fibonacciNumbers;
    }

    public static List<Integer> getFibonacciSequence(final int maxValue) {

        List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(1);

        getFibonacciSequence(maxValue, fibonacciNumbers);
        return fibonacciNumbers;
    }

    public static List<Integer> getFibonacciSequenceReversed(final int maxValue) {
        return getFibonacciSequence(maxValue).stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
