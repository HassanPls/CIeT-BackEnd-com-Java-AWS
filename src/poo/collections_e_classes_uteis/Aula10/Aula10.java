package poo.collections_e_classes_uteis.Aula10;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aula10 {
    public static void main(String[] args) {
        Integer[] value1 = Stream.generate(() -> new Random().nextInt()).limit(5).toArray(Integer[]::new);
        for (Integer integer : value1) {
            System.out.println(integer);
        }
        ;

        // int[] value2 = IntStream.generate(() -> new
        // Random().nextInt()).limit(5).toArray();

        List<String> value3 = Stream.of("Maria", "João", "Marcio", "Luana", "Leandro", "Marcia")
                .filter(name -> name.endsWith("a")).toList();
        // List<String> value3 = Stream.of("Maria", "João", "Marcio", "Luana",
        // "Leandro", "Marcia").anyMatch(n -> n.contains("a").findFirst());
        // List<String> value3 = Stream.of("Maria", "João", "Marcio", "Luana",
        // "Leandro", "Marcia").allMatch(n -> n.contains("a"));
        // List<String> value3 = Stream.of("Maria", "João", "Marcio", "Luana",
        // "Leandro", "Marcia").noneMatch(n -> n.contains("a"));
        // List<String> value3 = Stream.of("Maria", "João", "Marcio", "Luana",
        // "Leandro", "Marcia").findAny();
        // List<String> value3 = Stream.of("Maria", "João", "Marcio", "Luana",
        // "Leandro", "Marcia").reduce("", (a, b) -> a + ";" + b).replaceFirst(";", "");
        System.out.println(value3);
        Integer value4 = Stream.of(1, 2, 3, 4, 5, 6, 7).reduce(0, Integer::sum);
        System.out.println(value4);
        OptionalDouble value5 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 7, 7).distinct().average();
        System.out.println(value5);
        List<Boolean> value6 = Stream.of(1, 2, 3, 4, 5, 6, 7, 7, 7).map(n -> n % 2 == 0).toList();
        System.out.println(value6);
        List<Integer> values1 = List.of(3, 6, 9, 12);
        List<Integer> values2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        Set<Integer> newValue = values2.stream().filter(values1::contains).peek(System.out::println)
                .map(n -> values1.stream().reduce(n, (n1, n2) -> n1 - n2)).collect(Collectors.toSet());
        System.out.println(newValue);
    }
}
