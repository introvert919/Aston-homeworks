import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;



class TestsArithmetic
{
    public String arithmeticCalculator(int firstNumber, int secondNumber, String method)
    {
        String result = "";
        switch (method)
        {
            case "+": result = Integer.toString(firstNumber + secondNumber);
                break;
            case "-": result = Integer.toString(firstNumber - secondNumber);
                break;
            case "*": result = Integer.toString(firstNumber * secondNumber);
                break;
            case "/":
                if(secondNumber != 0)
                {
                    result = Integer.toString(firstNumber / secondNumber);
                }
                else
                {
                    result = "На ноль делить нельзя.";
                }
        }
        return (result);
    }

    @DataProvider(name = "testArithmeticCalculator")
    public Object[][] arithmeticData()
    {
        return new Object[][]
                {
                        { 2, 2, "+", "4" },
                        { 2, 2, "-", "0"},
                        { 2, 2, "*", "4"},
                        { 2, 2, "/", "1"},
                        { 2, 0, "/", "На ноль делить нельзя."}
                };
    }

    @Test(dataProvider = "testArithmeticCalculator")
    public void testArithmeticCalculator(int firstNumber, int secondNumber, String method, String expected)
    {
        String actual = arithmeticCalculator(firstNumber, secondNumber, method);
        assertEquals(expected, actual);
    }
}