/* created by nikita */
package dsa.array;

import java.util.ArrayList;

public class AdditionOfMaxMin {
    public int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<A.size();i++)
        {
            if(max < A.get(i))
                max = A.get(i);
            if(min > A.get(i))
                min = A.get(i);
        }
        return max+min;
    }
}
