/* created by nikita */
package javalang.threading.even_odd_numbers;

public class NumberPrinter {


    public static void main(String args[]) throws InterruptedException {
        Object lockObj = new Object();
        Thread tEven = new Thread(new EvenPrinter(10,lockObj));
        Thread tOdd = new Thread(new OddPrinter(10,lockObj));

        tEven.start();
        tOdd.start();

/*

        try {
            tEven.join();
            tOdd.join();
        }catch (InterruptedException e)
        {
            System.out.println(e);
        }
*/


    }
}

class EvenPrinter implements Runnable
{

    int maxNum;
    Object lock;

    public EvenPrinter(int maxNum,Object lock)
    {
        this.maxNum = maxNum;
        this.lock = lock;
    }


    @Override
    public void run() {

        // assuming 0 is an even number this thread should print first ...
        // we dont want both threads running simultaneously
        // so we will need to use locks and Thread.sleep accordingly

        synchronized (lock)
        {
            for (int i=0;i<=maxNum;i=i+2)
            {
                System.out.println(i);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }



    }
}


class OddPrinter implements Runnable
{

    int maxNum;
    Object lock;

    public OddPrinter(int maxNum,Object lock)
    {
        this.maxNum = maxNum;
        this.lock = lock;
    }


    @Override
    public void run() {


        synchronized (lock)
        {

            for (int i=1;i<=maxNum;i=i+2)
            {
                System.out.println(i);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
