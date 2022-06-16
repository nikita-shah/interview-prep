package dsa.basic;

public class SwapWithoutTemp {

    static int a = 10;
    static int b = 20;

    //will fail if a and b are too large, addition might cause overflow
    private  static void swapAddSubtract()
    {
        a = a+b;
        b = a-b;
        //b is now a and a is a+b
        a = a-b;
    }

    //will fail in case if either of a, b are 0
    private  static void swapMulDivide()
    {
        a = a*b;
        b = a/b;
        //b is now a and a is a*b
        a = a/b;
    }

    //will fail in case if either of a, b are 0
    private static void swapXor()
    {
        a = a ^ b;
        b = a ^ b;
        //b is now a and a is a^b
        a = a ^ b;
    }


    public static void main(String args[])
    {
        SwapWithoutTemp.swapAddSubtract();
        System.out.println("a:"+a+" b:"+b);

        SwapWithoutTemp.swapMulDivide();
        System.out.println("a:"+a+" b:"+b);

        SwapWithoutTemp.swapXor();
        System.out.println("a:"+a+" b:"+b);
    }
}
