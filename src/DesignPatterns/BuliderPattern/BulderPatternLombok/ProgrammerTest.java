package DesignPatterns.BuliderPattern.BulderPatternLombok;

public class ProgrammerTest {
    public static void main(String[] args) {
        Programmer programmer = Programmer.builder()
                .firstName("Anton")
                .lastName("Kurischev")
                .age(34)
                .build();
        System.out.println(programmer);
    }
}
