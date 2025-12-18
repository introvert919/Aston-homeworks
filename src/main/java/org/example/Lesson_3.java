package org.example;

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
        if(swimValue <= 500)
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

    // Добавление еды в миску.
    public static void food(int foodValue)
    {
        Cat.food += foodValue;
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

public class Lesson_3
{
// Подсчет созданных животных.
    public static void count()
    {
        System.out.println("Всего животных: " + Animals.countAnimals);
        System.out.println("Всего собак : " + Dog.countDog);
        System.out.println("Всего котов : " + Cat.countCat);

    }

    public static void main(String[] args)
    {
        // Первая часть.
        /*Dog dog1 = new Dog("Шарик");
        dog1.swim(600);
        Cat cat1 = new Cat("Барсик");
        cat1.swim(300);
        count();*/

        // Вторая часть.
        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Барсик 1");
        catArray[1] = new Cat ("Барсик 2");
        catArray[2] = new Cat("Барсик 3");
        catArray[3] = new Cat ("Барсик 4");
        catArray[4] = new Cat("Барсик 5");

        Cat.food(100);
        //System.out.println("В миске " + Cat.food + " единиц еды.");

        for(int i = 0; i < 5; i++)
        {
            catArray[i].feedingCat(30);
            System.out.println("Cытость " + catArray[i].name + ": " + Cat.Satiety);
            //System.out.println("После " + catArray[i].name + " в миске осталось " + Cat.food + " единиц еды.");
        }








    }
}
