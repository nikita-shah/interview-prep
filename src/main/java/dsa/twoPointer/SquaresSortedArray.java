package dsa.twoPointer;
//PROBLEM -> https://leetcode.com/problems/squares-of-a-sorted-array/
/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
 */


public class SquaresSortedArray {

    public int[] sortedSquares(int[] nums) {

        int n = nums.length, left = 0, right = n-1, resultIndex = n-1;
        int[]ans = new int[n];


      /*
      we are filling the result array from the highest number,
      as we know the highest number will be the right most or left most,
      lowest however could lie somewhere in between.
      */

        while(left <=right)
        {
            if(Math.abs(nums[left]) < Math.abs(nums[right]))
            {
                ans[resultIndex] = nums[right]*nums[right];
                right--;
            }
            else
            {
                ans[resultIndex] = nums[left]*nums[left];
                left++;
            }
            resultIndex--;
        }
        return ans;
    }
}
