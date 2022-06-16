package dsa.queues;


public class MainClass {
    public static void main(String args[])
    {
        //NonRepeatingCharacter nonRepeatingCharacter = new NonRepeatingCharacter();
        //String A = "ptp";
        //System.out.println(nonRepeatingCharacter.solve(A));

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(slidingWindowMaximum.slidingMaximum(new int[]{10,9,8,7,6,5,4,3,2},2));
    }
}
