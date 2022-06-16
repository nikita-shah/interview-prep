package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEdgesToRetainBiPartite {

    ArrayList<ArrayList<Integer>>graph;
    int modVal  = (int)1e9+7;
    int[]visited;


    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int color1 = 0;
        int color2 = 0;
        constructGraph(A,B);
        bfs(A,B);

        for(int i=0;i<=A;i++)
        {
            if(visited[i]==1)
            {
                color1++;
            }
            else if(visited[i]==2)
            {

                color2++;
            }
        }

        long ans =  (color1 * color2 ) - B.size();
        return (int)(ans%modVal);

    }

    //assume undirected graph
    private void constructGraph(int A,ArrayList<ArrayList<Integer>> B)
    {
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new int[A+1];


        for(int i=0 ; i<=A ; i++)
        {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<B.size();i++)
        {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);

            graph.get(from).add(to);
            graph.get(to).add(from);

        }
    }

    private void bfs (int A,ArrayList<ArrayList<Integer>> B)
    {

        Queue<Integer> q = new LinkedList<Integer>();

        //let us start from 1
        /*
        visited 0 -> not visited
        visited 1-> visited with color 1
        visited 2-> visited with color 2
        using level%2+1 to get the colours
         */
        int level = 1;
        q.add(1);
        q.add(null);
        visited[1] = 1;

        while(!q.isEmpty())
        {
            Integer x = q.remove();
            if(x==null)
            {
                //end of a level
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    level++;
                    q.add(null);
                }
            }
            else
            {

                ArrayList<Integer>neighbours = graph.get(x);
                for(int j=0;j<neighbours.size();j++)
                {
                    int nextNode = neighbours.get(j);
                    if(visited[nextNode] ==0 )
                    {
                        q.add(nextNode);
                        visited[nextNode] = level%2+1;
                    }
                }
            }
        }

    }



    public static void main(String[]args)
    {
        NumberOfEdgesToRetainBiPartite prb = new NumberOfEdgesToRetainBiPartite();
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<>(Arrays.asList(2,1)));
        System.out.println(prb.solve(2,input));
    }

}
