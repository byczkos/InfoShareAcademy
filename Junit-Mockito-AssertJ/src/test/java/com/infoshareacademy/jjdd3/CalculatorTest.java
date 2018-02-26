package com.infoshareacademy.jjdd3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = {"/subtraction"}, delimiter = ';')
    void shouldSubtractIntegerNumbers(int x, int y, int expectedResult){
        assertEquals(Calculator.subtraction(x,y),expectedResult);
    }
}
