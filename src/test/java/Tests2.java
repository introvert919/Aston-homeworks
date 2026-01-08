import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

class TriangleArea
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
}

class Tests2
{
    @DataProvider(name = "testTriangleAreaCalculator")
    public Object[][] factorialData()
    {
        return new Object[][]
        {
            { 4, 2, "4" },
            { -3, 4, "Длина и высота треугольника не могут быть отрицательными."},
        };
    }

    @Test(dataProvider = "testTriangleAreaCalculator")
    public void testTriangleArea(int side, int height, String expected)
    {
        TriangleArea triangleArea = new TriangleArea();
        String actual = triangleArea.triangleAreaCalculator(side, height);
        assertEquals(expected, actual);
    }
}