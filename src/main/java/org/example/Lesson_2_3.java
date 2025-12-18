package org.example;

public class Lesson_2_3
{
    public static void main(String[] args)
    {
        // Задание 1.
        System.out.println("Задание 1");
        Product product1 = new Product("Компьютер", "09.12.2025",
                "Компьютерная компания", "Россия", 20000, "Да");
        product1.ConsoleOut();
        System.out.println();

        /*Задание 2. Создать массив из 5 товаров.
        Пример:
        1. Вначале объявляем массив объектов.
        Product[] productsArray = new Product[5];
        2. Потом для каждой ячейки массива задаем объект.
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product(...);
        ...
        productsArray[4] = new Product(...);*/

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Компьютер", "09.12.2025",
                "Компьютерная компания", "Россия", 20000, "Да");
        productsArray[1] = new Product("Телефон", "09.12.2025",
                "Телефонная компания", "Россия", 10000, "Нет");
        productsArray[2] = new Product("Планшет", "09.12.2025",
                "Планшетная компания", "Россия", 15000, "Нет");
        productsArray[3] = new Product("Наушники", "09.12.2025",
                "Компания наушников", "Россия", 1000, "Нет");
        productsArray[4] = new Product("Роутер", "09.12.2025",
                "Компания роутеров", "Россия", 5000, "Нет");

        System.out.println("Задание 2");
        for (int i = 0; i < 5; i++) {
            productsArray[i].ConsoleOut();
            System.out.println();
        }

        // Задание 3.
        System.out.println("Задание 3");
        Park.Attractions atraction1 = new Park().new Attractions("Орбита", "Пн-Пт 9:00 - 18:00", 300);
        atraction1.ConsoleOutAttractions();
    }
}
