package executors;

import java.util.concurrent.*;

public class ExecutorDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            String threadName = Thread.currentThread().getName();
            return threadName+" executing task 1";
        };

        Callable<String> task2 = () -> {
            String threadName = Thread.currentThread().getName();
            return threadName+" executing task 2";
        };

        Callable<String> task3 = () -> {
            String threadName = Thread.currentThread().getName();
            return threadName+" executing task 3";
        };

        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        Future<String> future3 = executorService.submit(task3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        executorService.shutdown();
    }
}
