package poo.collections_e_classes_uteis.Aula9;

import java.util.Optional;

public class Aula9 {
    public static void main(String[] args) {
        Optional<User> optional = Optional.of(new User("Pedro", 17, SexEnum.MALE));
        // Optional<User> optional = Optional.ofNullable(null);
        // Optional<User> optional = Optional.empty();
        // System.out.println(optional.get());
        // optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(user -> {
            System.out.println(user);
            /* user = new User("Pedro", 22, SexEnum.MALE);
            System.out.println(user); */
        }, () -> System.out.println("Sem usuário"));

        System.out.println(optional.orElse(defaultUser()));
        System.out.println(optional.orElseGet(Aula9::defaultUser));

        Optional<UserV2> newUser = optional.map(user -> toV2Domain(user));
        System.out.println(newUser.orElseThrow());
    }

    private static UserV2 toV2Domain(User user) {
        return new UserV2(user.name(), user.age(), user.sex());
    }

    public static User defaultUser() {
        System.out.println("Buscando valor padrão");
        return new User("Maria", 29, SexEnum.FEMALE);
    }
}
