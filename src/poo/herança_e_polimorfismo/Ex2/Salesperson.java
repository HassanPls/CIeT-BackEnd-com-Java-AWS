package poo.herança_e_polimorfismo.Ex2;

public class Salesperson extends Employee {

    private int countSales;

    public Salesperson(String name, String email, String password, int countSales) {
        super(name, email, password);
        this.isAdm = false;
        this.countSales = countSales;
    }

    public void addSale() {
        this.countSales++;
        System.out.println("Venda contada!");
        return;
    }

    public void getSales() {
        System.out.println("Foram vendidos " + this.countSales + " unidades!");
        return;
    }

    public int getCountSales() {
        return countSales;
    }
    
}
