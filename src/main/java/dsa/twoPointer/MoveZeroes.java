package dsa.twoPointer;
//problem ->https://leetcode.com/problems/move-zeroes/submissions/

public class MoveZeroes {
    //OPTION 1
    //TC :O(n), SC= O(1),
    /*
       but in the end we write a lot of 0's  for an array 000001
       n-1 zero written

    */
    /*
    public void moveZeroes(int[] nums) {

        int lastNonZeroIndex = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != 0)
            {
                nums[lastNonZeroIndex] = nums[i];
                lastNonZeroIndex++;
            }
         }

        for(int i = lastNonZeroIndex; i< nums.length; i++)
        {
            nums[lastNonZeroIndex] = 0;
            lastNonZeroIndex++;
        }

    }
    */

    //OPTION 2
    //TC :O(n), SC= O(1), but less number of array writes

    //SOLUNTION EXPLANATION LEETCODE
    /*
    The total number of operations of the previous approach is sub-optimal. For example, the array which has all (except last) leading zeroes: [0, 0, 0, ..., 0, 1].How many write operations to the array? For the previous approach, it writes 0's n-1n−1 times, which is not necessary. We could have instead written just once. How? ..... By only fixing the non-0 element,i.e., 1.

The optimal approach is again a subtle extension of above solution. A simple realization is if the current element is non-0, its' correct position can at best be it's current position or a position earlier. If it's the latter one, the current position will be eventually occupied by a non-0 ,or a 0, which lies at a index greater than 'cur' index. We fill the current position by 0 right away,so that unlike the previous solution, we don't need to come back here in next iteration.

In other words, the code will maintain the following invariant:

All elements before the slow pointer (lastNonZeroFoundAt) are non-zeroes.

All elements between the current and slow pointer are zeroes.

Therefore, when we encounter a non-zero element, we need to swap elements pointed by current and slow pointer, then advance both pointers. If it's zero element, we just advance current pointer.

With this invariant in-place, it's easy to see that the algorithm will work.
     */

    public void moveZeroes(int[] nums)
    {

        //swap lastNonZeroIndex element with current nonZeroIndex, if not same element
        //this way you do not have to fill for zero in the end.
        for(int left =0, curr = 0; curr < nums.length;curr++)
        {
            if(nums[curr]!=0 )
            {
                if(curr!=left)
                {
                    int temp = nums[left]; //i think this would always be 0
                    nums[left] = nums[curr];
                    nums[curr] = temp;
                }
                left++;
            }
        }


    }
}
