package exceptions_io_dependecies.exceptions.Aula2.validator;

import exceptions_io_dependecies.exceptions.Aula2.exception.ValidatorException;
import exceptions_io_dependecies.exceptions.Aula2.model.UserModel;

public class UserValidator {
    private UserValidator() {

    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (model.getName() == null || model.getName().isEmpty() || model.getName().isEmpty()) 
            throw new ValidatorException("Informe um nome válido");
        if (model.getName().length() < 2) 
            throw new ValidatorException("O nome deve ter mais que 1 caractér");
        if (!model.getEmail().contains("@") || !model.getEmail().contains(".")) 
            throw new ValidatorException("Informe um email válido"); 
        if (model.getEmail() == null || model.getEmail().isEmpty() || model.getEmail().isEmpty()) 
            throw new ValidatorException("Informe um email válido");
    }
}
