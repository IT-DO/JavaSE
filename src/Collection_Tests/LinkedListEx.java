package Collection_Tests;

import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        Student st1 = new Student("Anton", 3);
        Student st2 = new Student("Natasha", 2);
        Student st3 = new Student("Lena", 1);
        Student st4 = new Student("Igor", 4);
        Student st5 = new Student("Sasha", 2);

        LinkedList<Student> studentlinkedList = new LinkedList<>();
        studentlinkedList.add(st1);
        studentlinkedList.add(st2);
        studentlinkedList.add(st3);
        studentlinkedList.add(st4);
        studentlinkedList.add(st5);

        System.out.println("LinkedList: " + studentlinkedList);


    }
}

class Student {
    String name;
    int course;

    public Student(String name, int age) {
        this.name = name;
        this.course = age;
    }

    @Override
    public String toString() {

        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + course +
                '}';
    }
}