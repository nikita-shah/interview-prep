package dsa.maths;

import java.util.HashSet;

//https://leetcode.com/problems/happy-number/ good explanation
public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        boolean ans = false;
        while(n!=1 && !set.contains(n))
        {
            set.add(n);
            n = calSumOfDigitSquared(n);

        }
        if (n==1 )return true;
        return false;

    }

    private int calSumOfDigitSquared(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            int digit = n%10;
            sum = sum + digit *digit ;
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        hn.isHappy(2);
    }
}