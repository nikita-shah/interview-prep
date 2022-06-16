package dsa.queues;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingCharacter {
    public String solve(String A) {

        int[]freq = new int[26];

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<A.length();i++)
        {
            char streamChar =   A.charAt(i);
            freq[streamChar-'a']++;
            if( freq[streamChar-'a']  == 1)
            {
                q.add(streamChar);
            }
            char qHead = q.peek() == null ? '#' : q.peek();
            if(qHead == streamChar)
            {
                while(q.peek()!=null && freq[qHead-'a']!=1)
                {
                    q.remove();
                    qHead = q.peek() == null ? '#' : q.peek();
                }
            }

            sb.append(qHead);
        }
        return sb.toString();
    }
}




