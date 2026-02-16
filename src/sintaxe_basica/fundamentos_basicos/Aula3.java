package sintaxe_basica.fundamentos_basicos;
import java.util.Scanner;

public class Aula3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Operador de atribuição "="
        System.out.println("Quanto é 2 + 2?");
        var result = scanner.nextInt();
        // boolean isCorrect = result == 4; Operador de igual "=="
        boolean isIncorrect = result != 4; // Operador de diferente "!="
        System.out.printf("O resultado é 4, você acertou? %s\n", !isIncorrect); //Operador lógico "!" para negar a expressão

        System.out.println("Quantos anos você tem? ");
        int age = scanner.nextInt();
        boolean canDrive = age >= 18; // Operador maior igual ">=" 
        //boolean canDrive = age > 17; Operador maior ">" tamém poderia ser usado
        System.out.printf("Você pode dirigir? %s\n", canDrive);

        System.out.println("Você é emancipado?");
        boolean isEmancipated = scanner.nextBoolean();
        boolean canDriveWithEmancipation = (canDrive || isEmancipated) && age >= 16; // Operador para OU "||" e para E "&&"
        System.out.printf("Você pode dirigir com emancipação? %s\n", canDriveWithEmancipation);

        scanner.close();

        /* 
        &&
        ||
        >
        <
        >=
        <=
        ==
        !=
        !
        */
    }
}
