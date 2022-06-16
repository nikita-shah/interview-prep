package dsa.graphs;

import java.util.*;

public class Prims {
    //STRAIGHT MST
    // since the batches problem was also done via mst algo, it was actually done via disjoint set union logic
    //since disjoint set union is the main part of kruskal's algo for mst
    //will implement this using prims algo

    int[]visited;
    Map<Integer, ArrayList<WeightedEdge>> graph;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        constructGraph(A,B);

        return prims(1);

    }

    private int prims(int source)
    {
        int cost = 0;
        visited[source] = 1 ;
        PriorityQueue<WeightedEdge>  minHeap = new PriorityQueue<>();
        minHeap.addAll(graph.get(source));

        while(!minHeap.isEmpty())
        {
            WeightedEdge edge =  minHeap.poll();
            int dest = edge.dest;
            if(visited[dest]!=1)
            {
                cost += edge.weight;
                minHeap.addAll(graph.get(dest));
                visited[dest] = 1;
            }
        }
        return cost;
    }

    private void constructGraph(int A, ArrayList<ArrayList<Integer>> B)
    {
        graph =  new HashMap<>();

        visited = new int[A+1];


        for(int j=0;j<B.size();j++)
        {
            int node1 = B.get(j).get(0);
            int node2 = B.get(j).get(1);
            int weight =  B.get(j).get(2);

            ArrayList<WeightedEdge> weightedEdge1 =  new ArrayList<>(Arrays.asList(new WeightedEdge(node1,weight)));
            ArrayList<WeightedEdge> weightedEdge2 =  new ArrayList<>(Arrays.asList(new WeightedEdge(node2,weight)));

            graph.merge(node1,weightedEdge2,(oldVal, newVal)->{
                oldVal.addAll(newVal);
                return oldVal;
            });

            graph.merge(node2,weightedEdge1,(oldVal, newVal)->{
                oldVal.addAll(newVal);
                return oldVal;
            });

        }

    }

    public static void main(String args[])
    {

    }
}
class WeightedEdge implements Comparable<WeightedEdge> {
    int source;
    int dest;
    int weight;

    public WeightedEdge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public WeightedEdge(int source,int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public int compareTo(WeightedEdge o) {
        return this.weight - o.weight;
    }
}
