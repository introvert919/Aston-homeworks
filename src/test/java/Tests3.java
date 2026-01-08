import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;


class Arithmetic
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
}

class Tests3
{
    @DisplayName("Арифметические действия с двумя числами")
    @ParameterizedTest
    @CsvSource({"2,2,+,4", "2,2,-,0", "2,2,*,4", "2,2,/,1"})
    public void testTriangleArea(int firstNumber, int secondNumber, String method, int expected)
    {
        Arithmetic arithmetic = new Arithmetic();
        int actual = arithmetic.arithmeticCalculator(firstNumber, secondNumber, method);
        Assertions.assertEquals(expected, actual);
    }
}
