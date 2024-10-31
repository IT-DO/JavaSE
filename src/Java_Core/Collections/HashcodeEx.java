package Java_Core.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//public class HashcodeEx {
//    public static void main(String[] args) {
//        Map<Student, Double> studentmap = new HashMap<>();
//        Student st1 = new Student("Anton", "Kurischev", 3);
//        Student st2 = new Student("Petr", "Ivanov", 4);
//        Student st3 = new Student("Anton", "Kurischev", 3);
//        Student st4 = new Student("Anna", "Shashukova", 1);
//
//        studentmap.put(st1, 9.6);
//        studentmap.put(st2, 9.0);
//        studentmap.put(st3, 8.1);
//        studentmap.put(st4, 9.1);
//
//        int h1 = studentmap.get(st1).hashCode();
//        int h2 = studentmap.get(st2).hashCode();
//        int h3 = studentmap.get(st3).hashCode();
//        boolean isHashcodeEquals = h1 == h3; // хешкоды равны при переопределенных equals и hashcode в Students
//        System.out.println(h1);
//        System.out.println(h2);
//        System.out.println(h3);
//        System.out.println(isHashcodeEquals);
//        //При переопределении equals() - переопредели и hashcode!!!
//        //в примитивах и String equals и hashcode уже имеют хорошую реализацию.
//        //При неравенстве по equals неравенство по hashcode не обязательно т.к. hashcode возвращает int(-2 147 ... ... до 2 147 ... ...)
//
//    }
//}

//class Student1 {
//    String name;
//    String surname;
//    int course;
//
//    public Student1(String name, String surname, int course) {
//        this.name = name;
//        this.surname = surname;
//        this.course = course;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", course=" + course +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, course);
//    }
//}
