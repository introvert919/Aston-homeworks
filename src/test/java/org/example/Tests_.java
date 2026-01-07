package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;


class Numbers
{
    public boolean compareTwoNumbers(int firstNumber, int secondNumber)
    {
        return (firstNumber > secondNumber);
    }
}

public class Tests_
{
    @DisplayName("Сравнение двух целых чисел")
    @ParameterizedTest
    @CsvSource({"4,3,true", "3,4,false", "4,4,false"})

    void testCompareTwoNumbers(int firstNumber, int secondNumber, boolean expected)
    {
        Numbers numbers = new Numbers();
        boolean actual = numbers.compareTwoNumbers(firstNumber, secondNumber);
        Assertions.assertEquals(expected, actual);
    }
}