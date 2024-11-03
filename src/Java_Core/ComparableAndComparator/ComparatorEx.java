package Java_Core.ComparableAndComparator;

import java.util.LinkedList;

import static java.util.Collections.*;

public class ComparatorEx {
    public static void main(String[] args) {
        CarComparable carComparable1 = new CarComparable(7,"Volksvagen Polo", "sedan", 132);
        CarComparable carComparable2 = new CarComparable(12,"Skoda Rapid", "sedan", 105);
        CarComparable carComparable3 = new CarComparable(3,"Lada Vesta", "sedan", 99);
        CarComparable carComparable4 = new CarComparable(32,"Audi A6", "universal", 245);
        CarComparable carComparable5 = new CarComparable(5,"Cherry Tiggo 4 Pro", "crossover", 145);
        CarComparable carComparable6 = new CarComparable(6,"Volksvagen Tuareg", "crossover", 210);
        CarComparable carComparable7 = new CarComparable(1,"Renault Clio", "hatchback", 87);

        LinkedList<CarComparable> carsList = new LinkedList<>();

        carsList.add(carComparable1);
        carsList.add(carComparable2);
        carsList.add(carComparable3);
        carsList.add(carComparable4);
        carsList.add(carComparable5);
        carsList.add(carComparable6);
        carsList.add(carComparable7);


        System.out.println("Коллекция до сортировки по мощности c использованием класса Comparator: ");
        System.out.println(carsList);

        sort(carsList, new PowerComparatorEx());

        System.out.println("Коллекция после сортировки по мощности: ");
        System.out.println(carsList);


        System.out.println("Коллекция до сортировки по ID с использованием интерфейса Comparable: ");
        System.out.println(carsList);


        System.out.println("Коллекция после сортировки: ");
        System.out.println(carsList);


        System.out.println("Коллекция до сортировки по модели: ");
        System.out.println(carsList);

        sort(carsList, new ModelComparatorEx());

        System.out.println("Коллекция после сортировки по модели: ");
        System.out.println(carsList);

    }
}

class Car implements Comparable<CarComparable>{
    int id;
    String model;
    String type;
    int power;

    public Car(int id, String model, String type, int power) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.power = power;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", Модель = '" + model + '\'' +
                ", Тип ='" + type + '\'' +
                ", Мощность =" + power + "л.с";

    }

    @Override
    public int compareTo(CarComparable o) {    // Сортировка объекта по id с использованием интерфейса Comparable
        if(this.id == o.id) return 0;
        return this.id<o.id ? -1:1;
    }
}

//Comparator clssses
class IdComparator implements java.util.Comparator<CarComparable> {
    @Override
    public int compare(CarComparable carComparable1, CarComparable carComparable2) {
        if (carComparable1.id == carComparable2.id) return 0;
        return carComparable1.id < carComparable2.id ? -1 : 1;
    }
} // Объект компаратор для сортировки по полю id

class ModelComparator implements java.util.Comparator<CarComparable> {
    @Override
    public int compare(CarComparable carComparable1, CarComparable carComparable2) {
        return carComparable1.model.compareTo(carComparable2.model);
    }
}  // Объект компаратор для сортировки по полю Model

class TypeComparator implements java.util.Comparator<CarComparable> {
    @Override
    public int compare(CarComparable o1, CarComparable o2) {
        return o1.type.compareTo(o2.type);
    }
}   // Объект компаратор для сортировки по полю Type

class PowerComparator implements java.util.Comparator<CarComparable> {
    @Override
    public int compare(CarComparable o1, CarComparable o2) {
        if (o1.power == o2.power) return 0;
        return o1.power < o2.power ? 1 : -1;
    }
}  // Объект компаратор для сортировки по полю Power
