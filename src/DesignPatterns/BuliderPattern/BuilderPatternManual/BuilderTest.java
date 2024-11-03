package DesignPatterns.BuliderPattern.BuilderPatternManual;

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new ProgrammerBuilder();
        Director director = new Director();
        builder = director.createJunior(builder);
        builder.setFirstName("Anton");
        System.out.println(builder.createProgrammer());
    }
}
