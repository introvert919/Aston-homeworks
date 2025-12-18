package org.example;

/*Задание 3. Создать класс Park с внутренним классом,
с помощью объектов которого можно хранить информацию
об аттракционах, времени их работы и стоимости. */

class Park
{
    public class Attractions
    {
        private String name;
        private String workingHours;
        private int price;

        public Attractions(String name, String workingHours, int price)
        {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public void ConsoleOutAttractions()
        {
            System.out.println("Название: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price);
        }
    }
}

public class Lesson_2_2 { }
