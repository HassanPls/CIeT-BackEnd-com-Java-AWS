package poo.collections_e_classes_uteis.Aula12.domain;

import java.util.Objects;

public abstract class GenericDomain<T> {
    private T id;

    public GenericDomain(T id) {
        this.id = id;
    }

    public GenericDomain() {}

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GenericDomain<?> that)) return false;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GenericDomain [id=" + id + "]";
    }
}
