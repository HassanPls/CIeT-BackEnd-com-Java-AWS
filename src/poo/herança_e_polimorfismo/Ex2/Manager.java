package poo.herança_e_polimorfismo.Ex2;

public class Manager extends Employee {

    public Manager(String name, String email, String password) {
        super(name, email, password);
        this.isAdm = true;
    }
    
    public void financialReport(Attendant attendant, Salesperson salesperson) {
        float profit = attendant.getCashValue() * salesperson.getCountSales();
        System.out.println("O lucro total foi de R$ " + profit);
    }

    public void countedSales(Salesperson salesperson) {
        System.out.println("O número de vendas foi " + salesperson.getCountSales());
    }
}
