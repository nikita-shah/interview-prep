package dsa.binarySearch;

//PROBLEM
/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
 */




// SOLUTION
/*
array -> 2,4,6,8,10
take three cases and search for 3,1,11
in all cases it is found that at the end of while loop start is the position the element must have been present.
*/

public class SearchInsertPosition {


    public int searchInsert(int[] nums, int target) {
        int n = nums.length, start = 0, end = n-1;
        while(start<=end && start >=0 && end <= n-1)
        {
            int mid = start + (end-start)/2;
            if( nums[mid] == target) return mid;
            if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return start;

    }
}