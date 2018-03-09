package com.infoshareacademy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void addCorrectValues() {

        Calculator calculator = new Calculator();
        //GIVEN
        Integer a = 2;
        Integer b = 4;

        Integer expected = a + b;

        //WHEN
        Integer result = calculator.add(new Integer[]{a, b});

        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void addManyValues() {

        Calculator calculator = new Calculator();
        //GIVEN
        Integer[] params = {1, 2, 3, 4};
        Integer expected = 1 + 2 + 3 + 4;

        //WHEN
        Integer result = calculator.add(params);

        //THEN
        assertEquals(expected, result);
    }

}