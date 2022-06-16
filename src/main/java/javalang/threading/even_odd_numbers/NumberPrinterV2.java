/* created by nikita */
package javalang.threading.even_odd_numbers;

public class NumberPrinterV2 {

    private  static final int  MAX_NUM =10;
    private static int evenTracker = -2;
    private static int oddTracker = -1;

    public static void printNextEven()
    {
        evenTracker = evenTracker+2;
        if(evenTracker<=MAX_NUM)
        System.out.println(evenTracker);
    }

    public static void printNextOdd()
    {
        oddTracker = oddTracker + 2;
        if(oddTracker <= MAX_NUM)
        System.out.println(oddTracker);
    }
}
