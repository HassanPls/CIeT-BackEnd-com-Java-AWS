package sintaxe_basica.fundamentos_basicos;
import java.util.Scanner;
/* 
É possível importar todas as classes de um pacote usando o caractere "*"
*/

public class Aula1 {

    private final static String WELCOME_MESSAGE = "Seja bem-vindo ao Java!";
    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        // Criando um objeto para o scanner
        Scanner Sc = new Scanner(System.in);
        System.out.println("Informe o seu nome: ");
        String name = Sc.next();
        System.out.println("Informe a sua idade: ");
        int age = Sc.nextInt();
        System.out.printf("Olá, %s! Você tem %d anos.\n", name, age);
        //System.out.println("Olá, " + name + "! Você tem " + age + " anos.");
        Sc.close();
    }
}
