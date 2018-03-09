package com.infoshareacademy.kata;
import org.junit.Test;
import static org.junit.Assert.*;
public class StringCalculatorTest {
    public StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void addTwoStrings() throws NegativeNumberException {
        //GIVEN
        String a = "1,2";
        Integer expected = 3;
        //WHEN
        Integer result = stringCalculator.add(a);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void incorrectString() throws NegativeNumberException {
        //GIVEN
        String a = "1,2,ads,5";
        Integer expected = 8;
        //WHEN
        Integer result = stringCalculator.add(a);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void addEmptyStrings() throws NegativeNumberException {
        //GIVEN
        String a = "";
        Integer expected = 0;
        //WHEN
        Integer result = stringCalculator.add(a);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void addManyNumbers() throws NegativeNumberException {
        //GIVEN
        String a = "1,2,5,13,5,0,3";
        Integer expected = 1 + 2 + 5 + 13 + 5 + 0 + 3;
        //WHEN
        Integer result = stringCalculator.add(a);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void addWithNewLineSign() throws NegativeNumberException {
        //GIVEN
        String a = "1,2\n3,4";
        Integer expected = 10;
        //WHEN
        Integer result = stringCalculator.add(a);
        //THEN
        assertEquals(expected, result);
    }
    @Test
    public void addWithCustomDelimiter() throws NegativeNumberException {
        //GIVEN
        String a = "1,2\n3;4";
        Integer expected = 10;
        //WHEN
        Integer result = stringCalculator.add(a,';');
        //THEN
        assertEquals(expected, result);
    }
    @Test (expected = NegativeNumberException.class)
    public void addNegative() throws NegativeNumberException {
        //GIVEN
        String a = "1,-4";
        //WHEN
        Integer result = stringCalculator.add(a);
        //THEN
    }
    @Test
    public void addGreaterThen1000() throws NegativeNumberException {
        //GIVEN
        String a = "1,2,1001";
        Integer expected = 3;
        //WHEN
        Integer result = stringCalculator.add(a,';');
        //THEN
        assertEquals(expected, result);
    }
}