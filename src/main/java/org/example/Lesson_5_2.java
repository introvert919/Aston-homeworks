package org.example;
import java.util.ArrayList;
import java.util.Arrays;

/* Задание 2. Написать простой класс Телефонный Справочник,
который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии. Следует учесть,
что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны. */

class PhoneBook
{
    String lastName;
    String phoneNumber;

    static ArrayList<String[]> phoneBookData = new ArrayList<>();

    public void phoneBook(String lastName, String phoneNumber)
    {
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void add()
    {
        String[] data = new String[2];
        data[0] = lastName;
        data[1] = phoneNumber;
        phoneBookData.add(data);
    }

    public static void get(String lastName)
    {
        for (String[] i : phoneBookData)
        {
            if (i[0] == lastName)
            {
                System.out.println(Arrays.toString(i));
            }
        }
    }
}

public class Lesson_5_2 { }
