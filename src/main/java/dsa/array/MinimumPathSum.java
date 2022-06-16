/* created by nikita */
package dsa.array;

import java.util.ArrayList;
import java.util.Arrays;


/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,3,8]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */


// for non duplicate entries its not a dynamic programming problem
// for duplicate entries in a row, it turns out to be dynamic


public class MinimumPathSum {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        /* ArrayList<Integer> topArray = a.get(0);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i=0;i<topArray.size();i++)
        {
            min = Integer.min(min,topArray.get(i));
            minIndex = i;
        }
        */

        int total = a.get(0).get(0);
        int innerIndex = 0;
        boolean sameNumberFlow = false;
        for (int outerIndex = 1 ;outerIndex<a.size();outerIndex++)
        {
            ArrayList<Integer> currRow =  a.get(outerIndex);

            if(!sameNumberFlow) {
                if (currRow.get(innerIndex + 1) < currRow.get(innerIndex)) {
                    innerIndex = innerIndex + 1;
                } else if (currRow.get(innerIndex + 1) == currRow.get(innerIndex)) {
                    sameNumberFlow = true;
                }
            }
            else
            {
                int aa = currRow.get(innerIndex);
                int bb =  currRow.get(innerIndex+1);
                int cc =  currRow.get(innerIndex+2);

                if(aa<=bb && aa<=cc)
                {
                    if(aa != bb && aa !=cc)
                    {
                        sameNumberFlow = false;
                    }

                }
                else if(bb<=cc)
                {
                        innerIndex = innerIndex+1;
                        if(bb !=cc)
                        {
                            sameNumberFlow = false;
                        }
                }
                else
                {
                    sameNumberFlow =false;
                    innerIndex = innerIndex+2;
                }
            }

            total += currRow.get(innerIndex);
        }
        return total;

    }



    public static void main (String args[])
    {
        MinimumPathSum problem = new MinimumPathSum();
        ArrayList<Integer>row1 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer>row2 = new ArrayList<>(Arrays.asList(3,4));
        ArrayList<Integer>row3 = new ArrayList<>(Arrays.asList(6,5,7));
        ArrayList<Integer>row4 = new ArrayList<>(Arrays.asList(4,1,8,3));
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
      //  System.out.println(problem.minimumTotal(input));


        //3 2 6 6 7 8 4

        ArrayList<Integer>row11 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer>row22 = new ArrayList<>(Arrays.asList(6,6));
        ArrayList<Integer>row33 = new ArrayList<>(Arrays.asList(7,8,4));
        ArrayList<ArrayList<Integer>> input00 = new ArrayList<>();
        input00.add(row11);
        input00.add(row22);
        input00.add(row33);
        //System.out.println(problem.minimumTotal(input00));

        //8 8 7 7 4 4 9 1 5 5 5 8 2 9 8 2 0 7 4 8 5 8 3 0 6 2 2 5 2 2 7 1 5 2 1 1 0
        ArrayList<Integer>row111 = new ArrayList<>(Arrays.asList(8));
        ArrayList<Integer>row222 = new ArrayList<>(Arrays.asList(7,7));
        ArrayList<Integer>row333 = new ArrayList<>(Arrays.asList(4 ,4, 9));
        ArrayList<Integer>row444 = new ArrayList<>(Arrays.asList(1 ,5, 5, 5));
        ArrayList<Integer>row555 = new ArrayList<>(Arrays.asList(8, 2, 9, 8, 2));
        ArrayList<Integer>row666 = new ArrayList<>(Arrays.asList(0 ,7 ,4 ,8 ,5 ,8 ));
        ArrayList<Integer>row777 = new ArrayList<>(Arrays.asList(3, 0, 6, 2, 2, 5, 2));
        ArrayList<Integer>row888 = new ArrayList<>(Arrays.asList(2 ,7, 1, 5, 2, 1, 1, 0));
        ArrayList<ArrayList<Integer>> input000 = new ArrayList<>();
        input000.add(row111);
        input000.add(row222);
        input000.add(row333);
        input000.add(row444);
        input000.add(row555);
        input000.add(row666);
        input000.add(row777);
        input000.add(row888);
        System.out.println(problem.minimumTotal(input000));

    }

}
