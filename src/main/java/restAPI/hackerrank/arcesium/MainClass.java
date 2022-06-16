package restAPI.hackerrank.arcesium;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws IOException {

        String[] input= new String[]{"username","EQUALS","vinayk"};
        String[] input1= new String[]{"address.city","EQUALS","Kolkata"};
        String[] input2= new String[]{"address.city","IN","Mumbai,Kolkata"};
        String[] input3= new String[]{"username","EQUALS","TOM"};
        ArrayList<Integer>idList = (ArrayList<Integer>) RestUtility.getIdForCondition(input);
        System.out.println("INPUT");
        printArrayList(idList);
        ArrayList<Integer>idList1 = (ArrayList<Integer>) RestUtility.getIdForCondition(input1);
        System.out.println("INPUT1");
        printArrayList(idList1);
        ArrayList<Integer>idList2 = (ArrayList<Integer>) RestUtility.getIdForCondition(input2);
        System.out.println("INPUT2");
        printArrayList(idList2);
        ArrayList<Integer>idList3 = (ArrayList<Integer>) RestUtility.getIdForCondition(input3);
        System.out.println("INPUT3");
        printArrayList(idList3);

    }

    private static void printArrayList(ArrayList<Integer> idList)
    {

        for(Integer id: idList)
        {
            System.out.println(id);
        }
    }
}
