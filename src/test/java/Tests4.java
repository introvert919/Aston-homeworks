import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
    @DataProvider(name = "testCompareTwoNumbers")
    public Object[][] factorialData()
    {
        return new Object[][]
                {
                        { 4, 3, "Первое число больше второго."},
                        { 3, 4, "Первое число меньше второго."},
                        { 4, 4, "Первое число равно второму."},
                };
    }

    @Test(dataProvider = "testCompareTwoNumbers")
    public void testCompareTwoNumbers(int firstNumber, int secondNumber, String expected)
    {
        Numbers numbers = new Numbers();
        String actual = numbers.compareTwoNumbers(firstNumber, secondNumber);
        assertEquals(expected, actual);
    }
}