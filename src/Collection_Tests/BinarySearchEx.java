package Collection_Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchEx {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(-2);
        arrayList.add(12);
        arrayList.add(8);
        arrayList.add(2234);
        arrayList.add(543);
        arrayList.add(-122);
        arrayList.add(1223);
        arrayList.add(5);
        arrayList.add(9);
        arrayList.add(14);

        System.out.println(arrayList);
        //sorting arrayList
        Collections.sort(arrayList);
        //sorted arrayList
        System.out.println(arrayList);

        //reverse sorted arrayList
        Collections.reverse(arrayList);
        //reversed arrayList
        System.out.println(arrayList);
        //shuffle(mix) arraylist
        Collections.shuffle(arrayList);
        //shuffled (mixeD) arraylist
        System.out.println(arrayList);

        //binarySearch in collection
        int indexElement = Collections.binarySearch(arrayList, 200);
        System.out.println(indexElement);
        Employee emp1 = new Employee(1, "Petr", 15000);
        Employee emp2 = new Employee(3, "Serg", 50000);
        Employee emp3 = new Employee(9, "Oleg", 23211);
        Employee emp4 = new Employee(29, "Alena", 75000);
        Employee emp5 = new Employee(3, "Anton", 90000);
        Employee emp6 = new Employee(15, "Igor", 45000);
        Employee emp7 = new Employee(18, "Nikolay", 30000);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);

        System.out.println(employeeList);
        System.out.println();
        Collections.sort(employeeList);
        System.out.println(employeeList);
        int index3 = Collections.binarySearch(employeeList, new Employee(29, "Alena", 0));
        System.out.println(index3);

        //Arrays.sort() / Arrays.binarysearch(index) /
        int[] array = {-3, 2, -12, 12, 33, 45, 321, 123};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int index4 = Arrays.binarySearch(array,-3);
        System.out.println(index4);
    }
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "\n" + "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        //сравниваем только по полю ID
//        if (this.id == anotherEmp.id){ return 0;
//        return this.id < anotherEmp.id ? -1 : 1;

        //сравним по ID и по name
        int result = this.id - anotherEmp.id;
        if (result == 0) {
            result = this.name.compareTo(anotherEmp.name);
        }
        return result;
    }


}