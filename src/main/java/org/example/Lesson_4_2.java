package org.example;

/* Задание 4. Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.*/

class ArrayIndexOutOfBoundsException extends Exception
{
    public ArrayIndexOutOfBoundsException(String message)
    {
        super(message);
    }
}

public class Lesson_4_2
{
    public static void arrayCheckIndex(int[] array, int arrayIndex) throws ArrayIndexOutOfBoundsException
    {
        int count = 0;
        for (int i : array)
        {
            count++;
        }
        if (arrayIndex > count | arrayIndex < 0)
        {
            throw new ArrayIndexOutOfBoundsException ("Выход за пределы массива.");
        }
    }
}
