package javalang.threading.basics.eg.executor;

public class NumberPrinter implements Runnable{
    int numToPrint;

    public NumberPrinter(int numToPrint)
    {
        this.numToPrint = numToPrint;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(numToPrint);
    }
}