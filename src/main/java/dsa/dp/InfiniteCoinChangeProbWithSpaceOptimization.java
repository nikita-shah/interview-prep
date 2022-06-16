package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class InfiniteCoinChangeProbWithSpaceOptimization {
    public int coinchange2(ArrayList<Integer> A, int B) {
        int modVal = (int)1e6+7;
        /*
        coin denominations available till ith index.
        for j value how many ways are possible
        dp[i][j] = dp[i][j-value[i]] (ith index con was used, so prerequisite here is j>=value[i]) + dp[i-1][j]
        we can see it needs same col above row, some cols from the same row
        if we start filling from left and over writing,  we can do with only id array for dp
        */



        long[]dp = new long[B+1];
        //you get 0 value from any number of coins in one way, you do not select the coin.
        dp[0] = 1;
        for(int i=0;i<A.size();i++)
        {
            for(int j=1;j<=B;j++)
            {
                if(j >= A.get(i))
                {
                    dp[j] = dp[j]+dp[j-A.get(i)];
                }
            }
        }

        return (int) (dp[B]%modVal);

    }

    public static void main(String[]args)
    {
        InfiniteCoinChangeProbWithSpaceOptimization prb = new InfiniteCoinChangeProbWithSpaceOptimization();
        int ans = prb.coinchange2(new ArrayList<>(Arrays.asList(1,2,3)),4);
        System.out.println(ans);
    }
}
