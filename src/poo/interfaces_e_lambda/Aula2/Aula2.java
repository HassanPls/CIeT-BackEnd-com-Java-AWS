package poo.interfaces_e_lambda.Aula2;

import java.util.List;
import java.util.function.Function;

public class Aula2 {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Maria", 21), new User("Pedro", 17), new User("Bruno", 13));

        /* users.forEach(System.out::println); */
        printStringValue(User::name, users);
    }

    private static void printStringValue(Function<User, String> callback, List<User> users) {
        users.forEach(u -> System.out.println(callback.apply(u)));
    }
}
