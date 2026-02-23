package poo.classe_e_encapsulamento.Aula1;

import java.time.OffsetDateTime;

public class Person {
    private final String name;
    private int age;
    private int lastYearAgeInc = OffsetDateTime.now().getYear();
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void incAge() {
        if (this.lastYearAgeInc > OffsetDateTime.now().getYear()) return;

        this.age += 1;
        this.lastYearAgeInc = OffsetDateTime.now().getYear();
    }
}
