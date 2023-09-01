package B_B50_PersonSimple;

import java.time.LocalDate;

public class PersonSimple {

    private final String name;
    private final int age;
    private final LocalDate dob;

    PersonSimple(String name, int age) {
        this(name, age, null);
    }

    PersonSimple(String name, int age, LocalDate dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public LocalDate getDob() {return this.dob;}

    public String getSummary() {
        return this.name + " is " + this.age + " years old";
    }
}
