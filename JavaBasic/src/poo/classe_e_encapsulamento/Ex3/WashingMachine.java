package poo.classe_e_encapsulamento.Ex3;

public class WashingMachine {
    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet = null;

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public void setShampoo(int shampoo) {
        this.shampoo = shampoo;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina está suja! Limpe ela.");
            return;
        }
        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " está na máquina neste momento");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
    }

    public void removePet() {
        if (!hasPet()) {
            System.out.println("Não há pet para ser removido!");
        }

        this.clean = this.pet.isClean();
        this.pet = null;
        System.out.println("O pet foi removido");
    }

    public void takeShower() {
        if (this.pet == null) {
            System.out.println("Não há pet na máquina. Coloque um.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + "está limpo");
    }

    public void addWater() {
        if (this.water >= 30) {
            System.out.println("A capacidade de água da máquina está no máximo");
        }

        this.water += 2;
        System.out.println("Dois litros de água adicionado");
    }

    public void addShampoo() {
        if (this.water >= 10) {
            System.out.println("A capacidade de shampoo da máquina está no máximo");
        }

        this.shampoo += 2;
        System.out.println("Dois litros de shampoo adicionado");
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void wash() {
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina está limpa");
    }

    
}
