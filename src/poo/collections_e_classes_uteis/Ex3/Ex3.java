package poo.collections_e_classes_uteis.Ex3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex3 {
    /*
     * Escreva um código que receba 3 valores separados por um caracter de sua
     * escolha n vezes ( n é o número de vezes que o usuário desejar informar) ex.:
     * nome;Lucas;Texto. Quando o usuário parar de informar valores o código deve
     * retornar todos esses campos compondo um json, um xml e um yaml (Json:
     * https://pt.wikipedia.org/wiki/JSON, XML: https://pt.wikipedia.org/wiki/XML,
     * yaml: https://www.treinaweb.com.br/blog/o-que-e-yaml) as entradas devem
     * seguir o seguinte padrão:
     * 
     * NOME_CAMPO;VALOR;TIPO;
     * Os tipos que devem ser aceitos são: texto, datas, data e hora, números
     * inteiros, números com pontos flutuantes, boleanos, array dos tipos anteriores
     * ( opcional, possibilitar definir arrays de objetos e objetos internos).
     */
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        Map<String, Object> map = new HashMap<>();
        String input = "";
        do {
            System.out.println(
                    "Escreva o valor na seguinte estrutura (NOME_CAMPO;VALOR;TIPO) Aperte enter para terminar de declarar");
            input = Sc.nextLine().trim();
            String[] inputs = input.split(";");
            if (inputs.length == 3) {
                String name = inputs[0];
                String value = inputs[1];
                String type = inputs[2];

                try {
                    map.put(name, conversor(value, type));
                } catch (Exception e) {
                    System.out.println("Erro " + e.getMessage());
                }
            } else {
                if (!input.equals("")) System.out.println("Formato inválido. (NOME_CAMPO;VALOR;TIPO)");
            }
        } while (!input.equals(""));

        Sc.close();

        System.out.println("==================");
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        map.forEach((k, v) -> {
            jsonBuilder.append("  \"")
                    .append(k)
                    .append("\": ");
            if (v instanceof String) {
                jsonBuilder.append("\"").append(v).append("\"");
            } else {
                jsonBuilder.append(v);
            }
            jsonBuilder.append(",\n");
        });
        jsonBuilder.append("}");
        String jsonString = jsonBuilder.toString();

        System.out.println(jsonString);

        System.out.println("==================");
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<dados>\n");
        map.forEach((k, v) -> {
            xmlBuilder.append("   <").append(k).append(">");
            xmlBuilder.append(v);
            xmlBuilder.append("</").append(k).append(">\n");
        });
        xmlBuilder.append("</dados>\n");
        String xmlString = xmlBuilder.toString();
        System.out.println(xmlString);

        System.out.println("==================");
        StringBuilder yamlBuilder = new StringBuilder();
        map.forEach((k, v) -> {
            yamlBuilder.append(k).append(" : ").append(v);
        });
        String yamlString = yamlBuilder.toString();
        System.out.println(yamlString);
        System.out.println("==================");
    }

    public static Object conversor(String value, String type) {
        switch (type.toLowerCase()) {
            case "texto":
                return value;
            case "data":
                return LocalDate.parse(value);
            case "datahora":
                return LocalDateTime.parse(value);
            case "inteiro":
                return Integer.parseInt(value);
            case "float":
                return Float.parseFloat(value);
            case "boolean":
                return Boolean.parseBoolean(value);

            default:
                throw new IllegalArgumentException();
        }
    }
}