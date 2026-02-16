package sintaxe_basica.fundamentos_basicos;

import java.time.OffsetDateTime;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        //Escreva um código que receba o nome e o ano de nascimento de alguém e imprima na tela a seguinte mensagem: "Olá 'Fulano' você tem 'X' anos"
        Scanner Sc = new Scanner(System.in);
        System.out.println("Informe seu nome: ");
        String nome = Sc.next();
        System.out.println("Informe o seu ano de nascimento: ");
        int year = Sc.nextInt();
        System.out.printf("Olá, %s! Você tem %s anos.", nome, OffsetDateTime.now().getYear() - year);
        Sc.close();
    }
}
