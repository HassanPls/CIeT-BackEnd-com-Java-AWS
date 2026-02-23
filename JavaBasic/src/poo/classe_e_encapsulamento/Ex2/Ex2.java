package poo.classe_e_encapsulamento.Ex2;

import java.util.Scanner;

public class Ex2 {

    /* 
    Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
    Ligar o carro;
    Desligar o carro;
    Acelerar;
    diminuir velocidade;
    virar para esquerda/direita
    verificar velocidade;
    trocar a marcha
    Siga as seguintes regras na implementação

    Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
    O carro desligado não pode realizar nenhuma função;
    Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
    Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no minimo a 0km);
    o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
    A velocidade do carro deve respeitar os seguintes limites para cada velocidade
    se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
    se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
    se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
    se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
    se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
    se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
    se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
    O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
    O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km e no máximo 40km;
    */
    private static Scanner Sc = new Scanner(System.in);
    private static Car car = new Car();
    public static void main(String[] args) {
        int option = -1;

        do {
            System.out.println("Escolha uma opção");
            System.out.println("0 - sair");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Desacelerar");
            System.out.println("5 - Virar para esquerda/direita");
            System.out.println("6 - Trocar a marcha");

            option = Sc.nextInt();

            switch (option) {
                case 1 -> car.on();
                case 2 -> car.off();
                case 3 -> car.accelerate();
                case 4 -> car.decelerate();
                case 5 -> leftOrRight();
                case 6 -> changeGear();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);

        Sc.close();
    }
    private static void changeGear() {
        System.out.println("Escolha uma marcha (0 a 6): ");
        int option = Sc.nextInt();
        car.changeGear(option);
    }
    private static void leftOrRight() {
        String side = "";
        do {
            System.out.println("Vire para algum lado (left or right): ");
            side = Sc.next();
        } while (
            !side.equalsIgnoreCase("Left") &&
            !side.equalsIgnoreCase("Right")
        );
        car.turnLeftOrRight(null);
    }
}
