import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;


class TestsTriangle
{
    public String triangleAreaCalculator(int side, int height)
    {
        if(side > 0 && height > 0)
        {
            return Integer.toString(side*height/2);
        }
        else
        {
            return ("Длина и высота треугольника не могут быть отрицательными.");
        }
    }

    @DisplayName("Площадь треугольника")
    @ParameterizedTest
    @CsvSource({"4,2,4", "-3,4,Длина и высота треугольника не могут быть отрицательными."})
    public void testTriangleArea(int side, int height, String expected)
    {
        String actual = triangleAreaCalculator(side, height);
        Assertions.assertEquals(expected, actual);
    }
}
