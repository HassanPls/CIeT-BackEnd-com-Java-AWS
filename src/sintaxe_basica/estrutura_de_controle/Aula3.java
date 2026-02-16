package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Aula3 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        for(;;) {
            System.out.println("Digite um nome: ");
            String name = Sc.next();

            if (name.equalsIgnoreCase("exit")) break;

            System.out.println(name);
        }

        /* for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) continue
            System.out.println(i);
        } */

        /* for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        for (String arg : args) {
            System.out.println(arg);
        } */

        Sc.close();
    }
}
