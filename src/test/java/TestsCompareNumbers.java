import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;



public class TestsCompareNumbers
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

    @DataProvider(name = "testCompareTwoNumbers")
    public Object[][] numberData()
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
        String actual = compareTwoNumbers(firstNumber, secondNumber);
        assertEquals(expected, actual);
    }
}