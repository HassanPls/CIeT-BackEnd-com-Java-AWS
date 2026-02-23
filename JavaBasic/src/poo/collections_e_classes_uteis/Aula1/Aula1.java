package poo.collections_e_classes_uteis.Aula1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Aula1 {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        test.get(0);

        int[] codes = new int[2];
        /* int[] codes = { 001, 002 } */
        codes[0] = 001;
        codes[1] = 002;

        /* List<Integer> codes2 = new LinkedList<>(); */

        List<User> users = new ArrayList<>();
        var user = new User(1, "Pedro");
        var user2 = new User(2, "Maria");
        var user3 = new User(3, "João");
        users.add(user);
        users.add(user2);
        users.add(user3);
        System.out.println(users.contains(user));
        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.getLast());
        System.out.println(users.getFirst());
        System.out.println(user.equals(new User(1, "Pedro")));
        System.out.println(users);
        System.out.println(users.remove(new User(1, "Pedro")));
        System.out.println(users);
        users.clear();
        System.out.println(users);

        
    }
}
