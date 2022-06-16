package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        trySudoku(a,0);

    }

    private Boolean trySudoku(ArrayList<ArrayList<Character>> a, int index)
    {
        int n = a.size();
        if(index == 81 )
        {
            //solution found return
            return true;
        }
        //check if the index cell is empty or not
        int row = index/9;
        int col = index%9;
        boolean ans = false;
        if(a.get(row).get(col)-'.'!=0)
            return trySudoku(a,index+1);

        //iterate for all possible values of x at this index
        for(int i=1;i<=9;i++)
        {
            if(isXValid(row,col,i,a))
            {
                //place x at this row col and move ahead
                a.get(row).set(col,(char)('0'+i));
                ans = ans || trySudoku(a,index+1);
            }

        }
        //if after everything tried so far, the ans is false
        //we need to back track so set the char to .
        if(!ans)
        a.get(row).set(col,'.');
       return ans;

    }

    private boolean isXValid(int row, int col, int x, ArrayList<ArrayList<Character>> a)
    {
        int n = a.size();
        boolean isValid = true;
        // check in row
        for(int i=0;i<9;i++)
        {
            if(a.get(row).get(i)-'0'==x)
            {
                isValid = false;
                break;
            }
        }

        //check column
        for(int i=0;i<9;i++)
        {
            if(a.get(i).get(col)-'0'==x)
            {
                isValid = false;
                break;
            }
        }

        //check sub matrix
        int startingRow = row-row%3;
        int startingCol = col-col%3;
        for(int i = startingRow; i < startingRow+3;i++ )
        {
            for(int j= startingCol;j<startingCol+3;j++)
            {
                if(a.get(i).get(j)-'0'==x)
                {
                    isValid = false;
                    break;
                }
            }
        }

        return isValid;

    }

    public static void main(String args[])
    {
        Sudoku sudoku = new Sudoku();
        ArrayList<String> scalerInput = new ArrayList<>(Arrays.asList(
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        ));
        ArrayList<ArrayList<Character>> thisCodeInput = sudoku.convertScalerInput(scalerInput);
        sudoku.solveSudoku(thisCodeInput);
        sudoku.printSudoku(thisCodeInput);
    }

    private ArrayList<ArrayList<Character>> convertScalerInput (ArrayList<String> input)
    {
        ArrayList<ArrayList<Character>> ans =  new ArrayList<>();
        for(int i=0;i<input.size();i++)
        {
            String row = input.get(i);
            ArrayList<Character>rowCharc = new ArrayList<>();
            for(int j = 0;j<row.length();j++)
            {
                rowCharc.add(row.charAt(j));
            }
            ans.add(rowCharc);
        }
        return ans;
    }

    private void printSudoku(ArrayList<ArrayList<Character>> sudoku)
    {
        for(int i=0;i<9;i++)
        {
            System.out.println();
            for(int j=0;j<9;j++)
            {
                System.out.print(sudoku.get(i).get(j));
            }
        }
    }

}
