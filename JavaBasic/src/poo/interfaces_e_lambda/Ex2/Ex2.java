package poo.interfaces_e_lambda.Ex2;

import java.util.Scanner;

public class Ex2 {
    /* Escreva um código que calcule o valor de tributos de produtos, os produtos disponíveis devem ser dos seguintes tipos: Alimentação, Saude e bem estar, Vestuário e Cultura. Todos os produtos devem ter um método para retornar o seu valor de imposto, de acordo com seu tipo:

    Alimentação 1%;
    Saude e bem estar 1.5%;
    Vestuário 2.5%;
    Cultura 4%. */
    private static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int option = -1;

        do {

            System.out.println("Escolha o tipo de produto");
            System.out.println("0 - sair");
            System.out.println("1 - Saude e bem estar");
            System.out.println("2 - Alimentação");
            System.out.println("3 - Vestuário");
            System.out.println("4 - Cultura");

            option = Sc.nextInt();
            
            System.out.println("Qual o preço do produto ");
            double price = Sc.nextDouble();

            switch (option) {
                case 1 -> getTributeHealth(price);
                case 2 -> getTributeFood(price);
                case 3 -> getTributeClothing(price);
                case 4 -> getTributeCulture(price);
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);

        Sc.close();
    
    }

    public static void getTributeHealth(double price) {
        Health healthProduct = new Health(price);
        System.out.println("A quantidade de tributo é R$ " + healthProduct.getTribute());
    }
    public static void getTributeFood(double price) {
        Food foodProduct = new Food(price);
        System.out.println("A quantidade de tributo é R$ " + foodProduct.getTribute());
    }
    public static void getTributeClothing(double price) {
        Clothing clothingProduct = new Clothing(price);
        System.out.println("A quantidade de tributo é R$ " + clothingProduct.getTribute());
    }
    public static void getTributeCulture(double price) {
        Culture cultureProduct = new Culture(price);
        System.out.println("A quantidade de tributo é R$ " + cultureProduct.getTribute());
    }

}
