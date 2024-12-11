package lab3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private Semaphore semaphore;
    private ScheduledExecutorService executor;

    public Scheduler(Semaphore semaphore) {
        this.semaphore = semaphore;
        this.executor = Executors.newScheduledThreadPool(2);
    }

    public void startScheduler(String folderPath) {
        semaphore.initializeQueue(folderPath);

        // Monitor folder for new files every 3 seconds
        executor.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Checking for new files...");
                semaphore.monitorQueueFolder(folderPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Serving cars...");
                semaphore.serveAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS);

        // Keep the main thread alive
        try {
            // Wait indefinitely
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        if (executor != null) {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }
    }
}