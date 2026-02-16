package poo.herança_e_polimorfismo.Ex2;

public class Attendant extends Employee {

    private float cashValue;

    public Attendant(String name, String email, String password, float cashValue) {
        super(name, email, password);
        this.isAdm = false;
        this.cashValue = cashValue;
    }

    public void receivePayment(float payment) {
        this.cashValue += payment;
        System.out.println("Pagamento contado!");
        return;
    }
    
    public void closeCasher() {
        System.out.println("Caixa fechado com sucesso!");
    }

    public float getCashValue() {
        return cashValue;
    }
}
