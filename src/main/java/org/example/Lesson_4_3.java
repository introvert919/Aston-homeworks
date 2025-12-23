package org.example;
import static org.example.Lesson_4_1.arrayCheck;
import static org.example.Lesson_4_1.result;
import static org.example.Lesson_4_2.arrayCheckIndex;

public class Lesson_4_3
{
    public static void main (String[]args)
    {
        // Задание 1-3.
        System.out.println("Задание 1-3");
        try
        {
            String[][] ArrayString = {{"1","2","3","4"},{"1","2!3","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
            arrayCheck(ArrayString,4,4);
            System.out.println("Сумма элементов массива = " + result);
        }
        catch (MyArraySizeException | MyArrayDataException e)
        {
            System.out.println(e.getMessage());
        }

        // Задание 4.
        System.out.println("Задание 4");
        try
        {
            int[] array = {1,2,3,4,5};
            arrayCheckIndex(array, 8);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
