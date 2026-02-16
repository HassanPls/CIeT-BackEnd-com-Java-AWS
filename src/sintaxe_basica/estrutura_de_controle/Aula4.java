package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Aula4 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        String name = "";

        while (!name.equalsIgnoreCase("exit")) {
            System.out.println("Informe o nome: ");
            name = Sc.next();
            System.out.println(name);
        }

        /* do {
            System.out.println("Informe o nome: ");
            name = Sc.next();
            System.out.println(name);
        } while (!name.equalsIgnoreCase("exit")); */

        Sc.close();
    }
}
