package poo.classe_e_encapsulamento.Ex1;

import java.util.Scanner;

public class Ex1 {

    /* 
    Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
    Consultar saldo
    consultar cheque especial
    Depositar dinheiro;
    Sacar dinheiro;
    Pagar um boleto.
    Verificar se a conta está usando cheque especial.
    Siga as seguintes regras para implementar

    A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
    O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
    Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
    Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
    Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
    */
   
    private static Scanner Sc = new Scanner(System.in);
    private static Bank bank = new Bank(0);
    public static void main(String[] args) {
        int option = -1;

        do {
            System.out.println("Escolha uma opção");
            System.out.println("0 - sair");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6 - Verificar se a conta está usando cheque especial");

            option = Sc.nextInt();

            switch (option) {
                case 1 -> showBalance();
                case 2 -> showOverdraft();
                case 3 -> depositMoney();
                case 4 -> withdrawMoney();
                case 5 -> payTicket();
                case 6 -> warning();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);

        Sc.close();
    }

    private static void warning() {
        bank.warningOverdraft();
    }

    private static void payTicket() {
        int value = 0;
        do {
            System.out.println("Digite um valor menor que R$ " + (bank.getBalance() + bank.getOverdraft()) + " para pagar: ");
            value = Sc.nextInt();
        } while (value > (bank.getBalance() + bank.getOverdraft()));

        bank.setPayment(value - bank.getBalance());
        bank.setBalance(bank.getBalance() - value);
        if (bank.getBalance() < 0) {
            bank.setBalance(0);
        }

        if (bank.getPayment() > 0) {
            warning();
        }

    }

    private static void depositMoney() {
        int value = 0;
        do {
            System.out.println("Digite um valor maior que zero para depositar: ");
            value = Sc.nextInt();
        } while (value <= 0);

        int balance = bank.getBalance();
        bank.setBalance(balance + value);
    }

    private static void withdrawMoney() {
        int value = 0;
        do {
            System.out.println("Digite um valor menor que R$ " + bank.getBalance() + " para sacar: ");
            value = Sc.nextInt();
        } while (value > bank.getBalance());

        int balance = bank.getBalance();
        bank.setBalance(balance - value);
    }

    private static void showOverdraft() {
        int value = bank.getOverdraft();
        System.out.println("O cheque especial tem um valor de R$ " + value);
    }
    private static void showBalance() {
        int value = bank.getBalance();
        System.out.println("O saldo no banco é R$ " + value);
    }
}
