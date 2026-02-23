package poo.classe_e_encapsulamento.Aula2;

public record Person(String name, int age) {

    public Person {
        //verificar valores
    }

    public Person(String name) {
        this(name, 1);
    }

    public String getInfo() {
        return "Name: " + name + " age: " + age;
    }
}
