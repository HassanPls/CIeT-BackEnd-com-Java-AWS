package poo.collections_e_classes_uteis.Aula2;

import java.util.Objects;

public class User /* implements Comparable<User> */{
    private int id;
    private String name;

    public User() {
    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof User user) {
            if (this == user) return true;
            if (this.id == user.id && Objects.equals(this.name, user.name)) return true;
            return false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("{ 'id': %s, 'name': %s  }", this.id, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    /* @Override
    public int compareTo(final User user) {
        if (this.id < user.id) return -1;
        if (this.id > user.id) return 1;
        return 0;
    } */
}
