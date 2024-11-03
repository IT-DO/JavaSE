package DesignPatterns.BuliderPattern.BuilderPatternManual;

import java.util.ArrayList;
import java.util.List;

public class Director {
    public Builder createJunior (Builder builder){
        List<String> hardSkills = new ArrayList<>();
        hardSkills.add("Java Core");
        hardSkills.add("Windows OS");
        hardSkills.add("Notepad++");
        builder.setHardSkills(hardSkills);
        List<String> softSkills = new ArrayList<>();
        softSkills.add("Вежливый");
        softSkills.add("Любознательный");
        softSkills.add("Коммуникабельный");
        builder.setHardSkills(softSkills);
        return builder;
    }
    public Builder createMiddle (Builder builder){
        List<String> hardSkills = new ArrayList<>();
        hardSkills.add("Java EE");
        hardSkills.add("OS Linux");
        hardSkills.add("Spring");
        builder.setHardSkills(hardSkills);
        List<String> softSkills = new ArrayList<>();
        softSkills.add("Спокойный");
        softSkills.add("Рассудительный");
        softSkills.add("Коммуникабельный");
        builder.setHardSkills(softSkills);
        return builder;
    }
    public Builder createSenior (Builder builder){
        List<String> hardSkills = new ArrayList<>();
        hardSkills.add("Micro Service");
        hardSkills.add("Kafka");
        hardSkills.add("Oracle");
        builder.setHardSkills(hardSkills);
        List<String> softSkills = new ArrayList<>();
        softSkills.add("Ресурсный");
        softSkills.add("Эрудированный");
        softSkills.add("Психически устойчивый");
        builder.setHardSkills(softSkills);
        return builder;
    }

}
