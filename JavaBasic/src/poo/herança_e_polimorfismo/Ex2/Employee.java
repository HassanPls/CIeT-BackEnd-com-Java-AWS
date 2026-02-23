package poo.herança_e_polimorfismo.Ex2;

public class Employee {
    protected String name;
    protected String email;
    protected String password;
    protected boolean isAdm;

    public Employee(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAdm() {
        return isAdm;
    }

    public void logIn() {
        System.out.println("Logado com sucesso!");
        return;
    }

    public void logOut() {
        System.out.println("Deslogado com sucesso!");
        return;
    }

    public void changeInfo(String email, String name) {
        setEmail(email);
        setName(name);
        System.out.println("Informações alteradas com sucesso");
        return;
    }

    public void changePassword(String newPassword) {
        setPassword(newPassword);
        System.out.println("Senha alterada com sucesso!");
        return;
    }
}
