package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinSumPath {

    ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {

        int rows = A.size();
        int cols = A.get(0).size();

        initializeDpArrayList(rows,cols);
        dp.get(0).set(0,A.get(0).get(0));
        solveMinSumPath(A,rows-1,cols-1);

        return dp.get(rows-1).get(cols-1);

    }

    private int solveMinSumPath(ArrayList<ArrayList<Integer>> A,int i, int j)
    {
        //base condition
        if(i == -1 || j== -1)
        {
            return Integer.MAX_VALUE;
        }

        if(dp.get(i).get(j)!=Integer.MIN_VALUE)
            return dp.get(i).get(j);

        int pathsSum = Math.min(solveMinSumPath(A,i-1,j),solveMinSumPath(A,i,j-1 ));
        int ans = A.get(i).get(j)+pathsSum ;

        dp.get(i).set(j,ans);

        return ans;
    }

    private void initializeDpArrayList(int rows, int cols)
    {
        ArrayList<Integer> defaultRow = new ArrayList<Integer>();
        for(int i =0 ;i< cols;i++)
        {
            defaultRow.add(Integer.MIN_VALUE);
        }
        for(int i=0;i<rows;i++)
        {
            dp.add(new ArrayList<Integer>(defaultRow));
        }
    }

    public static void main(String args[])
    {
        int[][]scalerArrayInput =
                {
                        {20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                        {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                        {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                        {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                        {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                        {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                        {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                        {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
                };
        ArrayList<ArrayList<Integer>> input = convert2dArrayToArrayList(scalerArrayInput);

        int[][]simpleArray =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        ArrayList<ArrayList<Integer>> simpleInput = convert2dArrayToArrayList(simpleArray);

        MinSumPath prob = new MinSumPath();
        System.out.println(prob.minPathSum(simpleInput));

    }


    private static ArrayList<ArrayList<Integer>> convert2dArrayToArrayList(int[][]array)
    {
        ArrayList<ArrayList<Integer>> input =  new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<array.length;i++)
        {
            ArrayList<Integer> row =  new ArrayList<>();
            row.addAll(Arrays.stream(array[i]).boxed().collect(Collectors.toList()));
            input.add(row);
        }
        return input;
    }
}


/*
solution submitted in scaler
 */

/*
public class Solution {
    int[][]dp;
    ArrayList<ArrayList<Integer>> A ;
    public int minPathSum(ArrayList<ArrayList<Integer>> input) {

        A = input;
        int rows = A.size();
        int cols = A.get(0).size();


        initializeDpArrayList(rows,cols);
        dp[0][0] = A.get(0).get(0);
        solveMinSumPath(rows-1,cols-1);

        return dp[rows-1][cols-1];

    }

    private int solveMinSumPath(int i, int j)
    {
        //base condition
        if(i == -1 || j== -1)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=Integer.MIN_VALUE)
        return dp[i][j];

        int pathsSum = Math.min(solveMinSumPath(i-1,j),solveMinSumPath(i,j-1 ));
        int ans = A.get(i).get(j)+pathsSum ;

        dp[i][j] = ans;

        return ans;
    }

    private void initializeDpArrayList(int rows, int cols)
    {

         dp = new int[rows][cols];
         for(int i=0;i<rows;i++)
         {
             for(int j=0;j<cols;j++)
             {
                 Arrays.fill(dp[i],Integer.MIN_VALUE);
             }
         }

    }


}

 */