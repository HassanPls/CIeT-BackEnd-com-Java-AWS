package poo.herança_e_polimorfismo.Aula1e2;

public class Aula1e2 {
    public static void main(String[] args) {
        printEmployee(new Manager());
        printEmployee(new Salesman());

    }

    public static void printEmployee(Employee employee) {

        switch (employee) {
            case Manager manager -> {
                employee.setCode("1");
                employee.setName("Pedro");
                employee.setSalary(5000);
                manager.setLogin("pedro");
                manager.setPassword("123");
                manager.setComission(1200);

                System.out.println(employee.getClass().getCanonicalName());
                System.out.println(employee.getCode());
                System.out.println(employee.getName());
                System.out.println(employee.getSalary());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
                System.out.println(manager.getComission());
                System.out.println(manager.getFullSalary(500));
            }
            case Salesman salesman -> {
                employee.setCode("2");
                employee.setName("Eduarda");
                employee.setSalary(2800);
                salesman.setPercentPerSold(10);
                salesman.setSoldAmount(1000);

                System.out.println(employee.getClass().getCanonicalName());
                System.out.println(employee.getCode());
                System.out.println(employee.getName());
                System.out.println(employee.getSalary());
                System.out.println(salesman.getPercentPerSold());
            }
        }
        System.out.println(employee.getFullSalary());
    }
}
