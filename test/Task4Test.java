package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.Task4.*;

class BankTransactionTest {

    @Test
    void testBankTransactions() throws InterruptedException {
        BankAccount account = new BankAccount();
        
        // Create and start three client threads that perform deposits and withdrawals
        ClientThread client1 = new ClientThread(account);
        ClientThread client2 = new ClientThread(account);
        ClientThread client3 = new ClientThread(account);
        
        client1.start();
        client2.start();
        client3.start();
        
        // Wait for all threads to finish
        client1.join();
        client2.join();
        client3.join();
        
        // Assert that the balance is correctly updated after all transactions
        // Initial balance is 1000, each thread performs random operations.
        System.out.println("Final Account Balance: " + account.getBalance());
        assertTrue(account.getBalance() >= 0, "Account balance should never be negative");
    }
}

