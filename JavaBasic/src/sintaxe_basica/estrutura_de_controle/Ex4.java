package sintaxe_basica.estrutura_de_controle;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        //Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números, a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha resto diferente de 0 na divisão, números menores que o primeiro número devem ser ignorados
        Scanner Sc = new Scanner(System.in);
        System.out.println("Informe um número: ");
        int number = Sc.nextInt();
        boolean keepVerify = true;

        while (keepVerify) {
            System.out.println("Informe o número para verificação");
            int numberToVerify = Sc.nextInt();

            if (numberToVerify < number) {
                System.out.printf("Informe um número maior que %s!\n", number);
                continue;
            }

            keepVerify = numberToVerify % number == 0;
            System.out.printf("%s %% %s = %s\n", numberToVerify, number, (numberToVerify % number));
        }

        Sc.close();
    }
}
