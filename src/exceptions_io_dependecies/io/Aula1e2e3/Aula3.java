package exceptions_io_dependecies.io.Aula1e2e3;

import java.io.IOException;

import exceptions_io_dependecies.io.Aula1e2e3.persistence.FilePersistence;
import exceptions_io_dependecies.io.Aula1e2e3.persistence.NIO2FilePersistence;

public class Aula3 {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIO2FilePersistence("user.csv");
        persistence.write("Luana;luana@luana.com;22/09/1997");
        persistence.write("Marcos;marcos@marcos.com;29/11/1998");
        persistence.write("Henrique;henrique@henrique.com;12/01/2000");
        System.out.println("======================");
        System.out.println(persistence.findAll());
        System.out.println("======================");
        System.out.println(persistence.remove("Luana;"));
        System.out.println(persistence.remove("Pedro;"));
        System.out.println("======================");
        System.out.println(persistence.findBy("Marcos;"));
        System.out.println(persistence.findBy("20/02"));
        System.out.println("======================");
        persistence.replace("Henrique;", "Pedro;pedro@pedro.com;02/02/2000");
        System.out.println(persistence.findAll());
    }
}
