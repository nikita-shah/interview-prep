package dsa.queues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] slidingMaximum(final int[] A, int B) {
            int[]ans = B>=A.length? new int[1] : new int[A.length-B+1];
            //there would be so many sliding windows
            //if windows size is bigger than the input array, ouput will contain only 1 element.
            //ouput will contain only max in the array.
            int ansIndex = 0;
            Deque<Integer> deque = new LinkedList<>();

            //int max  = Integer.MIN_VALUE;
            //calculate for the first window
            for(int i=0;i<B;i++)
            {
                while(deque.peekFirst()!=null && (deque.peekFirst() < A[i] ))
                {
                    deque.removeFirst();
                }
                deque.addLast(A[i]);

            }
            ans[ansIndex] = deque.peekFirst();
            ansIndex++;


            // i is denoting the incoming element in the window
            for(int i=B;i<=A.length-B;i++)
            {
                int incoming = A[i];
                int outgoing = A[i-B];

                while(deque.peekFirst()!=null && (deque.peekFirst() < incoming || deque.peekFirst() == outgoing)  )
                {
                    deque.removeFirst();
                }
                if(deque.peekFirst()==null || deque.peekLast() > incoming)
                {
                    deque.addLast(incoming);
                }
                ans[ansIndex] = deque.peekFirst();
                ansIndex++;

            }

            return ans;

        }

    }


