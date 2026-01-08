import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

class Numbers
{
    public String compareTwoNumbers(int firstNumber, int secondNumber)
    {
        if(firstNumber > secondNumber)
        {
            return ("Первое число больше второго.");
        }
        else if(firstNumber < secondNumber)
        {
            return ("Первое число меньше второго.");
        }
        else
        {
            return ("Первое число равно второму.");
        }
    }
}

public class Tests4
{
    @DisplayName("Сравнение двух целых чисел")
    @ParameterizedTest
    @CsvSource({"4,3,Первое число больше второго.", "3,4,Первое число меньше второго.", "4,4,Первое число равно второму."})
    public void testCompareTwoNumbers(int firstNumber, int secondNumber, String expected)
    {
        Numbers numbers = new Numbers();
        String actual = numbers.compareTwoNumbers(firstNumber, secondNumber);
        Assertions.assertEquals(expected, actual);
    }
}
