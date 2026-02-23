package poo.herança_e_polimorfismo.Ex1;

public class Family extends Ticket {

    private int countPeople;

    public Family(float price, int countPeople) {
        super(price);
        this.countPeople = countPeople;
    }
    
    @Override 
    public float getPrice() {
        float price = this.price * this.countPeople;
        if (this.countPeople > 3) {
            price = price * 0.95f;
        }
        return price;
    }
}
