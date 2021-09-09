class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            public synchronized void run() {
                for (var i = 1; i <= 1000; i++) {
                    c.increment();
                    System.out.println(" Count1 " + c.count);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public synchronized void run() {
                for (var i = 1; i <= 1000; i++) {
                    c.increment();
                    System.out.println(" Count2 " + c.count);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // System.out.println("Count" + c.count);
    }
}
