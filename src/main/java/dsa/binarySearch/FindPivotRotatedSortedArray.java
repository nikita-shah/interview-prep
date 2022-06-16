package dsa.binarySearch;

/*
the search in a sorted rotated array canalso bedone in 2 passes
1. find pivot, or the point of rotation. the element whose next element is smaller than itself
2. on both soders of pivot there is an increasingly sorted array
3. if the element to be searched is pivot we have got the answer, if not
perform binary search on both sides of the pivot.

 */
public class FindPivotRotatedSortedArray {
    /*
    we will find pivot also in binary search fashion.
    property of pivot is it is greater than the next element.
     */
    int findPivot(int[]A)
    {
        int start = 0;
        int end = A.length-1;


        while(start < end )
        {
            int mid = ( start + end ) / 2;

            if (A[mid] > A[mid + 1])
                return mid;

            if (A[mid] < A[mid - 1])
                return mid - 1;

            if (A[start] <=  A[mid])
            {
                //the left part is in increasing order and pivot would lie on right
                start = mid+1;
            }
            else
            {
                end = mid -1 ;
            }
        }

        //return -1 if pivot is not found
        return -1;
    }

    public static void main(String[] args)
    {
        int[]A = {2,3,4,5,6,7};
        FindPivotRotatedSortedArray prob = new FindPivotRotatedSortedArray();
        System.out.println(prob.findPivot(A));
    }
}
