package com.jwetherell.algorithms.mathematics.test;

import com.jwetherell.algorithms.mathematics.Knapsack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    /**
     * Add missing test coverage of zeroOneKnapsack method of Knapsack Class.
     * Test that the method returns null if values and weights are not of the same length.
     */
    @Test
    public void zeroOneKnapsackTest(){
        int[] values = {0, 1};
        int[] weights = {0, 0, 0};
        int capacity = 5;
        assertEquals(null, Knapsack.zeroOneKnapsack(values, weights, capacity));
    }
}
