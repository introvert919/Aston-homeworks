package org.example;

/* Задание 1-3.
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось
(например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией,
в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.*/

class MyArraySizeException extends Exception
{
    public MyArraySizeException(String message)
    {
        super(message);
    }
}

class MyArrayDataException extends Exception
{
    public MyArrayDataException(String message)
    {
        super(message);
    }
}

public class Lesson_4_1
{
    static int result = 0;
    public static void arrayCheck(String[][] ArrayString, int rows, int columns)
            throws MyArraySizeException, MyArrayDataException
    {
        // Проверка размера массива.
        if (rows !=4 | columns != 4)
        {
            throw new MyArraySizeException("Размер строк и колонок должен быть равен 4");
        }

        // Проверка символов массива.
            for (int i = 0; i <rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    String numbers = "0123456789";
                    char[] arrayChar = ArrayString[i][j].toCharArray();
                    for(int k = 0; k < ArrayString[i][j].length(); k++)
                    {
                        if(!numbers.contains(Character.toString(arrayChar[k])))
                        {
                            throw new MyArrayDataException
                                    ("Элемент массива ArrayString" + "[" + i + "]" + "[" + j + "]" + " не является числом.");
                        }
                    }
                    result += Integer.parseInt(ArrayString[i][j]);
                }
            }
    }
}
