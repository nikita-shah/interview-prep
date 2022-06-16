package dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Candies {

    public int candy(ArrayList<Integer> A) {
        int ans = 0;
        ArrayList<Integer>candies = new ArrayList<>();
        candies.add(1);

        //L to R
        for(int i=1;i<A.size();i++)
        {
            //compare A[i] with A[i-1] and assign candies

            if(A.get(i)>A.get(i-1))
            {
                candies.add(candies.get(i-1)+1);
            }
            /*
            else if(A.get(i)==A.get(i-1))
            {
                candies.add(candies.get(i-1));
            }
            */
            else
            {
                candies.add(1);
            }
        }

        //R to L
        for(int i=A.size()-1;i>0;i--)
        {
            //go from right to left
            if(A.get(i-1) > A.get(i))
            {
                if(candies.get(i-1) <= candies.get(i))
                {
                    candies.set(i-1,candies.get(i)+1);
                }
            }

        }

        //count candies
        for(int i=0;i<candies.size();i++)
        {
            ans += candies.get(i);
        }

        return ans;
    }

    public static void main(String args[])
    {
        Candies c = new Candies();
        System.out.println(c.candy(new ArrayList<>(Arrays.asList(1, 5, 2, 1))));
    }
}
