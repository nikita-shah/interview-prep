/* created by nikita */
package dsa.maths;
//https://www.interviewbit.com/problems/find-nth-fibonacci/
//not understood this ... do this well 
public class FibonacciModulo {

    static final long MOD = 1000000007L;

    public int solve(int A) {
        // long prev = 0;
        // long cur = 1;
        // long nxt = 1;
        // if(A == 0) return 0;
        // if(A == 1) return 1;
        // for(int i = 0; i < A - 1; i++) {
        //     nxt = (cur + prev) % 1000000007;
        //     prev = cur;
        //     cur = nxt;
        // }

        // return (int)nxt;
        // Above approach will give TLE. Using solution from Hint 1

        if(A<=2) return 1;
        long[][] m = {{1L, 1L}, {1L, 0L}};
        long[][] resultM = matPow(m, A-1);
        long res = resultM[0][0] % MOD;
        return (int)res;
    }

    long[][] matMul(long[][] m1, long[][] m2){
        // Matrix multiplication
        long[][] ans = new long[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                long sum = 0;
                for(int k = 0; k < 2; k++) {
                    long prod = (m1[i][k] * m2[k][j]) % MOD;
                    sum = (sum + prod)% MOD;
                }

                ans[i][j] = sum;
            }
        }

        return ans;
    }

    long[][] matPow(long[][] m, int n){
        if(n==0) return new long[][]{{1L, 0L}, {0L, 1L}}; // Identity matrix. A ^ 0 = I
        long[][] halfPow  = matPow(m, n/2);
        long[][] tmp = matMul(halfPow, halfPow);

        if(n%2 == 0)
            return tmp;
        return matMul(tmp , m);
    }

    public static  void main(String args[])
    {
        FibonacciModulo problem = new FibonacciModulo();
        System.out.println( problem.solve(50) );
    }
}

 //editorial solution from interview bit
 class Solution {
    public void multiply(long F[][], long M[][])
    {
        long x =  F[0][0]% 1000000007*M[0][0]% 1000000007 + F[0][1]% 1000000007*M[1][0]% 1000000007;
        long y =  F[0][0]% 1000000007*M[0][1]% 1000000007 + F[0][1]% 1000000007*M[1][1]% 1000000007;
        long z =  F[1][0]% 1000000007*M[0][0]% 1000000007 + F[1][1]% 1000000007*M[1][0]% 1000000007;
        long w =  F[1][0]% 1000000007*M[0][1]% 1000000007 + F[1][1]% 1000000007*M[1][1]% 1000000007;

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
    public void power(long F[][], int n)
    {
        if( n == 0 || n == 1)
            return;
        long M[][] = new long[][]{{1,1},{1,0}};

        power(F, n/2);
        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);
    }
    public int solve(int A) {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (A == 0)
            return 0;
        power(F, A-1);
        F[0][0] = F[0][0] % 1000000007;
        return (int)F[0][0];
    }
}

