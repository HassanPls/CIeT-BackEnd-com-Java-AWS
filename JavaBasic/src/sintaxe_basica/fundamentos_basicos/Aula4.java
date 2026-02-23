package sintaxe_basica.fundamentos_basicos;
import java.util.Scanner;

public class Aula4 {
    public static void main(String[] args) {
        // Operadores aritméticos com uma calculadora
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número inteiro: ");
        int number1 = scanner.nextInt(); // problemas podem acontecer por conta do Int, mas é possível trocar para Float ou Double.
        System.out.println("Digite o segundo número inteiro: ");
        int number2 = scanner.nextInt();
        System.out.printf("%s + %s = %s\n", number1, number2, number1 + number2);
        System.out.printf("%s - %s = %s\n", number1, number2, number1 - number2);
        System.out.printf("%s * %s = %s\n", number1, number2, number1 * number2);
        System.out.printf("%s / %s = %s\n", number1, number2, number1 / number2);
        System.out.printf("%s %% %s = %s\n", number1, number2, number1 % number2);
        System.out.printf("Raiz quadrada de %s é %s\n", number1, Math.sqrt(number1));
        System.out.printf("%s elevado a %s é %s\n", number1, number2, Math.pow(number1, number2));

        int number3 = 10;
        System.out.println(++number3);
        System.out.println(number3);
        System.out.println(--number3);
        System.out.println(number3);

        scanner.close();
    }
}
