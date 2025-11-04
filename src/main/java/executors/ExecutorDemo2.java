package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo2 {
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

        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(task1);
        callableList.add(task2);
        callableList.add(task3);

        String result = executorService.invokeAny(callableList);

        System.out.println(result);

        executorService.shutdown();

    }
}
