package Java_Core.NestedClasses.staticNestedClass;

public class Car {
    String ceolor;
    int doorCount;
    Engine engine;

    public Car(String ceolor, int doorCount, Engine engine) {
        this.ceolor = ceolor;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ceolor='" + ceolor + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public static class Engine{
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
        Car.Engine engine = new Car.Engine(140);
        System.out.println(engine);
        Car car = new Car("red",5,engine);
        System.out.println(car);
    }
}