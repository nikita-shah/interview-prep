package dsa.stacks;

public class MainClass {

    public  static void main(String args[])
    {
/*        MaxMinDistinctNumbers maxMin = new MaxMinDistinctNumbers();
        int[]A = new int[]{2,2,3};
        System.out.println(maxMin.solve(A));
        MaxMinRepeatedNumbers maxMinRepeatedNumbers = new MaxMinRepeatedNumbers();
        int[]AR = new int[]{2,2,3};
        System.out.println(maxMinRepeatedNumbers.solve(AR));*/

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int[]A= new int[]{ 90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        System.out.println(largestRectangleInHistogram.largestRectangleArea(A));



    }
}
