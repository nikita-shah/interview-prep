package javalang.threading.even_odd_numbers;
class MyThread extends Thread
{
    MyThread()
    {
        System.out.println("My thread");
    }
    @Override
    public void run()
    {
        System.out.println("run");
    }

    public void run(String s)
    {
        System.out.println("run with parameters");
    }
}

public class TestThreads {
    public static void main(String[] args) {
        Thread t = new MyThread(){
        @Override
        public void run()
        {
            System.out.println("Hi");
        }
        };
        t.start();
    }
}
