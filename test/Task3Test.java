package test;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;
import main.Task3.*;

class ConcurrentDataStructureTest {

    @Test
    void testCopyOnWriteArrayList() throws InterruptedException {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        
        // Create two threads that add elements to the list
        Thread t1 = new ListThread(list);
        Thread t2 = new ListThread(list);
        
        t1.start();
        t2.start();
        
        // Wait for both threads to finish
        t1.join();
        t2.join();
        
        // Assert that the final list size is correct
        assertEquals(20, list.size(), "The list should contain 20 elements");
        System.out.println("Final List: " + list);
    }
}
