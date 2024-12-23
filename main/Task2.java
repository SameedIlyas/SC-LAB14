package main;

public class Task2 {

    // Counter class to be used by multiple threads
    public static class Counter {
        private int count = 0;

        // Synchronized method to increment the count safely
        public synchronized void increment() {
            count++;
        }

        // Getter method to retrieve the current count
        public int getCount() {
            return count;
        }
    }

    // CounterThread class to run in separate threads and increment the count
    public static class CounterThread extends Thread {
        private Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        // Override the run method to increment the counter 100 times
        public void run() {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        }
    }
}
