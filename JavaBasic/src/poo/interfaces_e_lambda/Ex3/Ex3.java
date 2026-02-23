package poo.interfaces_e_lambda.Ex3;

import java.util.Scanner;

public class Ex3 {
    /* Escreva um código onde seja possível calcular a área de uma figura geométrica, todas devem ter um método que retorne esse valor, as formas geométricas disponiveis devem ser as seguintes:

    Quadrado: possui o valor dos seus lados;
    Retângulo: possui os valores de base e altura;
    Circulor: possui o atributo raio. */
    private static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int option = -1;

        do {
            System.out.println("Escolha uma opção");
            System.out.println("0 - sair");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retângulo");
            System.out.println("3 - Círculo");

            option = Sc.nextInt();

            switch (option) {
                case 1 -> getSquareArea();
                case 2 -> getRectangleArea();
                case 3 -> getCircleArea();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);

        Sc.close();
    }
    private static void getCircleArea() {
        System.out.println("Informe o raio do circulo");
        double radius = Sc.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("A área do círculo é " + circle.getArea());
    }
    private static void getRectangleArea() {
        System.out.println("Informe a altura do retângulo");
        double height = Sc.nextDouble();
        System.out.println("Informe a base do retângulo");
        double base = Sc.nextDouble();
        Rectangle rectangle = new Rectangle(height, base);
        System.out.println("A área do retângulo é " + rectangle.getArea());
    }
    private static void getSquareArea() {
        System.out.println("Informe o lado do quadrado");
        double side = Sc.nextDouble();
        Square square = new Square(side);
        System.out.println("A área do quadrado é " + square.getArea());
    }
}
