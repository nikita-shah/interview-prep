package dsa.binarySearch;

//I tried to dry run this solution for duplicates and found it to be working well
// can do more ehaustive dry run later.

public class RotatedSortedArraySearch {


    //simple logic

    //if (A[start] <  A[mid]) left part of mid is in ascending order, search element here like binary search
    //if not found move to right


    //if (A[start] > A[mid]) right part of mid is in asending order, search element here like binary search
    //if not found move to left
    public int search(final int[] A, int B) {

        int n = A.length-1;
        int start = 0;
        int end = n;
        int mid;

        while(start<=end){

            mid = (start+end)/2;

            if (A[mid]==B) return mid;

            if(A[start]<=A[mid]){
                if(B >= A[start] && B < A[mid])
                {
                    //move left
                    end = mid -1;
                }
                else
                {
                    //move right
                    start = mid+1;
                }
            }
            else if (A[start]>A[mid])
            {
                if(B > A[mid] && B <= A[end])
                {
                    //move right
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
        }
        return -1;
    }



    //COMPLICATED LOGIC, first find the point of rotation and then do
    //normal binary search on either half of the array.

    //FOR WRITING CODE OF THIS QUESTION ALWAYS TAKE EXAMPLE AND WRITE.

    private static int findNumIndex(int[]A, int x)
    {
            int rotatnPt = findIndexRotation(A);
            int start=0;
            int end=A.length-1;

            if(rotatnPt!=-1)
            {
                if(x >= A[0])
                {
                    end = rotatnPt -1;
                }
                else
                {
                    start = rotatnPt;
                }
            }

            int mid = (start+end ) /2;

            while(start<=end)
            {
                mid = (start+end) /2;
                if(A[mid] == x)
                {
                    return mid;
                }
                if(x > A[mid])
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
            return -1;
        }

    private static int findIndexRotation(int[]A)
    {
            //point of rotation is such point that the number before it is bigger than it
            //when we land on mid, we should compare mid with both sides to check if mid or the one after it is point of rotation
            int start = 0;
            int end = A.length-1;
            int mid = (start+end ) /2;

            while(start<=end)
            {
                mid = (start+end ) /2;
                if(A[mid] < A[mid-1]) return mid;
                if(A[mid] > A[mid+1]) return mid+1;
                if(A[start] < A[mid]) start = mid+1;
                else if (A[end] > A[mid]) end = mid-1;
            }
            return -1;
        }

    public static void main (String[] args) throws Exception
    {
        // your code goes here
        int[]A = {4,5,1,2,3};
        int[]B = {5, 6, 7, 8, 9, 10, 1, 2, 3} ;
        int[]C = { -1, 0, 1,-2};
        //System.out.println(Codechef.findIndexRotation(A));
        System.out.println(RotatedSortedArraySearch.findNumIndex(A,3));
        System.out.println(RotatedSortedArraySearch.findNumIndex(B,3));
        System.out.println(RotatedSortedArraySearch.findNumIndex(C,-2));
        //	System.out.println(Codechef.findIndexRotation(C));

    }

}

