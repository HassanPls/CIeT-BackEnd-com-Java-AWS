package poo.classe_e_encapsulamento.Ex3;

import java.util.Scanner;

public class Ex3 {
    
    /* 
    Escreva um código onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operações:
    Dar banho no pet;
    Abastecer com água;
    Abastecer com shampoo;
    verificar nivel de água;
    verificar nivel de shampoo;
    verificar se tem pet no banho;
    colocar pet na maquina;
    retirar pet da máquina;
    limpar maquina.
    Siga as seguintes regras para implementação

    A maquina de banho deve permitir somente 1 pet por vez;
    Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
    A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
    Se o pet for retirado da maquina sem estar limpo será necessário limpar a máquina para permitir a entrada de outro pet;
    A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
    O abastecimento de água e shampoo deve permitir 2 litros por vez que for acionado;
    */

    private final static Scanner Sc = new Scanner(System.in);
    private final static WashingMachine machine = new WashingMachine();

    public static void main(String[] args) {
        Sc.useDelimiter("\\n");
        int option = -1;

        do {
            System.out.println("Escolha uma opção");
            System.out.println("0 - sair");
            System.out.println("1 - dar banho no pet");
            System.out.println("2 - abastecer a máquina com água");
            System.out.println("3 - abastecer a máquina com shampoo");
            System.out.println("4 - verificar água da máquina");
            System.out.println("5 - verificar shampoo da máquina");
            System.out.println("6 - verificar se tem pet no banho");
            System.out.println("7 - colocar pet na máquina");
            System.out.println("8 - retirar pet da máquina");
            System.out.println("9 - limpar máquina");

            option = Sc.nextInt();

            switch (option) {
                case 1 -> machine.takeShower();
                case 2 -> machine.addWater();
                case 3 -> machine.addShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> hasPetInWashingMachine();
                case 7 -> setPetInWashingMachine();
                case 8 -> machine.removePet();
                case 9 -> machine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);

        Sc.close();
    }

    private static void verifyWater() {
        int shampoo = machine.getWater();
        System.out.println("A máquina está no momento com " + shampoo + " litro(s) de água");
    }

    private static void verifyShampoo() {
        int shampoo = machine.getShampoo();
        System.out.println("A máquina está no momento com " + shampoo + " litro(s) de shampoo");
    }

    private static void hasPetInWashingMachine() {
        if (machine.hasPet()) { 
            System.out.println("Há um pet na máquina");
        } else { 
            System.out.println("Não há pet na máquina");
        }
    }

    public static void setPetInWashingMachine() {
        String name = "";
        while (name == null || name.isEmpty()) {
            System.out.println("Informe o nome do pet: ");
            name = Sc.next();
        }
        Pet pet = new Pet(name, false);
        machine.setPet(pet);
    }


}
