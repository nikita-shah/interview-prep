package javalang.threading.basics;

public class Print1to100 {
    public static void main(String[] args) {

        for (int i=0;i<100;i++) {
            //Thread t = new Thread(new HelloPrinter());
            //t.start();
            Thread tn = new Thread(new NumberPrinter(i));
            tn.start();
            if (i == 40) {
                System.out.println("debugger");
            }
        }

    }

}

class HelloPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

class NumberPrinter implements Runnable{
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