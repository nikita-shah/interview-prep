package dsa.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(ArrayList<Integer> A) {
        int ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        while(!pq.isEmpty())
        {
            //pq could have 1 or more elements
            Integer rope1 = pq.poll();
            Integer rope2 = pq.poll();
            int join = rope1+(rope2==null?0:rope2);
            ans = ans + join;
            if(!pq.isEmpty())
            pq.add(join);
        }
        return ans;
    }

    public static void main(String args[])
    {
        ConnectRopes cr = new ConnectRopes();
        System.out.println(cr.solve(new ArrayList<>(Arrays.asList(1,18))));
    }
}


