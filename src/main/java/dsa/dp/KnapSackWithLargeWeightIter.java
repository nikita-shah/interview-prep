package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapSackWithLargeWeightIter {

    ArrayList<Integer> values;
    ArrayList<Integer> weights;
    int[][]dp;

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        values = A;
        weights = B;

        int maxVal = calculateMaxValue();
        int noOfItems = values.size();


        initializeDpArray(noOfItems+1, maxVal+1);
        //we are using number of items here not index
        findMinWeightForValue( noOfItems, maxVal);

        int ans = 0;
        for(int i=maxVal;i>=0;i--)
        {
            if(dp[noOfItems][i] <= C )
            {
                ans = i;
                break;
            }
        }
        return ans;

    }

    //rows are index for the item
    //cols are value
    //dp[i][j] = min weight required to have a bag of value j from items till index i
    private void findMinWeightForValue(int row,int col)
    {
       int ifTaken;
       int ifNotTaken;

       for(int i=1;i<=row;i++)
       {
           for(int j=1;j<=col;j++)
           {
               if (j < values.get(i-1) || dp[i-1][j-values.get(i-1)] == Integer.MAX_VALUE )
                   ifTaken =  Integer.MAX_VALUE;
               else
                   ifTaken = dp[i-1][j-values.get(i-1)] + weights.get(i-1)   ;
                ifNotTaken = dp[i-1][j];
               dp[i][j] = Math.min(ifTaken,ifNotTaken);
           }
       }

    }

    private void initializeDpArray(int rows, int cols)
    {
        dp = new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            //initialize bag weight needed as infinite
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            //0 weight of bag to get a value of 0
            dp[i][0] = 0;

        }

    }

    private int calculateMaxValue()
    {
        int ans = 0;
        for(int i=0;i<values.size();i++)
        {
            ans += values.get(i);
        }
        return ans;
    }



    public static void main(String args[])
    {
        KnapSackWithLargeWeightIter prb = new KnapSackWithLargeWeightIter();
        ArrayList<Integer>values = new ArrayList<>(Arrays.asList(2, 1, 3));
        ArrayList<Integer>weights = new ArrayList<>(Arrays.asList(3, 2, 4));
        System.out.println(prb.solve(values,weights,7));
    }
}
