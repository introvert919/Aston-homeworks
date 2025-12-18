package org.example;

/* Задание 1
Первая часть.
1) Создать классы Собака и Кот с наследованием от класса Животное.
2) Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
3)Результатом выполнения действия будет печать в консоль.
(Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
4) У каждого животного есть ограничения на действия
(бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
5) Добавить подсчет созданных котов, собак и животных.

Вторая часть.
Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
1) Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
2)Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.
3)Считаем, что если коту мало еды в миске, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
4) Создать массив котов и миску с едой, попросить всех котов покушать из этой миски
и потом вывести информацию о сытости котов в консоль.
5)Добавить метод, с помощью которого можно было бы добавлять еду в миску*/

// Животные.
class Animals
{
    String name;
    static int countAnimals = 0;

    public Animals(String name)
    {
        this.name = name;
        countAnimals++;
    }

    public void run(int runValue)
    {
        System.out.println(name + " пробежал " + runValue + "м.");
    }

    public void swim(int swimValue)
    {
        System.out.println(name + " проплыл " + swimValue + "м.");
    }

}

// Собака.
class Dog extends Animals
{
    static int countDog = 0;

    public Dog(String name)
    {
        super(name);
        countDog++;
    }

    // Для ограничений используем перегрузку методов.
    public void run(int runValue)
    {
        if(runValue <= 500)
        {
            System.out.println(super.name + " пробежал " + runValue + "м.");
        }
        else
        {
            System.out.println(super.name + " может пробежать только до 500м.");
        }
    }

    public void swim(int swimValue)
    {
        if(swimValue <= 10)
        {
            System.out.println(super.name + " проплыл " + swimValue + "м.");
        }
        else
        {
            System.out.println(super.name + " может проплыть только до 10м.");
        }
    }
}

// Кот.
class Cat extends Animals
{
    static int countCat = 0;
    static int food = 0;
    static boolean Satiety;

    public Cat(String name)
    {
        super(name);
        countCat++;
    }

    // Для ограничений используем перегрузку методов.
    public void run(int runValue)
    {
        if(runValue <= 200)
        {
            System.out.println(super.name + " пробежал " + runValue + "м.");
        }
        else
        {
            System.out.println(super.name + " может пробежать только до 200м.");
        }
    }

    public void swim(int c)
    {
        System.out.println(super.name + " не умеет плавать.");
    }

    // Вторая часть.
    // Добавление еды в миску.
    public static void food(int foodValue)
    {
        Cat.food += foodValue; // Чтобы к оставшейся еде можно было добавить новую.
    }

    // Кормление котов.
    public void feedingCat(int feedingCatValue)
    {
        if(Cat.food >= feedingCatValue)
        {
            Cat.food -= feedingCatValue;
            Cat.Satiety = true;
        }
        else
        {
            Cat.Satiety = false;
        }
    }
}

public class Lesson_3_1
{
    // Подсчет созданных животных.
    public static void count()
    {
        System.out.println("Всего животных: " + Animals.countAnimals);
        System.out.println("Всего собак : " + Dog.countDog);
        System.out.println("Всего котов : " + Cat.countCat);
    }
}
