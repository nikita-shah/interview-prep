package dsa.basic;

public class PrintTest {

    public PrintTest()
    {
        System.out.println("");
    }
    public void PrintTest()
    {
        System.out.println("1");
    }

     public void testMethod()
     {
         System.out.println("2");
     }

    {
        System.out.println("3");
    }

    static{
        System.out.println("5");
    }

    public static void main(String[] args) {
        PrintTest pt = new PrintTest();
       // pt.PrintTest();
    }
}
