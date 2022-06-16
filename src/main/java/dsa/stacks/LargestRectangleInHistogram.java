package dsa.stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] A) {

        //calculate nseLeft and nseRight

        int[]nseLeft = new int[A.length];
        int[]nseRight = new int[A.length];

        long ans = 0 ;

        Stack<Integer> nseL = new Stack<>();
        Stack<Integer>nseR = new Stack<>();

        for(int i=0;i<A.length;i++)
        {
            while(!nseL.empty() && A[nseL.peek()] >= A[i])
            {
                nseL.pop();
            }
            if(nseL.empty())
            {
                nseLeft[i] = -1;
            }
            else
            {
                nseLeft[i] = nseL.peek();
            }
            nseL.push(i);
        }

        for(int i=A.length-1;i>=0;i--)
        {
            while(!nseR.empty() && A[nseR.peek()] >= A[i])
            {
                nseR.pop();
            }
            if(nseR.empty())
            {
                nseRight[i] = -1;
            }
            else
            {
                nseRight[i] = nseR.peek();
            }
            nseR.push(i);
        }

        System.out.println("NseLeft");
        for(int i=0;i<A.length;i++)
        {
            System.out.println(nseLeft[i]);
        }

        System.out.println("NseRight");
        for(int i=0;i<A.length;i++)
        {
            System.out.println(nseRight[i]);
        }

        for(int i=0;i<A.length;i++)
        {
            int left = nseLeft[i] == -1 ? i+1 :  i-nseLeft[i];
            int right = nseRight[i] == -1 ? A.length - i : nseRight[i] -i;
            int width = left+right-1;
            long area = A[i] * width;
            ans = area > ans ?  area : ans;
        }

        return (int)ans;

    }
}






