package eu.mithril.javaconcurrency.threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InvokeExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("invokeAll:");
        invokeAll();

        System.out.println("invokeAny:");
        invokeAny();
    }

    private static void invokeAll() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = List.of(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        executor.shutdown();
    }

    private static void invokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = List.of(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3)
        );

        String result = executor.invokeAny(callables);
        System.out.println(result);

        executor.shutdown();
    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }


}
