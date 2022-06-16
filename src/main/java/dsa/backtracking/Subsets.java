package dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;

//not run here, check on scaler website and run this code.

/*
- all subsets to be generated in lexicographical order.
 */
public class Subsets {


    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        A.sort((num1,num2)->num1-num2);

        genSubSet(A,0,new ArrayList<>());

        Collections.sort(ans, (o1, o2) ->
        {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++)
            {
                if (o1.get(i) == o2.get(i))
                {
                    continue;
                }
                else
                {
                    return o1.get(i) - o2.get(i);
                }
            }
            return o1.size() - o2.size();
        });

        return ans;

    }

    private void genSubSet(ArrayList<Integer> A,int i,ArrayList<Integer> subset)
    {
        if(i>=A.size())
        {
            ans.add(subset);
            return;
        }

        //index i element does not get included
        genSubSet(A,i+1,new ArrayList<>(subset));

        //index i element gets included
        subset.add(A.get(i));
        genSubSet(A,i+1,new ArrayList<>(subset));

    }
}
