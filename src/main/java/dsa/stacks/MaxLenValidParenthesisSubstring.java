package dsa.stacks;
import java. util. *;
public class MaxLenValidParenthesisSubstring {

    /*
    problem -> given a string containing only “(“ and “)” find the longest length of valid substring of the string. (valid as in the parenthesis balancing is done)
     */

    /*
    solution -> push into the stack only when it is an opening brace (valid substring would always start with an opening brace)
    when receiving a closing brace
        if stack is empty meaning no corresponding oenign brace,
        update answer if required, rest the current count to 0

        if stack is not empty meaning there is matching brace and the substring length is increasing by 2,
        add to count and pop from stack
     */
    public static void main(String args[]) {

        Stack<Character> s = new Stack<>();

        String str = "(())";
        String str1 = "(()))((()))";
        String str3 = ")()()(";
        String str4 = "(()";
        //char[] parenthesisArray = str.toCharArray();
        //char[] parenthesisArray = str1.toCharArray();
        //char[] parenthesisArray = str3.toCharArray();
        char[] parenthesisArray = str4.toCharArray();


        int count = 0, ans = 0;;

        for(int i=0;i<parenthesisArray.length;i++)
        {
            if(parenthesisArray[i] == '(')
            {
                s.push(parenthesisArray[i]);
            }
            else
            {
                if(!s.isEmpty())
                {
                    s.pop();
                    count = count+2;
                }
                else
                {
                    ans = Math.max(ans,count);
                    count = 0;
                }
            }
        }

        ans = Math.max(ans,count);
        System.out.println(count);




    }
}

