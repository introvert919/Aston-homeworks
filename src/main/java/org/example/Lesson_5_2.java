package org.example;
import java.util.HashMap;
import java.util.Map;

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

    static Map<String, String> phoneBookData = new HashMap<>();

    public void phoneBook(String phoneNumber, String lastName)
    {
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
    }

    public void add()
    {
        phoneBookData.put(phoneNumber,lastName);
    }

    public static void get(String lastNameToFind)
    {
        for (String phoneNumber : phoneBookData.keySet())
        {
            if (phoneBookData.get(phoneNumber).equals(lastNameToFind))
            {
                String key = phoneNumber;
                String value = phoneBookData.get(phoneNumber);
                System.out.println(value + " " + key);
            }
        }
    }
}


