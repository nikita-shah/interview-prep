/* created by nikita */
package dsa.bitmanipulation;

//https://leetcode.com/problems/counting-bits/

public class CountingBits {



    public static void main(String args[])
    {
       int n = 2;

        int maxLength = 0;
        for(int num = n; num>0;)
        {
            maxLength++;
            num = num/2;
        }



        for (int i=2;i<=n;i++)
        {
            int countNum1 = 0;
            for(int j = maxLength; j >=0 ;j--)
            {
                if( (1<<j & i) > 0)
                    countNum1++;
            }
            System.out.println(countNum1);

        }

        System.out.println(1<<2);
        System.out.println(1<<1);
        System.out.println(1<<0);
        System.out.println("-----------------");
        System.out.println(1<<2 & 2);
        System.out.println(1<<1 & 2);
        System.out.println(1<<0 & 2);

    }

}
