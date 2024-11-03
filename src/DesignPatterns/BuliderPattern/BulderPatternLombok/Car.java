package DesignPatterns.BuliderPattern.BulderPatternLombok;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Car {
    private String model;
    private int horsepower;

}
