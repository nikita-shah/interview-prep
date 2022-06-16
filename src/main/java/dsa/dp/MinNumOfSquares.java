/* created by nikita */
package dsa.dp;

public class MinNumOfSquares {

    int[]minNumberSquares = new int[100000];

    public int countMinSquares(int A) {

        if ( A == 1)
            return 1;
        else if (A == 0)
            return 0;
        else if (minNumberSquares[A] !=0 )
            return minNumberSquares[A];

        int min = Integer.MAX_VALUE;
        for (int i=(int)(Math.sqrt(A));i>0;i--)
        {
            int chooseI = countMinSquares(A-i*i);
            if(chooseI<min)
            {
                min = chooseI;
            }
        }
        minNumberSquares[A] = min+1;
        return minNumberSquares[A];
    }



    public static void main(String args[])
    {
        MinNumOfSquares problem= new MinNumOfSquares();
        //System.out.println(problem.countMinSquares(13));
        System.out.println("ans -> "+problem.countMinSquares1(41));
    }


    public int countMinSquares1(int A) {

        if(A==1)
            return 1;
        else if(A==0)
            return 0;
        else if (minNumberSquares[A]!=0)
        {
            return minNumberSquares[A];
        }

        int min = Integer.MAX_VALUE;
        for(int i=(int)(Math.sqrt(A));i>0;i--)
        {
            int chooseI = countMinSquares(A-i*i);
            System.out.println("i -> "+i+" count at i -> "+chooseI);
            if(chooseI<min)
            {
                min=chooseI;
            }
        }
        minNumberSquares[A] = min + 1;
        return minNumberSquares[A];
    }

}
