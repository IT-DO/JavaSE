package DesignPatterns.BuliderPattern.BuilderPatternManual;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProgrammerBuilder implements Builder{
    private String firstName;
    private String lastName;
    private int age;
    private List<String> hardSkills;
    private List<String> softSkills;
    @Override
    public Programmer createProgrammer() {
        return new Programmer(firstName, lastName, age, hardSkills, softSkills);
    }
}
