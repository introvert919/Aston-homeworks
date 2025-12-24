package org.example;
import java.util.HashSet;
import java.util.Set;

/* Задание 1. Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
Создайте коллекцию, содержащую объекты класса Student.
Следует написать метод, который удаляет студентов со средним баллом < 3,
а также отдельный метод, который переводит студента на следующий курс,
если средний балл >= 3. Напишите метод printStudents(Set<Student> students, int course),
который получает список студентов и номер курса. Метод печатает на консоль имена тех студентов,
которые обучаются на данном курсе. */

class Student
{
    String name;
    String group;
    String course;
    String gradesRussian;
    String gradesMath;

    public void studentData(String name, String group, String course,String gradesRussian, String gradesMath)
    {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradesRussian = gradesRussian;
        this.gradesMath = gradesMath;
    }
}

public class Lesson_5_1
{
    static Set<Student> studentsResult = new HashSet<>(Set.of());

    // Удаление студентов из списка со средним баллом меньше 3.
    public static void graduateLessThenThree(Set<Student> students)
    {
        studentsResult.clear();
        for (Student i : students)
        {
            if ((Integer.parseInt(i.gradesRussian) + Integer.parseInt(i.gradesMath))/2 >= 3)
            {
                studentsResult.add(i); // По ходу итерации преобразовывать элементы нельзя, поэтому перезаписываем в другой лист.
            }
        }
    }

    // Перевод студентов на следующий курс.
    public static void nextCourse(Set<Student> students)
    {
        studentsResult.clear();
        for (Student i : students)
        {
            if ((Integer.parseInt(i.gradesRussian) + Integer.parseInt(i.gradesMath))/2 >= 3)
            {
                i.course = Integer.toString(Integer.parseInt(i.course) + 1);
            }
            studentsResult.add(i);
        }
    }

    // Вывод студентов одного курса.
    public static void printStudents(Set<Student> students, int course)
    {
        for (Student i : students)
        {
            if (Integer.parseInt(i.course) == course)
            {
                System.out.println(i.name);
            }
        }
    }
}
