package dsa.dp;

import dsa.transformations.ArrayTransformer;

import java.util.ArrayList;
import java.util.Arrays;


/*
Like knapsack with larger weights if this has to be solved recursively,
we need to force it to fill the dp table.
iterative code is discueed in the class and is present in the notes.
 */

public class RussianDollEnvelope {

        int[]dp;
        ArrayList<ArrayList<Integer>> input;
        public int solve(ArrayList<ArrayList<Integer>> A) {
            input = A;
            sort();
            initializeDpArray();
            for(int i=0;i<input.size();i++)
                maxEnvelopes(i);
            int ans = dp[0];
            for(int i=1;i<input.size();i++)
            {
                ans = Math.max(ans,dp[i]);
            }
            return ans;
        }

        private int maxEnvelopes( int index)
        {

            if (index==-1) return 0;

            if (dp[index]!=-1) return dp[index];

            int count = 1;
            for(int i=0;i<index;i++)
            {
                if(input.get(index).get(1) > input.get(i).get(1) && input.get(index).get(0) > input.get(i).get(0))
                {
                    count = Math.max(count,maxEnvelopes(i)+1);
                }
            }
            dp[index] = count;
            return dp[index];
        }

        private void sort()
        {
            int n = input.size();

            //doing bubble sort here as n is comparative small
            for(int i=0;i<n;i++)
            {

                for(int j=0;j<n-i-1;j++)
                {
                    //compare j with j+1
                    if(input.get(j).get(0) > input.get(j+1).get(0))
                    {


                        //swap both heigth and width
                        int temp = input.get(j).get(0);
                        input.get(j).set(0,input.get(j+1).get(0));
                        input.get(j+1).set(0,temp);


                        temp = input.get(j).get(1);
                        input.get(j).set(1,input.get(j+1).get(1));
                        input.get(j+1).set(1,temp);
                    }
                }
            }

        }

        private void initializeDpArray()
        {
            dp = new int[input.size()];
            Arrays.fill(dp,-1);

        }

        public static void main(String[]args)
        {
            RussianDollEnvelope prob = new RussianDollEnvelope();
            int[][] inputArray = {
                   {6, 18}
                  ,{2, 14}
                  ,{5, 6}
                  ,{4, 15}
                  ,{8, 11}
                  ,{3, 11}
                  ,{11, 10}
                  ,{5, 11}
            };

            ArrayList<ArrayList<Integer>> input = ArrayTransformer.convert2dArrayToArrayList(inputArray);
            System.out.println(prob.solve(input));
        }
    }

