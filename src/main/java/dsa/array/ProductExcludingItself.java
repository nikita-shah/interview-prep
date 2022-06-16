package dsa.array;

//given an array return an array of product of all elements, excluding itself.
public class ProductExcludingItself {
    public static void main(String args[])
    {
        int[]A = {2,3,4};
        int n = A.length;
        int[] left = new int[n],right = new int[n], ans = new int[n];


        left[0] = A[0];
        right[n-1] = A[n-1];
        for(int i=1,j=n-2;i<A.length;i++,j--)
        {
            left[i] = left[i-1] * A[i];
            right[j] = right[j+1] * A[j];
        }

        ans[0]=right[1];
        ans[n-1] = left[n-2];
        for(int i=1;i<n-1;i++)
        {
            ans[i] = left[i-1]*right[i+1];
        }

        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }

    }

}
