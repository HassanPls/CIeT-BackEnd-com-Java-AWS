package poo.collections_e_classes_uteis.Aula5;

import java.util.HashMap;
import java.util.Map;

public class Aula5 {
    public static void main(String[] args) {
        String value = "java;java;java    ";
        value = value.replace("j", "J");
        System.out.println(value);
        System.out.println(value.equals("java;java;java"));
        String[] valuesSplited = value.split(";");
        for (String valueSplited : valuesSplited) {
            System.out.println(valueSplited);
        }
        System.out.println(value.toUpperCase());
        System.out.println(value.toLowerCase());
        System.out.println(value.contains(";"));
        System.out.println(value.indexOf("J", 1, 5));
        System.out.println(value.startsWith("Ja"));
        System.out.println(value.isEmpty());
        System.out.println(value.isBlank());
        System.out.println(value.trim());
        System.out.println(value.substring(5, 9));

        String value1 = """
                {
                    "name": "Pedro",
                    "age":17
                }
                """;
        Map<String, String> map = new HashMap<>();
        value1 = value1.replace("{", "").replace("}", "").replace("\"", "");
        String[] valueArray = value1.split(",");
        for (int i = 0; i < valueArray.length; i++) {
            String[] keyValue = valueArray[i].split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        System.out.println(map);

        String value2 = "a";
        System.out.println(value2.repeat(5));
        System.out.printf("Trabalhando com %s", "Java");
    }
}
