package dsa.twoPointer;

import java.util.Arrays;

//Find pythagorean triplets in the given array,
//print all triplets
public class PythagoreanTriplets
{
    public static void main (String[] args) throws Exception
    {
        // your code goes here
        int[] array = {3,1,4,6,5,12,13};
        PythagoreanTriplets.printTriplets(array);
    }

    private static void printTriplets(int[]input)
    {
        Arrays.sort(input);

        for(int c=0;c<input.length;c++)
        {
            int reqSum = (int)Math.pow(input[c],2);
            int fp = 0;
            int sp = input.length-1;
            while(fp<sp)
            {
                int currSum = (int)Math.pow(input[fp],2)+ (int)Math.pow(input[sp],2);
                if(currSum == reqSum)
                {
                    System.out.println("a: "+input[fp]+" b: "+input[sp]+" c: "+input[c]);
                    break;
                }
                else if(currSum < reqSum)
                {
                    fp++;
                }
                else{
                    sp--;
                }
            }
        }
    }

}
