package eu.mithril.javaconcurrency.threads;

import java.util.concurrent.TimeUnit;

public class ThreadsExample {

    public static void main(String[] args) {
        threadRun();
        threadSleep(5);
    }

    private static void threadRun() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    static void threadSleep(long seconds) {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(seconds);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
