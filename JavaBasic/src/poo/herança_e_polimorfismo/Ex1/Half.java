package poo.herança_e_polimorfismo.Ex1;

public class Half extends Ticket {

    public Half(float price) {
        super(price);
    }

    @Override
    public float getPrice() {
        return this.price/2;
    }
    
}
