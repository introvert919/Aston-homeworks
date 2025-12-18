package org.example;

/* Задание 1. Создать класс "Товар" с полями:
название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.*/

class Product
{
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

public class Lesson_2_1 { }