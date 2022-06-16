package dsa.graphs;


import dsa.transformations.ArrayTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//DISJOINT SET UNION CONCEPT USED -> which is part of kruskals algorith for MST

//PROBLEM FROM SCALER
/*
Problem Description

A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.



Problem Constraints

1 <= A <= 105

1 <= M <= 2*105

1 <= B[i] <= 104

1 <= C[i][0], C[i][1] <= A

1 <= D <= 109



Input Format

The first argument given is an integer A.
The second argument given is an integer array B.
The third argument given is a matrix C.
The fourth argument given is an integer D.



Output Format

Return the number of batches selected in IB.



Example Input

Input 1:

 A = 7
 B = [1, 6, 7, 2, 9, 4, 5]
 C = [  [1, 2]
        [2, 3]
       `[5, 6]
        [5, 7]  ]
 D = 12
Input 2:

 A = 5
 B = [1, 2, 3, 4, 5]
 C = [  [1, 5]
        [2, 3]  ]
 D = 6


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 Initial Batches :
    Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
    Batch 2 = {4} Batch Strength = 2
    Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
    Selected Batches are Batch 1 and Batch 2.
Explanation 2:

 Initial Batches :
    Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
    Batch 2 = {2, 3} Batch Strength = 5
    Batch 3 = {4} Batch Strength = 4
    Selected Batch is only Batch 1.
 */


public class Batches {
        // this can be solved with the help of disjoint set union.
        // C would be like edges

        int[]group;


        public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {

            int ans = 0;
            Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();

            group = new int[A+1];
            for(int i=0;i<=A;i++)
            {
                group[i] = i;
            }

            for(int i=0;i<C.size();i++)
            {
                int friend1 = C.get(i).get(0);
                int friend2 = C.get(i).get(1);

                int group1 = findGroup(friend1);
                int group2 = findGroup(friend2);

                if(group1 != group2)
                {
                    group[group1] = group2;
                }

            }

            // now group array has the group heads for each person
            //iterate through it, and count occurences in another array of map


            for(int i=1;i<group.length;i++)
            {
                // the group array is not necessary containing the final group heads of all people
                // it mmight be at an intermmediate state
                // in this example group head of 1 is 4 and that of 4 is 6 and that of 6 is 9
                // we resolve that and do path compression only if we happen to call findRoot again..
                // if find root is not called again, there is no path copression.
                int groupHead = findGroup(i);
                hmap.merge(groupHead,B.get(i-1),(oldCount,strengthOfi)-> oldCount+strengthOfi);

            }

            for(Map.Entry<Integer,Integer>entry : hmap.entrySet())
            {
                if(entry.getValue() >= D)
                {
                    ans++;
                }
            }

            return ans;
        }


        private int findGroup(int x)
        {
            if (group[x] == x )
                return x;

            group[x] = findGroup(group[x]);

            return group[x];
        }

        public static void main(String args[])
        {
            Batches b =  new Batches();
            int[] strength = new int[] {10, 8, 2, 3, 4, 8, 3, 5, 9};
            ArrayList<Integer> strengthList = new ArrayList<>(Arrays.stream(strength).boxed().collect(Collectors.toList()));
            int[][] relationships = {
                    {1, 4},
                    {1, 6},
                    {2, 7},
                    {2, 9},
                    {3, 5},
                    {3, 8},
                    {4, 9},
                    {5, 8},
                    {6, 8}
            };
            System.out.println(b.solve(9,strengthList , ArrayTransformer.convert2dArrayToArrayList(relationships),26));

        }
    }
