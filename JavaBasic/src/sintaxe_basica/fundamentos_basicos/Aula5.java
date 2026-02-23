package sintaxe_basica.fundamentos_basicos;

public class Aula5 {
    public static void main(String[] args) {
        // Operador bitwise
        int value1 = 6;
        String binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro valor: %s, valor em binário: %s\n",value1, binary1);
        int value2 = 5;
        String binary2 = Integer.toBinaryString(value2);
        System.out.printf("Segundo valor: %s, valor em binário: %s\n", value2, binary2);
        System.out.printf("%s | %s = %s, valor em binário: %s\n",value1, value2, value1 | value2, Integer.toBinaryString(value1 | value2)); 
        // o caracter "|" representa o OU e o caracter "&" representa "E", tratando cada 0 e 1 com uma comparação
        // o caracter "^" retorna true para cada bytes diferente
        // o caracter "~" retorna o oposto do bytes
        // o caracter "<<" empurra o binário para esquerda de acordo com a quantidade do número informado, adicionando o 0
        // o caracter ">>" empurra o binário para direita de acordo com a quantidade do número informado, mantendo o valor como negativo ou positivo
    }
}
