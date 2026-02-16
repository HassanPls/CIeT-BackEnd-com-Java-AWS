package poo.herança_e_polimorfismo.Ex1;

public class Ticket {
    protected float price;
    
    public Ticket(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
