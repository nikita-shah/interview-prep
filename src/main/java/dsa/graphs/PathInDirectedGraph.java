package dsa.graphs;

import dsa.transformations.ArrayTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    Integer[]visited;


    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        buildGraph(A,B);

        bfs(1);

        return visited[A];


    }

    private void bfs(int sourceNode)
    {

        Queue<Integer> q = new LinkedList<>();
        q.add(sourceNode) ;
        visited[sourceNode] = 1;

        while(!q.isEmpty())
        {
            int x = q.remove();
            ArrayList<Integer>neighbours = graph.get(x);
            for(int i=0;i<neighbours.size();i++)
            {
                if(visited[neighbours.get(i)]!= 1)
                {
                    visited[neighbours.get(i)] = 1;
                    q.add(neighbours.get(i));
                }
            }

        }
    }

    private void buildGraph(int A, ArrayList<ArrayList<Integer>> B)
    {
        int nodes = A+1;
        visited = new Integer[nodes];
        Arrays.fill(visited,0);
        for(int i=0;i<nodes;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0 ; i<B.size();i++)
        {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            graph.get(from).add(to);

        }

    }

    public static void main(String args[])
    {
        PathInDirectedGraph prb = new PathInDirectedGraph();
        int[][] inputArray =
                {

        { 2, 1  }
        ,{ 4, 3  }
        ,{ 4, 5  }
        ,{ 2, 3  }
        ,{ 2, 4  }
        ,{ 1, 5  }
        ,{ 5, 3  }
        ,{ 2, 5  }
        ,{ 5, 1  }
        ,{ 4, 2  }
        ,{ 3, 1  }
        ,{ 5, 4  }
        ,{ 3, 4  }
        ,{ 1, 3  }
        ,{ 4, 1  }
        ,{ 3, 5  }
        ,{ 3, 2  }
        ,{ 5, 2  }
        ,{1,4} };
        ArrayList<ArrayList<Integer>> input = ArrayTransformer.convert2dArrayToArrayList(inputArray);
        System.out.println(prb.solve(5,input));

    }

}
