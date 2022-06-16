/* created by nikita */
package dsa.array;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInAnArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxTIllNow = A.get(A.size()-1);
        ans.add(maxTIllNow);

        for (int i=A.size()-2;i>=0;i--)
        {
            if(A.get(i)>maxTIllNow) {
                ans.add(A.get(i));
                maxTIllNow = A.get(i);
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        LeadersInAnArray problem = new LeadersInAnArray();
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2))));
        System.out.println(problem.solve(new ArrayList<>(Arrays.asList(1,2))));
    }
}
