package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class KnapSackWithSmallerWeightsRec {
    int[][]dp;
    ArrayList<Integer> value;
    ArrayList<Integer> weight;
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        value = A;
        weight = B;
        int rows = value.size();
        initializeDpArray(rows,C+1);
        knapsack01( rows-1,  C);
        return dp[rows-1][C];
    }

    private int knapsack01(int index, int C)
    {
        if(index == -1 || C < 0)
        {
            return 0;
        }

        if(dp[index][C] != -1)
        {
            return dp[index][C];
        }

        if(C >= weight.get(index))
        {
            //current index can be considered
            int selectElement = knapsack01(index-1,C-weight.get(index))+value.get(index);
            int notSelectElement = knapsack01(index-1,C);
            dp[index][C] = Math.max(selectElement,notSelectElement);

        }
        else
        {
            dp[index][C] = knapsack01(index-1,C);
        }
        return dp[index][C];
    }

    private void initializeDpArray(int rows, int cols)
    {
        dp = new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            Arrays.fill(dp[i],-1);
        }
    }

    public static void main(String args[])
    {
        KnapSackWithSmallerWeightsRec prb = new KnapSackWithSmallerWeightsRec();
        ArrayList<Integer>values = new ArrayList<>(Arrays.asList(2, 1, 3));
        ArrayList<Integer>weights = new ArrayList<>(Arrays.asList(3, 2, 4));
        System.out.println(prb.solve(values,weights,7));
    }
}
