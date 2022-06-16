package javalang.threading.basics.eg.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinterExecutorExample {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        for(int i=0;i<100;i++)
        {
            Thread t = new Thread(new NumberPrinter(i));
            executor.execute(t);
        }
    }
}
