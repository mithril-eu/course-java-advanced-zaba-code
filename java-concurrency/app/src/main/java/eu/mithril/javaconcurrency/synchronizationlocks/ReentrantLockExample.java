package eu.mithril.javaconcurrency.synchronizationlocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import eu.mithril.javaconcurrency.ConcurrentUtils;

public class ReentrantLockExample {

    private static final int NUM_INCREMENTS = 10000;

    private static final ReentrantLock lock = new ReentrantLock();

    private static int count = 0;

    public static void main(String[] args) {
        testLock();

        tryLock();
    }

    private static void testLock() {
        count = 0;

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(ReentrantLockExample::increment));

        ConcurrentUtils.stop(executor);

        System.out.println(count);
    }

    private static void tryLock() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        ReentrantLock lock = new ReentrantLock();

        executor.submit(() -> {
            lock.lock();
            try {
                ConcurrentUtils.sleep(1);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        ConcurrentUtils.stop(executor);
    }

    private static void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
