package poo.collections_e_classes_uteis.Aula3;

import java.util.HashMap;
import java.util.Map;

import poo.collections_e_classes_uteis.Aula3.domain.User;

public class Aula3 {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("joao@gmail.com", new User("João", 22));
        users.put("maria@gmail.com", new User("Maria", 32));
        users.put("juca@gmail.com", new User("Juca", 18));
        users.put("leo@gmail.com", new User("Leo", 40));
        System.out.println(users);
        users.keySet().forEach(System.out::println);
        users.values().forEach(System.out::println);

        System.out.println(users.containsKey("marcos@gmail.com"));
        System.out.println(users.containsValue(new User("Leo", 40)));

        users.remove("joao@gmail.com", new User("João", 22));
        users.replace("maria@gmail.com", new User("Maria", 20));
        users.forEach((k, v) -> System.out.printf("key: %s | value: %s", k, v));
        System.out.println(users.getOrDefault("joao@gmail.com", new User("", -1)));
        System.out.println(users.isEmpty());
    }
}
