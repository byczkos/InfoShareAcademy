package com.infoshareacademy.kata;
public class StringCalculator {
    public Integer add(String numbers) throws NegativeNumberException {
        return  add(numbers,',');
    }
    public Integer add(String numbers, char delimiter) throws NegativeNumberException {
        if(numbers == null || numbers.isEmpty()) {
            return 0;
        }
        numbers = numbers.replace(delimiter, ',');
        String[] stringTable = numbers.split(",|\n");
        Integer result = 0;
        for (String s: stringTable) {
            try {
                Integer value = Integer.parseInt(s);
                if (value < 0) {
                    throw new NegativeNumberException();
                }
                if (value <= 1000) {
                    result += value;
                }
            } catch (NumberFormatException e) {
            }
        }
        return result;
    }
}
