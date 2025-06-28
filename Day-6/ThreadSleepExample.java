class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted");
            }
        }
        System.out.println(name + " finished.");
    }
}

public class ThreadSleepExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.start(); 

        try {
            t1.join(); 
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        t2.start();
        try {
            t2.join(); 
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread finished after both threads completed.");
    }
}
