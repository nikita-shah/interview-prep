package dsa.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

//since we go edge by edge in
//kruskals, I think we do not need the adjacency list here
//we can start with putting all the edges in a min Heap

public class Kruskals {
    int[] parent;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int cost = 0;

        PriorityQueue<WeightedEdge> minHeap = new PriorityQueue<>();

        for(int i=0;i<B.size();i++)
        {
            int node1 = B.get(i).get(0);
            int node2 = B.get(i).get(1);
            int weight = B.get(i).get(2);

            WeightedEdge edge = new WeightedEdge(node1,node2,weight);
            minHeap.add(edge);
        }

        for(int i=1;i<=A;i++)
        {
            //evey node is its own parent initially
            parent[i] = i;

        }

        while(!minHeap.isEmpty())
        {
            WeightedEdge e =  minHeap.poll();
            int node1 = e.source;
            int node2 = e.dest;

            int root1 =  findRoot(node1);
            int root2 =  findRoot(node2);

            if(root1!=root2)
            {
                cost += e.weight;
                parent[root1] = root2;
            }

        }
        return cost;
    }

    private int findRoot(int x)
    {
        if (parent[x]==x)
            return x;
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }
}
