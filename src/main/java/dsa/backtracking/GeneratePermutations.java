package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;


//GIven an array A, gnerate all permutations of A
public class GeneratePermutations {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        //we need to pass hte index for generating the permutation,
        // pass array A, and an arraylist to store the intermediate permutation till we finish wiht 1 permutation
        genAllPer(0,A,new ArrayList<>());
        return ans;

    }

    private void genAllPer(int i,ArrayList<Integer> A,ArrayList<Integer> perm )
    {
        if(perm.size()==A.size() || i==A.size())
        {
            ans.add(new ArrayList<>(perm));
        }
        for(int j=i;j<A.size();j++)
        {
            //swap A[i], A[j]
            int temp = A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);

            perm.add(A.get(i));

            //recurse
            genAllPer(i+1,A,perm);

            //swap back
            temp = A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);

            perm.remove(perm.size()-1);

        }
    }


    public static void main(String args[])
    {
        GeneratePermutations sol = new GeneratePermutations();
        ArrayList<ArrayList<Integer>>ans = sol.permute(new ArrayList<>(Arrays.asList(1,2,3)));
        for(ArrayList<Integer>per:ans)
        {
            System.out.println();
            for(int a: per)
            {
                System.out.print(a+" ");
            }
        }
    }


}
