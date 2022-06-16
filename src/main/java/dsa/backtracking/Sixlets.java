package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
/*
check back tracking  class held later, there is no need to have count as the global variable.
we do not need to maintain the count
we can return it.
check for back tracking class notes in the spiral book

PSUEDO CODE
Q -> find count of subsets which has sum = k, given an array of n integers

int sub(int i, int n, int k, int sum, int[]arr)
{
  if(i==n)
  {
    //we have reached the leaf node of one of the paths of the recursive tree..
    if(sum==k)
     return 1; //meaning current path will be one of the subsets to be counted
    return 0;
  }

  //need to explore paths for the element arr[i]

  //take arr[i] in the subset
  sum=sum+arr[i]
  x = sub(i+1,n,k,sum,arr);

  //do not take arr[i] in the subset
  sum=sum-arr[i]
  y = sub(i+1,n,k,sum,arr)

  //return number of subsets in the path by both either taking or not taking the arr[i]
  return x+y;
}

 */
public class Sixlets {
    int count = 0;
    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> subsequence = new ArrayList<>();
        sixlets(subsequence,0,A,B,0);
        return count;
    }

    public void sixlets(ArrayList<Integer> subsequence,int sum,ArrayList<Integer> A,int B,int index)
    {
        if(subsequence.size()==B )
        {
            //we have generated 1 valid subsequence
            if(sum <=1000)
            count++;
            return;
        }

        if(index < A.size())
        {
            //take the element at A[index] in subsequence
            int newEle = A.get(index);
            subsequence.add(newEle);
            sixlets(subsequence,sum+newEle,A,B,index+1);
            //remove the element that we just added
            /* using subsequence.remove(index)
            is not appropriate as index could be way more than subsequence size.
             */
            int eleRemoved = subsequence.remove(subsequence.size()-1);
            //go ahead with other possibilities, the sum will be same as the one we got as
            //we just removed the element we had added.
            sixlets(subsequence,sum,A,B,index+1);
        }

    }

    public  static void main(String args[])
    {
        Sixlets s = new Sixlets();
        int ans = s.solve(new ArrayList<>(Arrays.asList(1,2,8)),2);
        System.out.println(ans);
    }
}
