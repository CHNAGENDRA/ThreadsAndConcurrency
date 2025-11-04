package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

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

        List<Future<String>> futures = executorService.invokeAll(callableList);

        for(Future<String> future : futures){
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
