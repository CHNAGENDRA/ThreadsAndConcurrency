package executors;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

         Runnable task1 = () -> {
           System.out.println("Executing task1 at "+LocalDateTime.now());
         };
        //adds initial delay of 5 seconds
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(task1, 5, TimeUnit.SECONDS);

        System.out.println(scheduledFuture.get());

        scheduledExecutorService.shutdown();
    }
}
