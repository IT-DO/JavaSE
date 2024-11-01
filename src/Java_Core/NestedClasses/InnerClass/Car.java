package Java_Core.NestedClasses.InnerClass;

public class Car {
    String ceolor;
    int doorCount;
    Engine engine;

    public Car(String ceolor, int doorCount, int horsepower) {
        this.ceolor = ceolor;
        this.doorCount = doorCount;
        this.engine = this.new Engine(horsepower); // - создаем объект внутреннего класса Engine внутри конструктора
    }

    @Override
    public String toString() {
        return "Car{" +
                "ceolor='" + ceolor + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public class Engine{
        int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsepower=" + horsepower +
                    '}';
        }
    }
}
class Test{
    public static void main(String[] args) {
// creating Engine for static Engine        Car.Engine engine = new Car.Engine(140);
        Car car = new Car("Black", 4,300);
        System.out.println(car);
    }
}