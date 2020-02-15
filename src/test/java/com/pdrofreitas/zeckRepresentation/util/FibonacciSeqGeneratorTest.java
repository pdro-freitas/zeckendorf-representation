package com.pdrofreitas.zeckRepresentation.util;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;

class FibonacciSeqGeneratorTest {

    private static final List<Integer> FIB_SEQ_21 = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
        add(5);
        add(8);
        add(13);
        add(21);
    }};

    @Test
    void getFibonacciSequence() {

        List<Integer> fibonacciSequence = FibonacciSeqGenerator.getFibonacciSequence(21);

        Assert.that(fibonacciSequence.equals(FIB_SEQ_21), "Fibonacci sequence does not match!");
    }
}