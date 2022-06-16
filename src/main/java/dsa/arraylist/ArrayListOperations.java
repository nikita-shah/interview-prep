package dsa.arraylist;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListOperations {
    public static void main(String args[])
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        ArrayList<Integer> numbers1 =  new ArrayList<>();
        numbers1.addAll(numbers);
        shuffleList(numbers1);

        printList(numbers);
        printList(numbers1);

        System.out.println();
        System.out.println(numbers1.indexOf(3));

    }

    private static void shuffleList(ArrayList<Integer> numbersList)
    {

        Random random = new Random();
        for(int i=0;i<numbersList.size();i++)
        {
            int newIndex = (i+ random.nextInt(numbersList.size()))%numbersList.size();
            System.out.println(i+"   "+newIndex);
            int temp = numbersList.get(i);
            numbersList.set(i,numbersList.get(newIndex));
            numbersList.set(newIndex,temp);
        }
    }

    private static void printList(ArrayList<Integer> numbersList)
    {
        System.out.println("");
        for (int i=0;i<numbersList.size();i++) {
            System.out.print(numbersList.get(i));
            System.out.print("  ");
        }
    }
}
