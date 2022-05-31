package project;

import static java.lang.Thread.sleep;

public class Hw3Task1 {

    public static class MyThread extends Thread {
        String word;
        Print lock;
        int count  = 10;

        public MyThread(String word, Print lock){
            this.word = word;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = count; i > 0 ; i-- ){
                lock.print(word, i);
            }
        }


    }

    public static class Print {
        public synchronized void print(String word, int i){
            System.out.println(word);
            notifyAll();
            try {
                if (i!=1) {
                    wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
    }

    public static void main(String []args) throws InterruptedException {

        Print lock = new Print();

            Thread thread1 = new MyThread("ping", lock);
            thread1.start();
            sleep(100);
            Thread thread2 = new MyThread("pong", lock);
            thread2.start();

        }
}
