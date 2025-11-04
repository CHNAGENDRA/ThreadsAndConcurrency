package syncronization;

public class SynchronizationTest {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        Thread thread1 = new Thread(inventoryManager, "issue");
        Thread thread2 = new Thread(inventoryManager, "receive");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current number of items in inventory: "+inventoryManager.getCount());
    }
}
