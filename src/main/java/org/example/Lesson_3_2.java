package org.example;

/*Задание 2
Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
круг, прямоугольник, треугольник.
Задать для каждой фигуры цвет заливки и цвет границы.
Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ]
по каждой фигуре вывести в консоль.
Попробуйте реализовать базовые методы, такие как расчет периметра фигур,
в качестве дефолтных методов в интерфейсе.*/

interface GeometryFormulas
{
    // Периметр круга.
    public default double circlePerimeter(int radius)
    {
        return(2*Math.PI*radius);
    }

    // Площадь круга.
    public default double circleArea(int radius)
    {
        return(Math.PI*Math.pow(radius,2));
    }

    // Периметр прямоугольника.
    public default double rectanglePerimeter (int length, int width)
    {
        return(2*length + 2*width);
    }

    // Площадь прямугольника.
    public default double rectangleArea(int length, int width)
    {
        return(length*width);
    }

    // Периметр треугольника.
    public default double trianglePerimeter (int side1, int side2, int side3)
    {
        return(side1 + side2 + side3);
    }

    // Площадь треугольника.
    public default double triangleArea (int side1, int hight)
    {
        return((double)(side1 * hight)/2);
    }

    // Цвет заливки.
    public String fillColor(String color);

    // Цвет границы.
    public String borderColor(String color);
}

class Geometry implements GeometryFormulas
{
    public String fillColor(String color)
    {
        return(color);

    }
    public String borderColor(String color)
    {
        return(color);
    }
}


