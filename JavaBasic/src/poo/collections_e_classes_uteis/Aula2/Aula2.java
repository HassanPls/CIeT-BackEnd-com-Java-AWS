package poo.collections_e_classes_uteis.Aula2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Aula2 {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Pedro"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "João"));
        users.add(new User(4, "Leo"));

        System.out.println(users.contains(new User(1, "Pedro")));

        users.forEach(System.out::println);

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /* users.removeAll(List.of(new User(3, "João"), new User(4, "Pedro"))); */
        users.removeIf(user -> user.getId() > 2);
        System.out.println(users);

        Set<User> users2 = new LinkedHashSet<>();
        users2.add(new User(1, "Pedro"));
        users2.add(new User(2, "Maria"));
        users2.add(new User(3, "João"));
        users2.add(new User(4, "Leo"));

        /* Set<User> users3 = new TreeSet<>(); */
        /* Set<User> users4 = new TreeSet<>((User u1, User u2) -> {
            if (u1.getId() < u2.getId()) return -1;
            if (u1.getId() > u2.getId()) return 1;
            return 0;
        }); */
        Set<User> users4 = new TreeSet<>(Comparator.comparingInt(User::getId).reversed());
        users4.add(new User(1, "Pedro"));
        users4.add(new User(2, "Maria"));
        users4.add(new User(3, "João"));
        users4.add(new User(4, "Leo"));

    }
}
