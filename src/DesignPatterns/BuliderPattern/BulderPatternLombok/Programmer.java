package DesignPatterns.BuliderPattern.BulderPatternLombok;

import lombok.Builder;
import lombok.ToString;

import java.util.List;
@Builder
@ToString
public class Programmer {
    private String firstName;
    private String lastName;
    private int age;
    private List<String> hardSkills;
    private List<String> softSkills;


}
