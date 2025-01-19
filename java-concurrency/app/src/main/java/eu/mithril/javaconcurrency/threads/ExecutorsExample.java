package eu.mithril.javaconcurrency.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

    public static void main(String[] args) {
        test(6);

    }

    private static void test(long seconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("task finished: " + name);
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });
        stop(executor);
    }

    static void stop(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
