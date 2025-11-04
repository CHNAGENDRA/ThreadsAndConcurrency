package syncronization;

public class Test {
    public static void main(String[] args) {

//        MyRunnable runnable1 = new MyRunnable();
//        Thread thread1 = new Thread(runnable1, "Thread-1");
//
//        MyRunnable runnable2 = new MyRunnable();
//        Thread thread2 = new Thread(runnable1, "Thread-2");

        MyRunnable runnable1 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable1, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final value of counter is: "+runnable1.getCounter());
    }
}
