package DesignPatterns.BuliderPattern.BuilderPatternManual;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Programmer {
    private String firstName;
    private String lastName;
    private int age;
    private List<String> hardSkills;
    private List<String> softSkills;


}
