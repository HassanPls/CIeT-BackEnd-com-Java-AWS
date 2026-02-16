package sintaxe_basica.fundamentos_basicos;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        //Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas
        Scanner Sc = new Scanner(System.in);
        System.out.println("Escreva o nome da primeira pessoa: ");
        String name1 = Sc.next();
        System.out.println("Escreva a idade da primeira pessoa: ");
        int age1 = Sc.nextInt();
        System.out.println("Escreva o nome da segunda pessoa: ");
        String name2 = Sc.next();
        System.out.println("Escreva a idade da segunda pessoa: ");
        int age2 = Sc.nextInt();

        System.out.printf("%s tem uma diferença de %s anos de idade para %s", name1, (age1 - age2), name2);

        Sc.close();
    }
}
