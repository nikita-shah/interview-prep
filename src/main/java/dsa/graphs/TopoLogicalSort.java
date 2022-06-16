package dsa.graphs;

/* for storing the nodes which are ready to visit we could use any collection like stack, queue, arraylist etc.
* min heap is used here to make sure that the sort we get is lexicographical ordered if multiple sorts were possible.
**/


import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopoLogicalSort {

    int[]indegree;
    ArrayList<ArrayList<Integer>>graph;
    PriorityQueue<Integer> readyForVisit;
    ArrayList<Integer>ans;


    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {

        constructGraph(A,B);

        for(int i=1; i< indegree.length ;i++ )
        {
            if(indegree[i] == 0)
            {
                readyForVisit.add(i);
            }
        }

        while(readyForVisit.size()!=0)
        {
            int node = readyForVisit.poll();
            ans.add(node);
            ArrayList<Integer>neighbours = graph.get(node);
            for(int j=0;j<neighbours.size();j++)
            {
                int neighbour = neighbours.get(j);
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                {
                    readyForVisit.add(neighbour);
                }
            }

        }
        return ans;

    }

    private void constructGraph(int A, ArrayList<ArrayList<Integer>> B)
    {
        indegree = new int[A+1];
        graph = new ArrayList<ArrayList<Integer>>();
        readyForVisit = new PriorityQueue<Integer>();
        ans = new ArrayList<Integer>();

        for(int i=0;i<=A;i++ )
        {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<B.size();i++)
        {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);

            graph.get(from).add(to);
            indegree[to]++;
        }
    }
}
