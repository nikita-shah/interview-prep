package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstDFS {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    ArrayList<ArrayList<Integer>>graph;
    int[]visited;
    public int solve(ArrayList<Integer> A, final int B, final int C) {

        createGraph(A);

        dfs(C);

        return visited[B];

    }

    private void createGraph(ArrayList<Integer> A)
    {
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A.size()+1;i++)
        {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<A.size();i++)
        {
            int from = A.get(i);
            int to = i+1;
            if(from!=to)
                graph.get(from).add(to);

        }
        visited = new int[A.size()+1];
    }

    /*because of the given conditions it can be inferrred that this cannot be
    a cyclic graph, it will have to be a tree, the tree however could have self edges.
    while building the adjecency matrix, taking care to not insert the self edges.
    */
    private void dfs(int source)
    {
        ArrayList<Integer>neighbours = graph.get(source);

        for(int i=0;i<neighbours.size();i++)
        {
            int neigbour = neighbours.get(i);
            if(visited[neigbour]!=1)
            {
                //visit it , dfs on it
                visited[neigbour] = 1;
                dfs(neigbour);
            }
            else{
                //if neighbour was already visited through some node
                //this could be a case of repeating edges??
            }
        }
    }

    public static void main(String args[])
    {
        FirstDFS prb = new FirstDFS();
        ArrayList<Integer> input =  new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3, 2, 2, 7, 6));
        System.out.println(prb.solve(input,9,1));
    }
}
