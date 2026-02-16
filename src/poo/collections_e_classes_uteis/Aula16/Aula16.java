package poo.collections_e_classes_uteis.Aula16;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Aula16 {
    private final static Queue<Integer> numbers = new LinkedBlockingQueue<>(250_000);
    //private final static AtomicInteger numbers = new AtomicInteger(0);

    private static void inc(int number) {
        numbers.add(number);
    }

    private static void show() {
        System.out.println(numbers);
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable inc = () -> {
            for (int i = 0; i < 100_000; i++) {
                inc(i);
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i > -100_000; i++) {
                inc(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 250_000; i++) {
                show();
            }
        };

        Thread execInc = new Thread(inc);
        execInc.start();
        execInc.setName("execInc");
        Thread execDec = new Thread(dec);
        execDec.start();
        execDec.setName("execDec");
        //execDec.join(Duration.ofSeconds(1));
        Thread execShow = new Thread(show);
        execShow.start();
        execShow.setName("execShow");

    }
}
