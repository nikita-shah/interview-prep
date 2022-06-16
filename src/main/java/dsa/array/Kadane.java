package dsa.array;
//this solution is famous for maximum subarray sum

public class Kadane {
    public int maxSubArray(int[] nums) {

        //loop through the array, counting the subarray.
        //when the subarray sum becomes negative, start a new sub array, maintain max seen so far
        int ans = nums[0];
        int currSum = nums[0];
        for(int i=1;i<nums.length;i++)
        {
             currSum = Math.max(nums[i],currSum+nums[i]);
             //if currSum is negative, we will reset and start a new subarray from the current element.
             ans = Math.max(currSum,ans);
        }
        return ans;
    }
}
