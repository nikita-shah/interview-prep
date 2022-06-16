package dsa.graphs;

import dsa.transformations.ArrayTransformer;

import java.util.*;
import java.util.stream.Collectors;

public class Dijikstra {
    int[]dist;

    ArrayList<ArrayList<WeightedEdge>>graph;

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {

        constructGraph(A,B);

        dijikstra(C);

        return (ArrayList<Integer>) Arrays.stream(dist).boxed().map(i->i==Integer.MAX_VALUE?-1:i).collect(Collectors.toList());


    }

    private void dijikstra(int source)
    {
        dist[source] = 0;

        //all the edges in the min heap are a pair of
        //weight and dest. this weight is the distance from source node.

        PriorityQueue<WeightedEdge> minHeap = new PriorityQueue<>();
        minHeap.add(new WeightedEdge(source,0));

        while(!minHeap.isEmpty())
        {
            WeightedEdge minEdge = minHeap.poll();
            int weight = minEdge.weight;
            int via = minEdge.dest;
            //if we have found a better edge than how our distance matrix is currently updated to
            if(weight <= dist[via] )
            {
                //consider this option via node  and check if gives up better answer
                for(int i=0;i <graph.get(via).size();i++)
                {
                    WeightedEdge e = graph.get(via).get(i);
                    if(dist[e.dest] > dist[via] + e.weight)
                    {
                        //we have found a better route
                        dist[e.dest] = dist[via] + e.weight;
                        minHeap.add(new WeightedEdge(e.dest,dist[e.dest]));
                    }
                }
            }
        }

    }

    private void constructGraph(int A, ArrayList<ArrayList<Integer>> B)
    {
        dist = new int[A];

        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<ArrayList<WeightedEdge>>();

        for(int i=0;i<=A;i++)
        {
            graph.add(new ArrayList<WeightedEdge>());
        }

        for(int i=0;i<B.size();i++)
        {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            int weight = B.get(i).get(2);

            graph.get(from).add(new WeightedEdge(to,weight));
            graph.get(to).add(new WeightedEdge(from,weight));
        }
    }

    public static void main(String args[])
    {
        Dijikstra dijikstra = new Dijikstra();
        int[][] inputArray = {
                {0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}
        };
        ArrayList<ArrayList<Integer>> inputArrayList = ArrayTransformer.convert2dArrayToArrayList(inputArray);
        ArrayList<Integer>ans = dijikstra.solve(6,inputArrayList,4);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }

    }
}

    class Edge implements Comparable<WeightedEdge>
    {
        int weight;
        int dest;
        int source;

        Edge(int dest, int weight)
        {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(WeightedEdge o) {
            return this.weight-o.weight;
        }
    }
