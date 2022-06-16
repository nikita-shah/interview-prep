package dsa.maths;


public class NumbersWith2PrimeFactors {
        public int solve(int A) {

            //nice video explanation.

            int ans = 0;

            //all initialized to 0
            //0 means its a prime number
            int[] sieve = new int[A+1];

            for(int i=2;i<=A;i++)
            {
                //if its a prime
                if(sieve[i]==0)
                {
                    //add count of 1 to all multiples of the found prime.
                    for(int j=i*2;j<=A;j=j+i)
                    {
                        sieve[j] = sieve[j] +1;
                    }
                }
            }

            for(int i=0; i<=A;i++)
            {
                if(sieve[i]==2)
                    ans++;
            }
            return ans;
        }


        public static void main(String args[]) {
            NumbersWith2PrimeFactors prm = new NumbersWith2PrimeFactors();
            System.out.println(prm.solve(8));
        }
    }


