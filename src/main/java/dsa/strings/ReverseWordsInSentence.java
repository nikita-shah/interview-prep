package dsa.strings;

//PROBLEM
/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
and initial word order.
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInSentence {

        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String word : words)
            {
                String reversedWord = reverseWord(word.toCharArray());
                sb.append(reversedWord).append(" ");
            }
           return sb.toString().trim();
        }

        private String reverseWord(char[]wordChars)
        {
            //in substring function the from index is inclusive and the endindex is exclusive
            int left = 0, right = wordChars.length-1;
            while(left<right)
            {
                char temp = wordChars[left];
                wordChars[left] = wordChars[right];
                wordChars[right] = temp;
                left++; right--;
            }
            return String.valueOf(wordChars);
        }


    public String reverseWord2(String s) {
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            res.insert(0,s.charAt(i));
        return res.toString();
    }

        public static void main(String args[])
        {
            ReverseWordsInSentence reverseWordsInSentence = new ReverseWordsInSentence();
            String ans = reverseWordsInSentence.reverseWords("I am");
            System.out.println(ans);
        }
    }
