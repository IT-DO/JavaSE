package DesignPatterns.BuliderPattern.BuilderPatternManual;

import java.util.List;

public interface Builder {
    void setFirstName(String firstName);
    void setLastName(String setLastName);
    void setAge(int age);
    void setHardSkills(List<String> hardSkills);
    void setSoftSkills(List<String> softSkills);
    Programmer createProgrammer ();
}
