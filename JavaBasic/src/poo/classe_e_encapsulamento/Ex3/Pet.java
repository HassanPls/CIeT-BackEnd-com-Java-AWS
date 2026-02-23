package poo.classe_e_encapsulamento.Ex3;

public class Pet {
    private final String name;
    private boolean clean;
    
    public Pet(String name, boolean clean) {
        this.name = name;
        this.clean = clean;
    }

    public String getName() {
        return name;
    }
    public boolean isClean() {
        return clean;
    }
    public void setClean(boolean clean) {
        this.clean = clean;
    }
}