package pl.academy.infoshare.sample1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

class SomeObject {

    private final String someField;

    SomeObject(String someField) {
        this.someField = someField;
    }
}

public class DebugApp1 {

    private static SomeObject someObject = new SomeObject("A0");
    private static SomeObject[] someObjectsArray = {
        new SomeObject("A1"),
        new SomeObject("B1"),
        new SomeObject("C1"),
        new SomeObject("D1")
    };
    private static List<SomeObject> someObjectsList = new ArrayList<>(Arrays.asList(
        new SomeObject("A2"),
        new SomeObject("B2"),
        new SomeObject("C2"),
        new SomeObject("D2")
    ));

    public enum Skill {
        DEBUG
    }

    public static void main(final String[] args) throws InterruptedException {

        System.out.println("Hello infoShare <academy/>!");

        List<String> debugElements =
            of("Breakpoint", "Console", "Debugger", "Dump", "Debug toolbar", "Stepping toolbar")
                .collect(toList());

        System.out.println("Debugging basics: " + debugElements);

        learnSkill(getCurrentDate(), getSkill());
    }

    private static LocalDate getCurrentDate() {
        final LocalDate currentDate = LocalDate.now();
        return currentDate;
    }

    private static Skill getSkill() {
        String skillString = getSkillString();
        Skill debugSkill = Skill.valueOf(skillString);
        return debugSkill;
    }

    private static String getSkillString() {
        return "DEBUG";
    }

    private static void learnSkill(final LocalDate date, final Skill skill) {
        System.out.println(date + " we will learn how to " + skill);
    }
}