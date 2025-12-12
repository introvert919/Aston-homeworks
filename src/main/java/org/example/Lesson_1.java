package org.example;
import java.util.Arrays;

public class Lesson_1
{
// Задача 1. Создайте метод printThreeWords(), который при вызове должен отпечатать
    // в столбец три слова: Orange, Banana, Apple.

    public static void printThreeWords()
    {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задача 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать
    // эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
    // в противном случае - “Сумма отрицательная”.

    public static void checkSumSign()
    {
        int a = 2;
        int b = 3;

        int result = a + b;
        if (result >= 0)
        {
            System.out.print("Сумма положительная");
        }
        else
        {
            System.out.print("Сумма отрицательная");
        }
    }

    // Задача 3. Создайте метод printColor() в теле которого задайте int переменную value
    // и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
    // то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах
    // от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    // если больше 100 (100 исключительно) - “Зеленый”.

    public static void printColor()
    {
        int value = 5;
        if (value <= 0)
        {
            System.out.print("Красный");
        }
        else if(value > 0 & value <= 100)
        {
            System.out.print("Желтый");
        }
        else
        {
            System.out.print("Зеленый");
        }
    }

    // Задача 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
    // то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”.

    public static void compareNumbers()
    {
        int a = 3;
        int b = 4;

        if (a >= b)
        {
            System.out.print("a >= b");
        }
        else
        {
            System.out.print("a < b");
        }
    }

    // Задача 5. Напишите метод, принимающий на вход два целых числа и проверяющий,
    // что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
    // в противном случае – false.

    public static boolean checkSum(int a, int b)
    {
        int sum;
        if(a + b >= 10 & a + b <= 20)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Задача 6. Напишите метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.

    public static void checkNumber(int a)
    {
        if(a >= 0)
        {
            System.out.print("Число положительное");
        }
        else
        {
            System.out.print("Число отрицательное");
        }

    }

    //Задача 7. Напишите метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    //Замечание: ноль считаем положительным числом.

    public static boolean checkNumberBool(int a)
    {
        if(a >= 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //Задача 8. Напишите метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз.

    public static void printStringNTimes(String str, int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.println(str);
        }
    }

    // Задача 9. Напишите метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean leapYear(int year)
    {
        if(year % 4 == 0 & year % 100 != 0 || year % 400 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Задача 10. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0.

    public static void changeArrayValues()
    {
        int[] array = {1, 1, 0, 0, 1, 0};
        for(int i = 0; i < 6; i++)
        {
            if(array[i] == 1)
            {
                array[i] = 0;
            }
            else
            {
                array[i] = 1;
            }
        }

        System.out.print(Arrays.toString(array));
    }

    // Задача 11. Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100.

    public static void fillArray()
    {
        int[] array = new int[100];
        for (int i = 0 ; i < 100; i++)
        {
            array[i] = i + 1;
        }
        System.out.print(Arrays.toString(array));
    }

    // Задача 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2.

    public static void arrayChangeLessSix()
    {
        int array[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < 12; i++)
        {
            if (array[i] < 6)
            {
                array[i] *= 2;
            }
            else
            {
                continue;
            }
        }
        System.out.print(Arrays.toString(array));
    }

    // Задача 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    // если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
    // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n].

    public static void squareArray()
    {
        int [][] array = new int[6][6];
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                if(i == j || i == 5 - j)
                {
                    array[i][j] = 1;
                }
                else
                {
                    continue;
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
    }

    // Задача 14. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.

    public static void fillArrayLengthValue(int len, int initialValue)
    {
        int [] array = new int[len];
        for (int i = 0; i < len; i++)
        {
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args)
    {
        //printThreeWords();                        // Задача 1.
        //checkSumSign();                           // Задача 2.
        //printColor();                             // Задача 3.
        //compareNumbers();                         // Задача 4.
        //System.out.println(checkSum(7, 8));       // Задача 5.
        //checkNumber(3);                           // Задача 6.
        //System.out.println(checkNumberBool(4));   // Задача 7.
        //printStringNTimes("Hello", 5);            // Задача 8.
        //System.out.println(leapYear(2024));       // Задача 9.
        //changeArrayValues();                      // Задача 10
        //fillArray();                              // Задача 11.
        //arrayChangeLessSix();                     // Задача 12.
        //squareArray();                            // Задача 13.
        //fillArrayLengthValue(5, 10);              // Задача 14.
    }
}
