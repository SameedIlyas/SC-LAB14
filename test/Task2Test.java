package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.Task2.*;

class SynchronizationTest {

    @Test
    void testSynchronization() throws InterruptedException {
        Counter counter = new Counter();
        
        // Create and start three threads that increment the counter
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);
        
        t1.start();
        t2.start();
        t3.start();
        
        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();
        
        // Assert that the final count is 300 (3 threads incrementing 100 times each)
        assertEquals(300, counter.getCount(), "Counter value should be 300");
    }
}

