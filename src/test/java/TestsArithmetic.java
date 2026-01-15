import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;


class TestsArithmetic
{
    public int arithmeticCalculator(int firstNumber, int secondNumber, String method)
    {
        int result = 0;
        switch (method)
        {
            case "+": result = firstNumber + secondNumber;
                break;
            case "-": result = firstNumber - secondNumber;
                break;
            case "*": result = firstNumber * secondNumber;
                break;
            case "/": result = firstNumber / secondNumber;
        }
        return (result);
    }

    @DisplayName("Арифметические действия с двумя числами")
    @ParameterizedTest
    @CsvSource({"2,2,+,4", "2,2,-,0", "2,2,*,4", "2,2,/,1"})
    public void testArithmeticCalculator(int firstNumber, int secondNumber, String method, int expected)
    {
        int actual = arithmeticCalculator(firstNumber, secondNumber, method);
        Assertions.assertEquals(expected, actual);
    }
}
