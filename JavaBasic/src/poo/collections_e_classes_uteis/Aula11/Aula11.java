package poo.collections_e_classes_uteis.Aula11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aula11 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers());
        users.sort(Comparator.comparing(User::name));
        // users.sort((u1, u2) -> u1.name().compareTo(u2.name()) );
        users.forEach(System.out::println);
        System.out.println("=================");
        List<User> values = users.stream()
                .filter(u -> u.contacts().stream().anyMatch(c -> c.type() == ContactType.EMAIL)).toList();
        values.forEach(System.out::println);
        System.out.println("=================");
        OptionalLong values2 = users.stream().flatMap(u -> u.contacts().stream())
                .filter(c -> c.type() == ContactType.PHONE)
                .map(c -> c.description().replace("(", "").replace(")", "").replace("-", "")).mapToLong(Long::parseLong).min();
        System.out.println(values2);
        System.out.println("=================");
        Map<String, User> values3 = users.stream().filter(u -> u.sex() == Sex.FEMALE).collect(Collectors.toMap(User::name, user -> user));
        values3.forEach((k, v) -> System.out.printf("'key: %s' | 'value: %s'\n", k, v));
    }

    private static List<User> generateUsers() {
        List<Contact> contacts1 = List.of(
                new Contact("(11)98765-4321", ContactType.PHONE),
                new Contact("pedro.silva@email.com", ContactType.EMAIL));
        List<Contact> contacts2 = List.of(
                new Contact("(11)8888-7777", ContactType.PHONE));
        List<Contact> contacts3 = List.of(
                new Contact("joao.santos@email.com", ContactType.EMAIL));
        List<Contact> contacts4 = List.of(
                new Contact("ana.costa@email.com", ContactType.EMAIL),
                new Contact("ana.costa2@email.com", ContactType.EMAIL));
        List<Contact> contacts5 = List.of(
                new Contact("(11)6666-5555", ContactType.PHONE),
                new Contact("(12)6666-5555", ContactType.PHONE));

        User user1 = new User("Pedro", 17, Sex.MALE, new ArrayList<>(contacts1));
        User user2 = new User("Maria", 25, Sex.FEMALE, new ArrayList<>(contacts2));
        User user3 = new User("João", 32, Sex.MALE, new ArrayList<>(contacts3));
        User user4 = new User("Ana", 28, Sex.FEMALE, new ArrayList<>(contacts4));
        User user5 = new User("Lucas", 22, Sex.MALE, new ArrayList<>(contacts5));
        User user6 = new User("Julio", 36, Sex.MALE, new ArrayList<>());

        return List.of(user1, user2, user3, user4, user5, user6);
    }
}
