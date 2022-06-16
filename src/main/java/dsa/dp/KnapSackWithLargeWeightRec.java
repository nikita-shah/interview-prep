package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
//DID NOT WORK
/*
recursively the entire table was not getting filled
it was getting filled only on the path of the last entry not entirely
 */
public class KnapSackWithLargeWeightRec {

    ArrayList<Integer> values;
    ArrayList<Integer> weights;
    int[][]dp;

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        values = A;
        weights = B;

        int maxVal = calculateMaxValue();
        int noOfItems = values.size();


        initializeDpArray(noOfItems, maxVal+1);
        //we are passing index of item
        findMinWeightForValue( noOfItems-1, maxVal);
        // I am having to call all of them
        findMinWeightForValue( noOfItems-1, maxVal-1);
        findMinWeightForValue( noOfItems-1, maxVal-2);
        findMinWeightForValue( noOfItems-1, maxVal-3);
        int ans = 0;
        for(int i=maxVal;i>=0;i--)
        {
            if(dp[noOfItems-1][i] <= C )
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
    private int findMinWeightForValue(int row,int col)
    {

        if(row < 0 && col == 0 ) //weight for  a bag from no elements of 0 value
        {
            return 0;
        }

        if( row < 0) //weight for a bag with 0 elements of some value
        {
            return Integer.MAX_VALUE;
        }

        if(dp[row][col]!=Integer.MAX_VALUE) //if it is computed return that
        {
            return dp[row][col];
        }

        int notTake = findMinWeightForValue(row - 1, col);
        if(col >= values.get(row)) {
            int earlierWeight = findMinWeightForValue(row - 1, col - values.get(row));
            int takeEle = (earlierWeight == Integer.MAX_VALUE || values.get(row) > col) ? Integer.MAX_VALUE : earlierWeight + weights.get(row);
            dp[row][col] = Math.min(takeEle, notTake);
        }
        else
        {
            dp[row][col] = notTake;
        }

        return dp[row][col];

    }

    private void initializeDpArray(int rows, int cols)
    {
        dp = new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            //initilize bag weight needed as infinite
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
        KnapSackWithLargeWeightRec prb = new KnapSackWithLargeWeightRec();
        ArrayList<Integer>values = new ArrayList<>(Arrays.asList(2, 1, 3));
        ArrayList<Integer>weights = new ArrayList<>(Arrays.asList(3, 2, 4));
        System.out.println(prb.solve(values,weights,7));
    }
}
