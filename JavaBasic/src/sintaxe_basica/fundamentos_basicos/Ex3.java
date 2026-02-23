package sintaxe_basica.fundamentos_basicos;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        //Escreva um código que receba a base e a alturade um retângulo, calcule sua área e exiba na tela
        Scanner Sc = new Scanner(System.in);
        System.out.println("Escreva o comprimento do retângulo: ");
        int L1 = Sc.nextInt();
        System.out.println("Escreva a altura do retângulo: ");
        int L2 = Sc.nextInt();
        System.out.println("A área do retângulo é " + (L1 * L2));
        Sc.close();
    }
}
