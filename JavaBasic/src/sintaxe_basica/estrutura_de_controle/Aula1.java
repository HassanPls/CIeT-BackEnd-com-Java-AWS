package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Aula1 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Informe seu nome");
        String name = Sc.next();
        System.out.println("Informe sua idade");
        int age = Sc.nextInt();
        System.out.println("Você é emancipado? (s/n)");
        boolean isEmancipated = Sc.next().equalsIgnoreCase("s");

        if (age >= 18) {
            System.out.printf("%s, você tem %s anos e pode dirigir\n", name, age);
        } else if (age >= 16 && isEmancipated) {
            System.out.printf("%, apesar de você ter %s anos, você é emancipado e pode dirigir", name, age);
        } else {
            System.out.printf("%s, você não pode dirigir\n", name);
        }

        /* boolean canDrive = (age >= 18) || (age >= 16 && isEmancipated);
        String message = canDrive ?
            name + ", você pode dirigir\n" : 
            name + ", você não pode dirigir";
        System.out.println(message); */

        System.out.println("Fim da execução");
        Sc.close();
    }
}
