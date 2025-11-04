package syncronization;

public class InventoryManager implements Runnable{

    private int count = 200000;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        String function = Thread.currentThread().getName();
        if(function.equals("issue")){
            for(int i=0;i<100000;i++){
                synchronized (this) {
                    count--;
                }
            }
        } else if (function.equals("receive")) {
            for(int i=0;i<100000;i++) {
                synchronized (this) {
                    count++;
                }
            }
        }
    }
}
