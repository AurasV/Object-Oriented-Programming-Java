class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current balance: " + balance);
        System.out.println("-----------------------------");
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Current balance: " + balance);
            System.out.println("-----------------------------");
        } else {
            System.out.println("Overdraft!");
            System.out.println("Current balance: " + balance);
            System.out.println("-----------------------------");
        }
    }
}

public class Ex2 {
    public static void main(String[] args) {
        final BankAccount account = new BankAccount();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> account.deposit(100)).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> account.withdraw(50)).start();
        }
    }
}
