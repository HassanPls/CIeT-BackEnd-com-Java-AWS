package poo.collections_e_classes_uteis.Aula12.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import poo.collections_e_classes_uteis.Aula12.domain.GenericDomain;

public abstract class GenericDAO<ID, T extends GenericDomain<ID>> {

    private final List<T> db = new ArrayList<>();
    
    private T save(T domain) {
        db.add(domain);
        return domain;
    }

    public boolean save(T... domains){
        return db.addAll(Arrays.stream(domains).toList());
    }

    public T update(ID id, T domain) {
        T stored = find(d -> d.getId().equals(id)).orElseThrow();
        db.remove(stored);
        return save(domain);
    }

    public boolean delete(T domain) {
        return db.remove(domain);
    }

    public Optional<T> find(Predicate<T> filterCallback) {
        return db.stream().filter(filterCallback).findFirst();
    }

    public List<T> findAll() {
        return db;
    }
    
    public int count() {
        return db.size();
    }
}
