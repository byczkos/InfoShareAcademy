package pl.academy.infoshare.sample4;

import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class BasicThreading {

    static void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 11)
                 .forEach(i -> executorService.execute(createRunnable(i)));
        executorService.shutdown();
    }

    private static Runnable createRunnable(int threadNum) {
        return () -> {
            try {
                Thread.currentThread().setName("My Thread " + threadNum);
                Thread.sleep(new Random().nextInt(1000));
                System.out.println("I am runnable ... " + threadNum);
            } catch (InterruptedException e) {
            }
        };
    }

    public static void main(String[] args) throws Exception {
        run();
    }

}
