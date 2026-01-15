import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;



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

    @DataProvider(name = "testTriangleAreaCalculator")
    public Object[][] triangleData()
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
        String actual = triangleAreaCalculator(side, height);
        assertEquals(expected, actual);
    }
}