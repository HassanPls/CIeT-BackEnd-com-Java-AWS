package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Ex3 {
    //Escreva um código que o usuário entre com um primeiro número, um segundo número maior que o primeiro e escolhe entre a opção par e impar, com isso o código deve informar todos os números pares ou ímpares (de acordo com a seleção inicial) no intervalo de números informados, incluindo os números informados e em ordem decrescente;
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Escreva o primeiro número: ");
        int num1 = Sc.nextInt();
        int num2 = 0;
        do {
            System.out.println("Escreva um número maior que o primeiro: ");
            num2 = Sc.nextInt();
        } while (num2 <= num1);

        String option = "";
        do {
            System.out.println("Par ou Impar?");
            option = Sc.next();
        } while (!option.equalsIgnoreCase("par") && !option.equalsIgnoreCase("impar"));

        for (int i = num1; i <= num2; i++) {
            if (option.equalsIgnoreCase("par") && (i % 2 == 0)) {
                System.out.println(i);
            } else if (option.equalsIgnoreCase("impar") && (i % 2 != 0)) {
                System.out.println(i);
            }
        }
        Sc.close();
    }
}
