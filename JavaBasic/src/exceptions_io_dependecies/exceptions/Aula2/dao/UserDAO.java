package exceptions_io_dependecies.exceptions.Aula2.dao;

import java.util.ArrayList;
import java.util.List;

import exceptions_io_dependecies.exceptions.Aula2.exception.EmptyStorageException;
import exceptions_io_dependecies.exceptions.Aula2.exception.UserNotFoundException;
import exceptions_io_dependecies.exceptions.Aula2.model.UserModel;

public class UserDAO {
    private long nextId = 1L;
    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id) {
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id) {
        verifyStorage();
        return models.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(
                () -> new UserNotFoundException(String.format("Não existe usuário com o if %s cadastrado", id))
            );
    }

    public List<UserModel> findAll() {
        List<UserModel> result = null;
        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException e) {
            e.printStackTrace();
            result = new ArrayList<>();
        } 
        
        return result;
    }

    private void verifyStorage() {
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio!");
    }
}
