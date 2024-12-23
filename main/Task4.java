package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Task4 {

    // BankAccount class that uses AtomicInteger for thread-safe balance manipulation
    public static class BankAccount {
        private AtomicInteger balance = new AtomicInteger(1000); // Initial balance is 1000

        // Method to deposit an amount into the account
        public void deposit(int amount) {
            balance.addAndGet(amount); // Atomically adds the amount to balance
        }

        // Method to withdraw an amount from the account
        public void withdraw(int amount) {
            if (balance.get() >= amount) {
                balance.addAndGet(-amount); // Atomically subtracts the amount from balance
            }
        }

        // Method to get the current balance
        public int getBalance() {
            return balance.get(); // Returns the current balance
        }
    }

    // ClientThread class that simulates a client making random deposits and withdrawals
    public static class ClientThread extends Thread {
        private BankAccount account;

        public ClientThread(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int amount = (int)(Math.random() * 100); // Random amount between 0 and 99
                if (Math.random() > 0.5) {
                    account.deposit(amount); // Perform a deposit
                    System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
                } else {
                    account.withdraw(amount); // Perform a withdrawal
                    System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
                }
                try {
                    Thread.sleep(50); // Simulate some delay between operations
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
