package dsa.array;

//https://www.youtube.com/watch?v=viaha1SnpT4 -> many soln including gcd one

public class RotateArray {

    //my logic to perform in place sorting with o(n) tc


     void rotateArray(int[]nums, int k)
    {
        //one logic that came ot miy mind.
        //could not code this one.
        /*
        rotating the array to the right means that the elemts will be shifting to left and the first k elements
        will be placed in the last k position
         i-> i-k for all i >=k
         i-> i-k+n for all i <k
         */

       //another logic
       //the element at Jth position in origainl array gets replaced by the element at J+kth position, and this goes on
       // in array of length n k left rotation = n-k right rotation.
       //this code is for left rotation, generally right rotation is asked
       //so changing the k


       //NONE OF THE ABOVE COMPLEX LOGICS WERE WORKING!
       //this logic video -> https://www.youtube.com/watch?v=gmu0RA5_zxs

                int n = nums.length;
                k = k%n;
                if(k==0) return;

                //1. reverse entire array
                reverseArray(nums,0,n-1);

                //2. reverse array from 0 to k-1
                reverseArray(nums,0,k-1);

                //3. reverse array from k to n-1
                reverseArray(nums,k,n-1);
            }

            public void reverseArray(int[] input, int start, int end)
            {
                for(int i = start, j=end ; i<j ; i++,j--)
                {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }

}





