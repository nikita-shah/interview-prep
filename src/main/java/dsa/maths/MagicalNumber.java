package dsa.maths;

public class MagicalNumber {

    public int solve(int A, int B, int C) {

        /* search space 1 to a*(min(b,c))
        number of elements till x divisible by b = floor(x/b)
        number of elements till x divisible by c = floor(x/c)
        number of elements till x divisible by b&c = floor(x/lcm(b,c))
        lcm(b,c)*gcd(b,c) = b*c;
        */

        long gcdBC = gcd(B,C);
        long lcm = B*C/gcdBC;
        long start = 1;
        long end = 1L*A*Math.min(B,C);
        long mid;
        int modVal = (int)1e9+7;
        while(start<=end)
        {
            mid = (start+end)/2;
            if(countDivisibleByEither(B,C,mid,lcm) == A)
            {
                //our answer has to be divisible by either b or c or both.
                //our answer will the closest number smaller to or equal to mid
                //which is divisible by either b or c or both
                if (mid%B==0 || mid%C==0)
                    return (int)(mid%modVal);
                if (mid%B < mid%C)
                {
                    return (int)((mid-mid%B)%modVal);
                }
                return (int)((mid-mid%C)%modVal);
            }
            else if(countDivisibleByEither(B,C,mid,lcm) < A)
            {
                //move right
                start = mid+1;
            }
            else
            {
                //move left
                end = mid-1;
            }

        }
        return -1;

    }

    long countDivisibleByEither(long b,long c, long x, long lcm)
    {

        long divisibleByB = x/b;
        long divisibleByC = x/c;
        long divisibleByBoth = x/lcm;
         System.out.println("b:"+b+"c"+c+"x"+x+"lcm"+lcm);
        return divisibleByB+divisibleByC-divisibleByBoth;

    }

    private int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}


