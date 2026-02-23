package poo.collections_e_classes_uteis.Aula8;

import java.util.Scanner;

public class Aula8 {

    private static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        var option = -1;
        while (option != 5) {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("0 - Sair");

            option = Sc.nextInt();

            if (option > 5 || option < 1) {
                System.out.println("Selecione uma opção válida");
                continue;
            }

            if (option == 0) break;

            OperationEnum selectedOption = OperationEnum.values()[option - 1];

            System.out.println("Informe o primeiro valor: ");
            int value1 = Sc.nextInt();
            System.out.println("Informe o segundo valor: ");
            int value2 = Sc.nextInt();

            int result = selectedOption.getCalculate().apply(value1, value2);

            System.out.printf("%s %s %s = %s\n\n", value1, selectedOption.getSymbol(), value2, result);
        }

        
    }
}
