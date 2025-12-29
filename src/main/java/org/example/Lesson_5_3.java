package org.example;
import java.util.*;
import static org.example.Lesson_5_1.graduateLessThenThree;
import static org.example.Lesson_5_1.nextCourse;
import static org.example.Lesson_5_1.studentsResult;
import static org.example.Lesson_5_1.printStudents;

import static org.example.PhoneBook.phoneBookData;
import org.example.Lesson_5_1.*;


public class Lesson_5_3
{
    public static void main(String[] args)
    {
        // Задание 1.
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();

        student1.studentData("Иван Иванов", "A-01", "1", "1", "2");
        student2.studentData("Петр Петров", "A-02", "2", "3", "4");
        student3.studentData("Сергей Сергеев", "Б-01", "3", "2", "3");
        student4.studentData("Василий Васильев", "Б-02", "4", "5", "4");

        Set<Student> students = new HashSet<>(Set.of());
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println("Список всех студентов в Set.");
        for (Student i : students)
        {
            System.out.println("Имя: " + i.name + " Группа: " + i.group + " Курс: " + i.course + " Оценка по русскому: " + i.gradesRussian + " Оценка по математике:" + i.gradesMath);
        }

        System.out.println();
        System.out.println("Список оставшихся студентов.");

        graduateLessThenThree(students);

        for (Student i : studentsResult)
        {
            System.out.println("Имя: " + i.name + " Группа: " + i.group + " Курс: " + i.course + " Оценка по русскому: " + i.gradesRussian + " Оценка по математике:" + i.gradesMath);
        }

        System.out.println();
        System.out.println("Перевод на следующий курс студентов, у которых осредний балл больше 3");

        nextCourse(students);

        for (Student i : studentsResult)
        {
            System.out.println("Имя: " + i.name + " Группа: " + i.group + " Курс: " + i.course + " Оценка по русскому: " + i.gradesRussian + " Оценка по математике:" + i.gradesMath);
        }

        System.out.println();
        System.out.println("На этом курсе учатся (после перевода на следующий курс): ");

        printStudents(students, 3);

        // Задание 2.

        PhoneBook contact1 = new PhoneBook();
        PhoneBook contact2 = new PhoneBook();
        PhoneBook contact3 = new PhoneBook();
        PhoneBook contact4 = new PhoneBook();

        contact1.phoneBook("+79999999999", "Иванов");
        contact2.phoneBook("+78888888888", "Иванов");
        contact3.phoneBook("+777777777777","Сергеев");
        contact4.phoneBook("+766666666666","Васильев");

        contact1.add();
        contact2.add();
        contact3.add();
        contact4.add();

        System.out.println();
        System.out.println("Список всех контактов в телефонной книге.");

        for (String phoneNumber : phoneBookData.keySet())
        {
            String key = phoneNumber;
            String value = phoneBookData.get(phoneNumber);
            System.out.println( value + " " + key);
        }

        System.out.println();
        System.out.println("Номера телефонов по запросу.");

        PhoneBook.get("Иванов");
    }
}
