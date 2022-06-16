package dsa.graphs;

import dsa.transformations.ArrayTransformer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int[][] rotTime;

    public int solve(ArrayList<ArrayList<Integer>> A)
    {
        boolean freshOrange = false;
        int ans = 0;
        int rows = A.size();
        int cols = A.get(0).size();
        int[]dx = {-1,0,1,0};
        int[]dy = {0,1,0,-1};

        Queue<MatrixPos> q = new LinkedList<MatrixPos>();

        initializeRotTime(rows,cols);

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(A.get(i).get(j)==2)
                {
                    q.add(new MatrixPos(i,j));
                    rotTime[i][j]=1;
                }
            }
        }


        while(!q.isEmpty())
        {
            MatrixPos pos = q.remove();
            for(int i=0;i<4;i++)
            {
                int newX = pos.row + dx[i];
                int newY = pos.column + dy[i];

                if( isXYValid(newX,newY,rows,cols) &&  A.get(newX).get(newY) == 1 )
                {

                    rotTime[newX][newY] = rotTime[pos.row][pos.column] + 1;
                    //add to queue as these will rot more oranges in future, hence source of bfs
                    q.add(new MatrixPos(newX,newY));
                    //rot the orange in the original matrix
                    A.get(newX).set(newY,2);
                }
            }

        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                //if any fresh orange is left in original matrix ans will be -1
                //if not ans will be max rot time in rotten matrix -1

                if( A.get(i).get(j) == 1 )
                {
                    freshOrange = true;
                }

                ans = Math.max(ans,rotTime[i][j]);

            }
        }

        if(freshOrange) return -1;
        return ans-1;

    }

    private void initializeRotTime(int rows, int cols)
    {
        rotTime = new int[rows][cols];
    }

    private boolean isXYValid(int x, int y, int rows, int cols)
    {
        return x>=0 && x < rows && y>=0 && y<cols ;
    }


    public static void main(String[]args)
    {
        RottenOranges oranges = new RottenOranges();
        int[][] input = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
    };
        ArrayList<ArrayList<Integer>>inputArrayList = ArrayTransformer.convert2dArrayToArrayList(input);
        System.out.println(oranges.solve(inputArrayList));
    }

}

class MatrixPos
{
    int row;
    int column;

    MatrixPos(int row,int column)
    {
        this.row = row;
        this.column = column;
    }
}

