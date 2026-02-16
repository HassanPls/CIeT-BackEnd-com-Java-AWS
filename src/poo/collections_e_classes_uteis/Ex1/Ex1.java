package poo.collections_e_classes_uteis.Ex1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    //1 - Escreva um código que cria uma calculadora para as operações de soma e subtração, o usuário deve informar todos os números que serão usados na conta de uma só vez utilizando virgulas para separa-los.
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int operation = 0;
        do {
            System.out.println("Informe o número da operação que deseja realizar (1 - sum | 2 - subtraction)");
            operation = Sc.nextInt();
        } while (operation > 2 || operation < 1);

        Operation selectedOperation = Operation.values()[operation - 1];

        System.out.println("Informe os números que serão utilizados separados por vírgula (ex.: 1,2,3,4)");
        String numbers = Sc.next();
        long[] numberArray = Arrays.stream(numbers.split(",")).mapToLong(Long::parseLong).toArray();
        long result = selectedOperation.getOperationCallback().exec(numberArray);
        String operationToShow = numbers.replace(",", selectedOperation.getSinal());
        System.out.printf("O resultado da operação é %s = %s\n",operationToShow, result);
    
        Sc.close();
    }
}
