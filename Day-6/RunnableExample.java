class MyTask implements Runnable {
    public void run() {
        System.out.println("Message from " + Thread.currentThread().getName());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
       
        Thread t1 = new Thread(new MyTask(), "Thread-1");
        Thread t2 = new Thread(new MyTask(), "Thread-2");


        t1.start();
        t2.start();
    }
}
