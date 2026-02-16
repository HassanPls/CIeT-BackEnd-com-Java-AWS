package poo.classe_e_encapsulamento.Ex1;

public class Bank {
    private int balance;
    private final int overdraft;
    private int payment;


    public Bank(int balance) {
        this.balance = balance;
        if (balance <= 500) {
            this.overdraft = 50;
        } else {
            this.overdraft = balance/2;
        }
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }

    public boolean isUsingOverdraft() {
        if (this.balance <= 0 && this.payment > 0) {
            warningOverdraft();
            return true;
        }
        return false;
    }

    public void warningOverdraft() {
        if (this.balance <= 0 && this.payment > 0) {
            float percent =(float) this.payment/this.overdraft;
            if (percent >= 0.2) {
                System.out.println("Você está usando o cheque especial");
            } else {
                System.out.println("Você não está usando o cheque especial");
            }
        } else {
            System.out.println("Você não está usando o cheque especial");
        }
    }

    
}
