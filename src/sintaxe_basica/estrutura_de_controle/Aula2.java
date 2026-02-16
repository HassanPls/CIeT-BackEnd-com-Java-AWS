package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Aula2 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Informe um número de 1 até 7");
        int option = Sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Domingo");
                break;
        
            case 2:
                System.out.println("Segunda");
                break;

            case 3:
                System.out.println("Terça");
                break;

            case 4: 
                System.out.println("Quarta");
                break;

            case 5:
                System.out.println("Quinta");
                break;

            case 6:
                System.out.println("Sexta");
                break;

            case 7: 
                System.out.println("Sábado");
                break;
                
            default:
                System.out.println("Dia da semana inválido");
                break;
        }

        /* String message = switch (option) {
            case 1, 7 -> {
                String day = option == 1 ? "Domingo" : "Sábado";
                yield String.format("Hoje é %s, fim de semana!\n", day);
            }
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexta";
            default -> "Dia da semana inválido";
        };
        System.out.println(message); */

        Sc.close();
    }
}
