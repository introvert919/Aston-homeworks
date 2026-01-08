import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

/* Создайте 2 ветки: Lesson_7_junit_5 и Lesson_7_testng.
Напишите 4 программы:
позволяющую вычислить факториал числа;
позволяющую найти площадь треугольника;
совершающую арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение);
сравнивающую два целых числа.
Эти программы должны быть в каждой ветке
В ветке Lesson_7_junit_5 напишите юнит-тесты для этих программ, используя Junit 5.
В ветке Lesson_7_testng  напишите юнит-тесты для этих программ, используя TestNG.*/

class Factorial
{
    public String factorialCalculator(int number)
    {
        if(number > 0)
        {
            int result = 1;
            for (int i = 1; i <= number; i++)
            {
                result = result * i;
            }
            return Integer.toString(result);
        }
        else if(number == 0)
        {
            return "1";
        }
        else
        {
            return ("Факториал отрицательного числа не определен.");
        }
    }
}

public class TestsFactorial
{
    @DisplayName("Факториал числа")
    @ParameterizedTest
    @CsvSource({"4,24", "0,1", "-4,Факториал отрицательного числа не определен."})
    public void testFactorial(int number, String expected)
    {
        Factorial factorial = new Factorial();
        String actual = factorial.factorialCalculator(number);
        Assertions.assertEquals(expected, actual);
    }
}