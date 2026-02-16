package poo.collections_e_classes_uteis.Ex2;

import java.util.Scanner;

public class Ex2 {
    /*
     * Escreva um código que receba entradas sem formatação e as retorne formatadas,
     * os tipos de entradas que o código deve retornar são as seguintes:
     * 
     * Telefone fixo (8 dígitos sem DDD xxxx-xxxx, 10 Dígitos com DDD
     * (xx)xxxx-xxxx);
     * Celular (9 dígitos sem DDD xxxxx-xxxx, 11 dígitos (xx)xxxxx-xxxx);
     * O código deve ser capaz de detectar as seguintes situações:
     * 
     * Se receber somente números detectar se corresponde com algum dos formatos
     * aceitos e retornar formatado;
     * Se receber uma entrada com quantidade de números diferentes dos padrões
     * descritos acima, informar que não se trata de um número válido;
     * Se receber um número formatado, retorna-lo do mesmo jeito e informar de qual
     * tipo de dispositivo se trata;
     * Se receber com mascara incorreta, corrigir e retornar
     * Se receber qualquer entrada que tenha números e outros caracteres verificar
     * se tem números para compor um dos tipos aceitos e retornar do que se trata ou
     * retornar que foi uma entrada inválida.
     */
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Escreva o número sem formatação");
        String numberString = Sc.nextLine();
        String number = numberString.trim().replaceAll("\\D+", "");

        String numberFormated = "";
        if (number.length() == 8) {
            numberFormated = String.format("Telefone fixo sem DDD: %s-%s", number.substring(0, 4), number.substring(4));
        } else if (number.length() == 10) {
            numberFormated = String.format("Telefone fixo com DDD: (%s)%s-%s", number.substring(0, 2),
                    number.substring(2, 6), number.substring(6));
        } else if (number.length() == 9) {
            numberFormated = String.format("Celular sem DDD: %s-%s", number.substring(0, 5), number.substring(5));
        } else if (number.length() == 11) {
            numberFormated = String.format("Celular com DDD: (%s)%s-%s", number.substring(0, 2), number.substring(2, 7), number.substring(7));
        }
        System.out.println(numberFormated);

        Sc.close();

    }
}
