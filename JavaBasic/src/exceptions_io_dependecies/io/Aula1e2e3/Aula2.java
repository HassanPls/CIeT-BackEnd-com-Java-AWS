package exceptions_io_dependecies.io.Aula1e2e3;

import java.io.IOException;

import exceptions_io_dependecies.io.Aula1e2e3.persistence.FilePersistence;
import exceptions_io_dependecies.io.Aula1e2e3.persistence.NIOFilePersistence;

public class Aula2 {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIOFilePersistence("user.csv");
        persistence.write("Bianca;bia@bia.com;22/09/1997");
        persistence.write("Bernardo;be@be.com;29/11/1998");
        persistence.write("Ricardo;ri@ri.com;12/01/2000");
        System.out.println("======================");
        System.out.println(persistence.findAll());
        System.out.println("======================");
        System.out.println(persistence.remove("Bianca;"));
        System.out.println(persistence.remove("Pedro;"));
        System.out.println("======================");
        System.out.println(persistence.findBy("Bernardo;"));
        System.out.println(persistence.findBy("20/02"));
        System.out.println("======================");
        persistence.replace("Bernardo;", "Pedro;pedro@pedro.com;02/02/2000");
        System.out.println(persistence.findAll());
    }
}
