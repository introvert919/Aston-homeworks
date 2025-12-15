package org.example;

/* Задание 1. Создать класс "Товар" с полями:
название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.*/

class Product {
    private String productName;
    private String productionDate;
    private String manufacturer;
    private String countryManufacturer;
    private int price;
    private String booking;

    public Product(String productName, String productionDate, String manufacturer,
                   String countryManufacturer, int price, String booking)
    {
        this.productName = productName;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryManufacturer = countryManufacturer;
        this.price = price;
        this.booking = booking;
    }

    public void ConsoleOut()
    {
        System.out.println("Название: " + productName);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна производства: " + countryManufacturer);
        System.out.println("Цена: " + price);
        System.out.println("Зарезервировано: " + booking);
    }
}

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

public class Lesson_2
{
    public static void main(String[] args)
    {
        // Задание 1.
         Product product1 = new Product("Компьютер", "09.12.2025",
         "Компьютерная компания", "Россия", 20000, "Да");
         product1.ConsoleOut();

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

        for(int i = 0; i < 5; i++)
        {
            productsArray[i].ConsoleOut();
            System.out.println();
        }

        // Задание 3.

        Park.Attractions atraction1 = new Park().new Attractions("Орбита", "Пн-Пт 9:00 - 18:00", 300);
        atraction1.ConsoleOutAttractions();
    }
}