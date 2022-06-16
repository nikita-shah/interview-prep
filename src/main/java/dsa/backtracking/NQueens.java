package dsa.backtracking;

import java.util.ArrayList;

public class NQueens {

    ArrayList<ArrayList<String>>  ans = new ArrayList<ArrayList<String>>();

    public ArrayList<ArrayList<String>> solveNQueens(int A) {

        ArrayList<Integer>column = new ArrayList<>();
        ArrayList<Integer>ld = new ArrayList<>();
        ArrayList<Integer>rd = new ArrayList<>();
        ArrayList<String>  placement = new ArrayList<String>();

        for(int i=0;i<A;i++)
        {

            column.add(0);
            ld.add(0);
            ld.add(0);
            rd.add(0);
            rd.add(0);
        }


        placeNQueens(A,0,placement,column,ld,rd);

        return ans;
    }

    private void placeNQueens(int A, int row, ArrayList<String>placement,
                              ArrayList<Integer> column, ArrayList<Integer> ld, ArrayList<Integer> rd)
    {
        if(row == A)
        {
            //queens are placed and its a successful placement
            ans.add(new ArrayList<>(placement));
        }

        //iterate all columns for current row
        for(int col=0;col<A;col++)
        {
            if(column.get(col)==1 || ld.get(row-col+A)==1 || rd.get(row+col) ==1 )
            {
                continue;
            }
            String rowPlacementString = placeQueenAtColumn(col,A);
            placement.add(rowPlacementString);
            column.set(col,1);
            ld.set(row-col+A,1);
            rd.set(row+col,1);
            placeNQueens(A,row+1,placement,column,ld,rd);

            placement.remove(rowPlacementString);
            column.set(col,0);
            ld.set(row-col+A,0);
            rd.set(row+col,0);
        }


    }

    private String placeQueenAtColumn(int colIndex, int A)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<colIndex;i++)
        {
            sb.append(".");
        }
        sb.append("Q");
        for(int i=colIndex+1;i<A;i++)
        {
            sb.append(".");
        }
        return sb.toString();
    }

    public static void main(String args[])
    {
        NQueens sol = new NQueens();
        ArrayList<ArrayList<String>> ans = sol.solveNQueens(4);
        for(int i =0 ;i< ans.size();i++)
        {
            System.out.println();
            for(int j=0;j<ans.get(i).size();j++) {

                ArrayList<String> ansRow = (ArrayList<String>) ans.get(i);
                System.out.println(ansRow.get(j));
            }
        }
    }

}
