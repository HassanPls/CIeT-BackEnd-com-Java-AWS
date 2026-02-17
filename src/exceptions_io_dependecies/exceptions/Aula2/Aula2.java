package exceptions_io_dependecies.exceptions.Aula2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import exceptions_io_dependecies.exceptions.Aula2.dao.UserDAO;
import exceptions_io_dependecies.exceptions.Aula2.exception.EmptyStorageException;
import exceptions_io_dependecies.exceptions.Aula2.exception.UserNotFoundException;
import exceptions_io_dependecies.exceptions.Aula2.exception.ValidatorException;
import exceptions_io_dependecies.exceptions.Aula2.model.MenuOption;
import exceptions_io_dependecies.exceptions.Aula2.model.UserModel;
import exceptions_io_dependecies.exceptions.Aula2.validator.UserValidator;

public class Aula2 {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {

            System.out.println("Bem vindo ao cadastro de usuários, selecione a operação desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            int userInput = Sc.nextInt();

            MenuOption selectedOption = MenuOption.values()[userInput - 1];
            switch (selectedOption) {
                case SAVE -> {
                    try {
                        UserModel user = dao.save(requestToSave());
                        System.out.println("Usuário cadastrado: \n" + user);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.getStackTrace();
                    }
                }
                case UPDATE -> {
                    try {
                        UserModel user = dao.update(requestToUpdate());
                        System.out.println("Usuário atualizado: \n" + user);
                    } catch (UserNotFoundException | EmptyStorageException e) {
                        System.out.println(e.getMessage());
                    } catch (ValidatorException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    } finally {
                        System.out.println("=============");
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário excluido");
                    } catch (UserNotFoundException | EmptyStorageException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("=============");
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        UserModel user = dao.findById(requestId());
                        System.out.println("Usuário encontrado: \n" + user);
                    } catch (UserNotFoundException | EmptyStorageException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("=============");
                    }
                }
                case FIND_ALL -> {
                    List<UserModel> users = dao.findAll();
                    System.out.println("Usuários cadastrados: \n" + users);
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    public static UserModel requestToSave() throws ValidatorException {
        System.out.println("Informe o nome do usuário: ");
        String name = Sc.next();
        System.out.println("Informe o email do usuário: ");
        String email = Sc.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy) : ");
        String birthdayString = Sc.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static UserModel validateInputs(final long id, final String name, final String email,
            final LocalDate birthday) throws ValidatorException {
        UserModel user = new UserModel(0, name, email, birthday);
        UserValidator.verifyModel(user);
        return user;
    }

    public static long requestId() {
        System.out.println("Informe o identificador do usuário: ");
        return Sc.nextLong();
    }

    public static UserModel requestToUpdate() throws ValidatorException {
        System.out.println("Informe o identificador do usuário: ");
        long id = Sc.nextLong();
        System.out.println("Informe o nome do usuário: ");
        String name = Sc.next();
        System.out.println("Informe o email do usuário: ");
        String email = Sc.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy) : ");
        String birthdayString = Sc.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);

        return validateInputs(id, name, email, birthday);

    }
}
