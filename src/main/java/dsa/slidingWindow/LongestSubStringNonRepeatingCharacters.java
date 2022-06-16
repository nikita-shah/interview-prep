package dsa.slidingWindow;

import java.util.Arrays;

public class LongestSubStringNonRepeatingCharacters {

    //write brute force later


    /*

    int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    int[128] for ASCII
    int[256] for Extended ASCII

     */
    public int lengthOfLongestSubstringSlidingWindow(String s) {

        int ans = 0, left = 0, right = 0;

        //why 128 I am not sure of
        int[] charCount = new int[128];

        while(right<s.length())
        {
            char r = s.charAt(right);
            charCount[r]++;

            //while is necessary as we would want to start from the point after there are no more duplictes left
            // in the optimized approach, we store indices in the charCOunt array,
            // and we directly start from the index next to the elarlier foud location of the repeating character at right
            while(charCount[r] > 1 )
            {
                char l = s.charAt(left);
                charCount[l]--;
                left ++;
            }

            ans = Math.max(ans, right-left+1);
            right++;
        }

        return ans;
    }


    public int lengthOfLongestSubstringSLidingWindowOptimized(String s) {

        int ans = 0, left = 0, right = 0;

        //why 128 I am not sure of
        int[] charIndex = new int[128];
        Arrays.fill(charIndex,-1);
        while(right<s.length())
        {
            char r = s.charAt(right);
            int earlierIndexOfR = charIndex[r];

            if(earlierIndexOfR != -1 && earlierIndexOfR >= left && earlierIndexOfR < right)
            {
                //the character pointed to by right was earlier found in the window being considered
                //start the next window with the character next to where the repeating character was found earlier
                left = earlierIndexOfR + 1;
            }

            charIndex[r] = right;

            ans = Math.max(ans, right-left+1);
            right++;
        }

        return ans;
    }


}
