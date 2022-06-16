package dsa.slidingWindow;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//explained in -> https://www.interviewbit.com/blog/sliding-window-maximum/

public class SlidingWindowMax {

    //TC -> O(n*B) SC-> O(1)
    public int[] slidingWindowMaxBF(final int[] A, int B){
        int[]ans = new int[A.length-B+1];
        //iterate through all the N_K+1 winsows,
        //within a window iterate through all the elements and find max
        int n = A.length;
        for(int start = 0; start < n ;start++ )
        {
            int max = Integer.MIN_VALUE;
            for(int j = start; j<start+B; j++)
            {
                max = Math.max(max,A[j]);
            }
            ans[start] = max;
        }
        return ans;
    }

    //TC -> O(n) SC -> O(B) (worst case space complexity -> O(n))
    /*worst case will happen here in case when array is sorted in decreasing order*/
    public int[] slidingWindowMaxDequeue(final int[] A, int B) {
        int[]ans = new int[A.length-B+1];

        int ansIndex = 0;
        Deque<Integer> deque = new LinkedList<>();

        //Dequeue will have as its first the max of the current window ending at incoming index
        //we will iterate for end of sliding window from 0 to last element of the array
        //for each incoming index, we will calculate hte outgoing index


        for(int i=0;i<A.length;i++)
        {
            int incomingIndex = i;
            int outgoingIndex = i-B;

            //if outgoing index was at the front of queue remove it as the window will now be shifting
            if(deque.peekFirst()!=null && outgoingIndex >= 0 && deque.peekFirst() == A[outgoingIndex])
            {
                deque.removeFirst();
            }
            //remove from the end of queue all elements which are smaller than the incoming elements
            //as all these elements would never be the answer since we got a bigger better elements
            //for future windows this incoming element (which is greater than all other elements) would be the answer.
            while(deque.peekLast()!=null && (deque.peekLast() < A[incomingIndex] ))
            {
                deque.removeLast();
            }

            deque.addLast(A[incomingIndex]);

            if(i>=B-1)//atleast one window is complete
            {
                //the max of the window ending at the incoming index is the first element in the dequeue
                ans[ansIndex] = deque.peekFirst();
                ansIndex++;
            }

        }

        return ans;

    }

    //TC -> O(n) Sc -> O(n)
    public int[] slidingWindowMaxDp(final int[]A, int B){

        /*
         1. divide the array into fixed windows of size B, the last window on the right may have less number of elements
         2. have two new arrays left and right of size n
            within each window,
            populate left[i] =  max element from left end of the window to i
            populate right[i] = max element from right end of the window to i
         3. iterate for all possible start points of the window,
           start = 0 to n-k  //there will be a total of n-k+1 windows
            window from start to start+k-1(end)
            max in window =  max of (right[start], left[end])
         */

        int n =  A.length;
        int[]left = new int[n], right = new int[n], ans= new int[n-B+1];
        left[0] = A[0];
        right[n-1] = A[n-1];

        for(int start=1;start<n;start++ )
        {
            //start of any window is that index where  index%B == 0
            //end of any window is that i where index%B-1 == 0

            //to calculate the left array start from the left end of the array and look for window starts
            //at start of any window the left will be what is in the input array
            if(start%B==0)
                left[start] = A[start];
            else
                left[start] = Math.max(A[start],left[start-1]);

            //to caluclate the right array start from the right end of array and look for window ends.
            //at end of any window the right will be what is in the input array
            int end = n-1-start;
            if(end%B==B-1)
                right[end] = A[end];
            else
                right[end] = Math.max(A[end],right[end+1]);
        }

        for(int start = 0; start <= n-B;start++)
        {
            int end = start+B-1;
            ans[start] = Math.max(right[start],left[end]);
        }
        return ans;
    }


    //TC -> 0(n*k) SC -> 0(k)=> 0(n)
    public int[] slidingWindowMaxHeap(final int[]A, int B)
    {
       /*
       Heap is not an optimal solution, here we maintain a heap of the slig=ding window,
       window is of size B, when the window moves, we would have to delete the outgoing index, and insert the incoming index
       to delete the outgoing index, we would first have to search it
       for every window, -> o(k+logk)
        delete outgoing -> 0(k)
        insert incoming -> 0(logk)
        */

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = A.length;
        int[]ans = new int[n-B+1];
        for(int i=0;i<A.length;i++) {
            int incomingIndex = i;
            int outgoingIndex = i - B;

            maxHeap.add(A[incomingIndex]);

            if (outgoingIndex >= 0)
                maxHeap.remove(A[outgoingIndex]);

            //atleast one window is completed
            if (i  >= B-1)
                ans[i-B+1] = maxHeap.peek(); //or could track a separate index like in the first solution
        }
        return ans;

    }

}
