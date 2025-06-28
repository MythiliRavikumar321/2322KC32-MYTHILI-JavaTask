class BankAccount {
    private int balance = 1000;

        public synchronized void withdraw(int amount, String user) {
        System.out.println(user + " is trying to withdraw ₹" + amount);

        if (amount <= balance) {
            System.out.println("Processing transaction for " + user + "...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Transaction interrupted for " + user);
            }

            balance -= amount;
            System.out.println("" + user + " successfully withdrew ₹" + amount);
        } else {
            System.out.println(" " + user + " failed to withdraw. Insufficient balance.");
        }

        System.out.println(" Remaining Balance: ₹" + balance + "\n");
    }
}

class UserThread extends Thread {
    private BankAccount account;
    private int amount;

    public UserThread(BankAccount account, int amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount, Thread.currentThread().getName());
    }
}

public class BankingApp {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

                UserThread user1 = new UserThread(sharedAccount, 400, "Alice");
        UserThread user2 = new UserThread(sharedAccount, 500, "Bob");
        UserThread user3 = new UserThread(sharedAccount, 300, "Charlie"); // This one may fail if overdrawing

        
        user1.start();
        user2.start();
        user3.start();
    }
}
