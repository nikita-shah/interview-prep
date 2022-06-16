package dsa.dp;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
when I was trying it out I was trying in a way in which dp[i] would represent
lis starting with i where the element at index i had 2 choices,
but here even though the choice is there, we actually have to iterate over the entire of array seen so far
as we have to make sure that the subsequence selected is longest incresing sub sequence.
so point to note is it gets solved by thinking of dp[i] as longest increasing subsequence ending at i
 */
public class LongestIncreasingSubSequence {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    int[]dp;
    public int lis(final List<Integer> A) {
        dp = new int[A.size()];
        //an element by itself is always a lis of size 1
        Arrays.fill(dp,1);
        solveLis(A,1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<dp.length;i++)
        {
            ans = Math.max(ans,dp[i]);
        }
        return ans ;
    }

    private void solveLis (final List<Integer> A,int index)
    {
        if(index == A.size())
            return;
        for(int i = 0;i<index;i++ )
        {
            if(A.get(i) < A.get(index))
            {
                dp[index] = Math.max(dp[index],dp[i]+1) ;
            }
        }

        solveLis(A,index+1);

    }


    public static void main(String[]args)
    {
        LongestIncreasingSubSequence prob =  new LongestIncreasingSubSequence();
        int[] arr = {30, 92, 22, 48, 52, 64, 92, 50, 85, 38, 97, 15, 14, 75, 59, 46, 74, 6, 95, 67, 86, 88, 25, 49, 67, 69, 50, 99, 83, 49, 60, 6, 90, 1, 50, 41, 57, 18, 36, 5, 44, 100, 23, 33, 52, 11, 46, 49, 34, 27, 77, 57, 93, 82, 38, 95, 6, 51, 100, 32, 11, 26, 50, 3, 55, 39, 84, 54, 44, 75, 76, 51, 21, 40, 28, 50, 30, 6, 84, 58, 76, 42, 35, 49, 98, 49, 13, 101, 3, 1, 60, 48, 99, 70};
        int[] arr1 = {0 ,8 ,4 ,12  ,2  ,10 ,10};
        int[]arr2 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        List<Integer> arrList = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println(prob.lis(arrList));
    }

}
