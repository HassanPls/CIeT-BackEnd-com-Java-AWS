package exceptions_io_dependecies.exceptions.Aula1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Aula1 {
    public static void main(String[] args) {
        //test1();
        System.out.println("terminou");
    }

    private static void test1() throws FileNotFoundException {
        var stream = new FileOutputStream("");
    }

    private static void test2() {
        System.out.println((10 / 0));
    }

    private static void test3() {
        throw new RuntimeException();
    }

    private static void test4() {
                    new Throwable(); //pai de exceptions e errors
            new Exception();  new Error(); // errors
        new RuntimeException(); new FileNotFoundException();
    }
}
