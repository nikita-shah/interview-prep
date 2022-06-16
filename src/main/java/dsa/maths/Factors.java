/* created by nikita */
package dsa.maths;

import java.util.ArrayList;
import java.util.Comparator;

/*
Problem defination->FInd all factors of a natural number N
Sol-> a*b = N
max a, min b = sqare root of N
a, b form a pair which when multiplied give us a product of N
 */
/*youtube link with explanation -> https://www.youtube.com/watch?v=dolcMgiJ7I0&feature=emb_err_woyt
mycodeschool*/
public class Factors {
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> sol = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(Double.valueOf(A));i++)
        {
            if(A%i==0) {
                sol.add(i);
                if(i!=A/i)
                    sol.add(A/i);
            }
        }
        sol.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
            });
        return sol;
    }

    public int isPrime(int A) {
        int count = 0;
        for(int i=1;i<=Math.sqrt(Double.valueOf(A));i++)
        {
            if(A%i==0) {
               count++;
                if(i!=A/i && i!=1)
                    count++;
            }
        }
        if(count==1 && A!=1) return 1;
        else return 0;
    }

//All prime numbers till A
    public ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> sol = new ArrayList<>();
       int[] isPrime = new int[A+1];
        isPrime[0] =0;
        isPrime[1] =0;
        for(int i=2;i<=A;i++)
        {
            isPrime[i] =1;
        }
        for(int i=2; i<isPrime.length;i++)
        {
            if(isPrime[i]==1)
            {
                sol.add(i);
                for(int j=2;i*j<=A;j++)
                {
                    isPrime[i*j] = 0;
                }
            }
        }
        return sol;
    }
    public String findDigitsInBinary(int A) {
        String binRep="";
        if( A==0 || A==1) {
            binRep = String.valueOf(A);
            return binRep;
        }
        while(A>0)
        {
            if(A%2==0)
                binRep="0"+binRep;
            else binRep="1"+binRep;

            A=A/2;
        }
        return binRep;
    }

    public static void main(String args[])
    {
        Factors problem = new Factors();
        //System.out.println(problem.isPrime(41443));

        //System.out.println(problem.sieve(10));
        System.out.println(problem.findDigitsInBinary(1));
        System.out.println(problem.findDigitsInBinary(2));
        System.out.println(problem.findDigitsInBinary(3));
        System.out.println(problem.findDigitsInBinary(4));
        System.out.println(problem.findDigitsInBinary(5));
        System.out.println(problem.findDigitsInBinary(6));
        System.out.println(problem.findDigitsInBinary(7));
        System.out.println(problem.findDigitsInBinary(8));
    }

}
