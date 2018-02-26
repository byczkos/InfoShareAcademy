package pl.academy.infoshare.sample6;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Calculator {

    private boolean running = true;
    private Set<Result> results = new HashSet<>();
    private String resultsString = "";
    private ExecutorService executorService = Executors.newFixedThreadPool(50);

    void run() {
        IntStream.range(1, 51)
                 .forEach(i -> executorService.execute(calculator(i)));
    }

    void stop() {
        running = false;
        executorService.shutdown();
    }

    private Runnable calculator(int i) {
        return () -> {
            while (running) {
                try {
                    Thread.sleep(new Random().nextInt(100));
                    Random r = new Random();
                    int x = r.nextInt();
                    int y = r.nextInt();
                    int result = x + y;
                    String resultString = "I am calculator ... " + i + " and " + x + " + " + y + " = " + result;
                    System.out.println(resultString);
                    results.add(new Result(result));
                    resultString = resultString.concat(resultString);
                } catch (InterruptedException e) {
                }
            }
        };
    }


    final class Result {
        private final long value;

        public Result(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        calculator.run();
        // calculator.stop();
    }

}
