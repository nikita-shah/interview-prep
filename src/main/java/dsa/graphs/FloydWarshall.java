package dsa.graphs;
import dsa.transformations.ArrayTransformer;

import java.util.ArrayList;

public class FloydWarshall {

        ArrayList<ArrayList<Integer>>  dist;
        public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

            initializeTheDist(A);

            for(int interNode = 0;interNode < A.size();interNode++)
            {
                for (int i=0;i<A.size();i++)
                {
                    for(int j=0;j<A.size();j++)
                    {
                        int currentDistance =  dist.get(i).get(j)==-1?Integer.MAX_VALUE: dist.get(i).get(j);

                        int distanceViaInter = (   dist.get(i).get(interNode) == -1
                                || dist.get(interNode).get(j) == -1  ) ? Integer.MAX_VALUE
                                : dist.get(i).get(interNode) + dist.get(interNode).get(j);

                        int min = Math.min(currentDistance, distanceViaInter);
                        int finalDist = min== Integer.MAX_VALUE ? -1 :min ;
                        dist.get(i).set(j, finalDist );
                    }
                }
            }

            return dist;

        }

        private void initializeTheDist (ArrayList<ArrayList<Integer>> A)
        {
            dist = (ArrayList<ArrayList<Integer>>) A.clone();
        }

        public static void main(String[] args) {
            int[][] input = {
                    {0, 5, -1, 10},
                    {-1, 0, 3, -1},
                    {-1, -1, 0, 1},
                    { -1, -1, -1, 0}

            };

            FloydWarshall floydWarshall = new FloydWarshall();
            ArrayList<ArrayList<Integer>>dist = floydWarshall.solve(ArrayTransformer.convert2dArrayToArrayList(input));




        }
    }

