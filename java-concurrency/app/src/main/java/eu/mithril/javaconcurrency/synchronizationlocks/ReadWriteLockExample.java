package eu.mithril.javaconcurrency.synchronizationlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import eu.mithril.javaconcurrency.ConcurrentUtils;
import eu.mithril.javaconcurrency.TimeUtils;

public class ReadWriteLockExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Map<String, String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                ConcurrentUtils.sleep(1);
                System.out.println(TimeUtils.formattedTimestamp() + ": " + "map put");
                map.put("foo", "bar");
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                ConcurrentUtils.sleep(1);
                System.out.println(TimeUtils.formattedTimestamp() + ": " + map.get("foo"));
            } finally {
                lock.readLock().unlock();
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);

        ConcurrentUtils.stop(executor);
    }
}
