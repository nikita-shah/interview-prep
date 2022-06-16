/* created by nikita */
package javalang.threading.even_odd_numbers;

public class NumberPrinterMainV2 {


    public static void main(String args[]) throws InterruptedException {

        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock)
                {
                    for(int i=0; i <= 5; i++)
                    {
                        NumberPrinterV2.printNextEven();
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock)
                {
                    for(int i=0; i <= 5; i++)
                    {
                        NumberPrinterV2.printNextOdd();
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
/*
        t1.join();
        t2.join();*/
    }



}
