package DesignPatterns.BuliderPattern.BulderPatternLombok;

public class CarTest {
    public static void main(String[] args) {
        Car car = Car.builder()
                .model("Volksvagen Polo")
                .horsepower(140)
                .build();
        System.out.println(car);
        System.out.println(car.getModel());
        System.out.println(car.getHorsepower());
        Car car1 = Car.builder()
                .model("Audi A6")
                .horsepower(249)
                .build();

        System.out.println(car1);
        System.out.println(car1.getModel());
        System.out.println(car1.getHorsepower());
    }


}
