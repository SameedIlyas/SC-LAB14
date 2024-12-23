package main;

import java.util.concurrent.CopyOnWriteArrayList;

public class Task3 {

    // ListThread class extends Thread and adds elements to a CopyOnWriteArrayList
    public static class ListThread extends Thread {
        private CopyOnWriteArrayList<Integer> list;

        public ListThread(CopyOnWriteArrayList<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            // Add elements to the list from 0 to 9 (for each thread)
            for (int i = 0; i < 10; i++) {
                list.add(i);
                try {
                    Thread.sleep(50); // Simulate some delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
