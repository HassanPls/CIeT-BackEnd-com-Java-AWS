package exceptions_io_dependecies.io.Aula1e2e3;

import java.io.IOException;

import exceptions_io_dependecies.io.Aula1e2e3.persistence.FilePersistence;
import exceptions_io_dependecies.io.Aula1e2e3.persistence.IOFilePersistence;

public class Aula1 {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new IOFilePersistence("user.csv");
        persistence.write("Lucas;lucas@lucas.com;15/01/1990;");
        persistence.write("Maria;maria@maria.com;20/02/2000;");
        persistence.write("Jorge;jorge@jorge.com;25/03/2010;");
        System.out.println("======================");
        System.out.println(persistence.findAll());
        System.out.println("======================");
        System.out.println(persistence.remove("Maria;"));
        System.out.println(persistence.remove("Pedro;"));
        System.out.println("======================");
        System.out.println(persistence.findBy("Lucas;"));
        System.out.println(persistence.findBy("20/02"));
        System.out.println("======================");
        persistence.replace("Lucas;", "Pedro;pedro@pedro.com;02/02/2000");
        System.out.println(persistence.findAll());
    }
}
