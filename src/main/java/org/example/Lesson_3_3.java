package org.example;

import static org.example.Lesson_3_1.count;

public class Lesson_3_3 {
    public static void main(String[] args) {
        // Первая часть.

        System.out.println("Задание 1");
        System.out.println("Первая часть.");
        Dog dog1 = new Dog("Шарик");
        dog1.run(200);
        dog1.run(700);
        dog1.swim(5);
        dog1.swim(15);

        System.out.println();
        Cat cat1 = new Cat("Барсик");
        cat1.run(100);
        cat1.run(300);
        cat1.swim(50);

        System.out.println();
        count();

        // Вторая часть.
        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Барсик 1");
        catArray[1] = new Cat("Барсик 2");
        catArray[2] = new Cat("Барсик 3");
        catArray[3] = new Cat("Барсик 4");
        catArray[4] = new Cat("Барсик 5");

        System.out.println();
        System.out.println("Вторая часть.");
        Cat.food(100);
        System.out.println("В миске " + Cat.food + " единиц еды.");

        System.out.println();
        for (int i = 0; i < 5; i++) {
            catArray[i].feedingCat(30);
            System.out.println("Cытость " + catArray[i].name + ": " + Cat.Satiety);
            System.out.println("После " + catArray[i].name + " в миске осталось " + Cat.food + " единиц еды.");
        }

        System.out.println();
        System.out.println("В миску добавили еще 100 единииц еды");
        Cat.food(100);
        for (int i = 0; i < 5; i++) {
            catArray[i].feedingCat(20);
            System.out.println("Cытость " + catArray[i].name + ": " + Cat.Satiety);
            System.out.println("После " + catArray[i].name + " в миске осталось " + Cat.food + " единиц еды.");
        }

        // Задание 2.
        System.out.println();
        System.out.println("Задание 2");

        Geometry geometry1 = new Geometry();
        System.out.println("Круг");
        System.out.println("Периметр круга = " + geometry1.circlePerimeter(2));
        System.out.println("Площадь круга = " + geometry1.circlePerimeter(2));
        System.out.println("Цвет заливки = " + geometry1.fillColor("red"));
        System.out.println("Цвет границы = " + geometry1.borderColor("green"));

        System.out.println();
        System.out.println("Прямоугольник");
        System.out.println("Периметр прямоугольника = " + geometry1.rectanglePerimeter(2,3));
        System.out.println("Площадь прямоугольника = " + geometry1.rectangleArea(2,3));
        System.out.println("Цвет заливки = " + geometry1.fillColor("red"));
        System.out.println("Цвет границы = " + geometry1.borderColor("green"));

        System.out.println();
        System.out.println("Треугольник");
        System.out.println("Периметр треугольника = " + geometry1.trianglePerimeter(2,3,4));
        System.out.println("Площадь треугольника = " + geometry1.triangleArea(2,3));
        System.out.println("Цвет заливки = " + geometry1.fillColor("red"));
        System.out.println("Цвет границы = " + geometry1.borderColor("green"));
    }
}