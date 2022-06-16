package dsa.array;

public class MaxNonNegativeSubarray {

    public int[] maxset(int[] A) {

        int[]PS = new int[A.length];
        PS[0] = A[0];
        for(int i=1;i<A.length;i++)
        {
            if(PS[i-1]<0 || A[i] < 0 )
                PS[i] = A[i];
            else
                PS[i] = PS[i-1]+A[i];
        }

        System.out.println("PS array");
        for(int i=0;i<A.length;i++)
        {
            System.out.println(PS[i]);
        }

        int maxInPS = 0;
        int startOFSubArray = 0;
        int endOfSubArray = -1;
        int negativeNumIndex = -1;

        for(int i=0;i<PS.length;i++)
        {
            if(PS[i]>maxInPS)
            {
                maxInPS = PS[i];
                endOfSubArray = i;
            }

            if(PS[i]==maxInPS)
            {
                // we find to find the longest subarray following this

                //max of (i-(negativeNumIndex+1)), (endOfSubArray-startOFSubArray)
                if((i-(negativeNumIndex+1)) > (endOfSubArray-startOFSubArray))
                {
                    //update to this new indexes
                    startOFSubArray = negativeNumIndex+1;
                    endOfSubArray = i;
                }
            }

            if(PS[i]<0)
            {
                negativeNumIndex = i;
            }

        }

        System.out.println("startOFSubArray:"+startOFSubArray+"endOfSubArray:"+endOfSubArray+"negativeNumIndex:"+negativeNumIndex);

        int[] ans = new int[endOfSubArray-startOFSubArray+1];
        int k=0;
        for(int i=startOFSubArray;i<=endOfSubArray;i++,k++)
        {
            ans[k]=A[i];
        }

        return ans;
    }
}
