/* created by nikita */
package dsa.array;

/*
Problem Description

There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.



Problem Constraints
1 <= N <= 1000

1 <= B <= 1000



Input Format
First argument is an integer array A where A[i] is either 0 or 1.

Second argument is an integer B.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.

A = [ 0, 0, 1, 1, 1, 0, 0, 1].
B = 3

ans -> 2
In the first configuration, Turn on the lights at 3rd and 8th index.
Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
 */

/*
check as some comment suggested this to be a variation of
"Variation of the minimum intervals required problem"
 */


import java.util.ArrayList;
import java.util.Arrays;

public class MinLightsRequired {
    public int solve(ArrayList<Integer> A, int B) {

        int count = 0;
        for(int i=0;i<A.size();)
        {
            boolean isIlightable =false;

                //find the right most  to light ith position
                for(int j=i+B-1; j<A.size()&&j>i ;j--)
                {
                    if(A.get(j)==1) {
                        isIlightable = true;
                        count++;
                        i=j+B;
                        break;
                    }
                }
                //if right most not found check if any left side light can solve its purpose ..
                if(!isIlightable)
                {
                    for(int j = i-1; j>=i-B+1&&j>=0;j--)
                    {
                    if(A.get(j)==1) {
                        isIlightable = true;
                        count++;
                        i=j+B;
                        break;
                    }
                    }
                }

                if(!isIlightable && A.get(i)==1)
                {
                    isIlightable = true;
                    count++;
                    i=i+B;
                }
                //if both are not satisfied return -1
                if(!isIlightable) return -1;
        }
        return count;
    }

    public static void main (String args[])
    {
        MinLightsRequired problem = new MinLightsRequired();
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 0, 0, 1)),3));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(0, 0, 1, 1)),2));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList( 1, 1, 1, 1)),3));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList( 1, 1, 1)),6));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 1)),1));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0, 0)),4));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0 )),12));
    }
}
