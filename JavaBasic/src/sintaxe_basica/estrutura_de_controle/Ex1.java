package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        //Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número;
        Scanner Sc = new Scanner(System.in);
        System.out.println("Escreva um número: ");
        int num = Sc.nextInt();
        System.out.printf("Tabuada do número %d\n", num);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d\n", num, i, (num * i));
        }
        Sc.close();
    }
}
