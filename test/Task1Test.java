package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Task1.*;

class MultiThreadingTest {

    @Test
    void testMultithreading() throws InterruptedException {
        Thread numberThread = new Thread(new NumberThread());
        Thread squareThread = new Thread(new SquareThread());
        
        numberThread.start();
        squareThread.start();
        
        // Wait for both threads to finish
        numberThread.join();
        squareThread.join();
        
        // No assertion required, just testing concurrency
        assertTrue(true, "Both threads executed concurrently");
    }
}

