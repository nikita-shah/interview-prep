package dsa.bitmanipulation;

public class Divide {
    public int divide(int A, int B) {
        if(A==0) return 0;
        if(B==1) return A;

        int mul = 1;
        long ans = 0;
        long a = A;
        long b = B;
        if(a < 0)
        {
            a = a * -1 ;
            mul = mul * -1;
        }
        if(b < 0)
        {
            b = b * -1;
            mul = mul * -1;
        }

        for (int i=30;i>=0;i--)
        {
            long temp = b * (1 << i );
            if(temp > a)
            {
                continue;
            }
            else
            {
                ans = ans +   (1 << i);
                a = a - (int)temp;
            }
        }

        ans = ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans;
        ans = ans * mul;
        return (int)ans;

    }
}





