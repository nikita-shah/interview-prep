package dsa.transformations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayTransformer {

    public static ArrayList<ArrayList<Integer>> convert2dArrayToArrayList(int[][]array)
    {
        ArrayList<ArrayList<Integer>> input =  new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<array.length;i++)
        {
            ArrayList<Integer> row =  new ArrayList<>();
            row.addAll(Arrays.stream(array[i]).boxed().collect(Collectors.toList()));
            input.add(row);
        }
        return input;
    }

    public static ArrayList<Integer> convertArrayToArrayList(int[]array)
    {
        return  (ArrayList<Integer>) Arrays.stream(array).boxed().collect(Collectors.toList());
    }

}
