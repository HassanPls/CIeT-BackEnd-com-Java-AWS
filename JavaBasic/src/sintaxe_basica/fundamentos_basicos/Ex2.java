package sintaxe_basica.fundamentos_basicos;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        //Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela
        Scanner Sc = new Scanner(System.in);
        System.out.println("Escreva o lado do quadrado: ");
        int L = Sc.nextInt();
        System.out.println("A área do quadrado é " + (L * L));
        Sc.close();
    }
}
