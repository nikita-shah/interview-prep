package dsa.twoPointer;
/*
We initialise the slow and fast pointers i.e. slow = 0, fast = 1
Now scan the input array till fast < n.
Whenever we find a duplicate element i.e X[fast] == X[slow],
then we skip the duplicate and increment the fast by 1.
But when we encounter a unique element i.e. X[fast] != X[slow],
then we increment the slow by 1 and copy X[fast] to X[slow]. We also increment the fast by 1.
We repeat the above process until fast reaches the end of the array. Finally, we return the count of the unique element which is slow + 1. (Think!)
 */

import java.util.Arrays;

//more detailed explanation at -> https://medium.com/enjoy-algorithm/remove-duplicates-from-sorted-array-29e17a64725c
public class RemoveDuplicatesInArray {

    public static void main(String args[])
    {
        int[]array = {1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,5};
        int[] uniqueArray = RemoveDuplicatesInArray.removeDuplicates(array);
        for(int a : uniqueArray)
        {
            System.out.print(a);
        }
    }

    private static int[] removeDuplicates(int[] input)
    {
        int slowP = 0;
        int fastP = 1;
        int n = input.length;
        //the distance between slowp and fast p is filled
        // with all the repeated elements
        while(fastP < n)
        {
            if(input[slowP] != input[fastP])
            {
                slowP++;
                input[slowP] = input[fastP];
                fastP++;

            }
            else
            {
                fastP++;
            }
        }
        //original array, from(inclusive, to(exclusive))
        return Arrays.copyOfRange(input, 0, slowP+1);
        //slow pointe is pointing to the last unique number
    }
}
