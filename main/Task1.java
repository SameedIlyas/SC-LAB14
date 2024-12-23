package main;

public class Task1 {

    // NumberThread is an inner class of Task1
    public static class NumberThread extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100); // To simulate some delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    // SquareThread is an inner class of Task1
    public static class SquareThread extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i * i);
                try {
                    Thread.sleep(100); // To simulate some delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread numberThread = new NumberThread();
        Thread squareThread = new SquareThread();
        
        numberThread.start();
        squareThread.start();
    }
}


