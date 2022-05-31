package project;


import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class HW3Task2 {

    public static  class MyCount {

        Lock lock;
        private int count;

        public ArrayList<Integer> list  = new ArrayList<>();

        public MyCount() {
            count = 0;
            lock = new ReentrantLock();
            list.add(count);
        }

        private void countPlusOne() {
            lock.lock();
            count++;
            list.add(count);
            lock.unlock();
        }


    }

    public static class MyThreads extends Thread{

        MyCount count;

        public MyThreads(MyCount count){
            this.count = count;
        }

        @Override
        public void run() {
            count.lock.lock();
            count.countPlusOne();
            count.lock.unlock();
        }
    }


    public static void main(String[] args) {
        MyCount count = new MyCount();

        for (int i = 30 ; i>0;i--){
            MyThreads thread = new MyThreads(count);
            thread.start();
        }

        count.list.stream().forEach(s -> System.out.print(s + " "));
    }

}
