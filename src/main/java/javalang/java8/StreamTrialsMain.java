package javalang.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StreamTrialsMain {

    public static void main(String args[]){
        StreamTrialsMain obj = new StreamTrialsMain();
        int[]A = {46 ,1 ,2 ,1 ,1 ,1 ,5 ,45 ,1 ,1 ,2 ,5 ,1 ,40 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,31 ,1};
        int[] ans =  obj.solve(A) ;
        System.out.println("NIki");
    }


    private void calculateGCD(ArrayList<Integer> gcdList, int newNum)
    {
        ArrayList<Integer> newGcdList = new ArrayList<>();
        gcdList.stream().mapToInt(num->gcd(num,newNum)).forEach(num->{newGcdList.add(num);});
        gcdList.addAll(newGcdList);
        gcdList.add(newNum);
    }

    int gcd (int a, int b)
    {
        if (b==0) return a;
        return gcd(b,a%b);
    }



    public int[] solve(int[] A) {

        ArrayList<Integer> ipList = new ArrayList( Arrays.asList(A));
        ArrayList<Integer> gcdList = new ArrayList<>();



        Collections.sort(ipList,Collections.reverseOrder());
        int solnSize = (int) Math.sqrt(A.length);
        int[]ans = new int[solnSize];

        ans[0]=A[A.length-1];
        gcdList.add(ans[0]);
        int ansIndex = 1;


        for(int i=A.length-2;  i>=0 && (ansIndex+1)*(ansIndex+1) <= A.length;  i--)
        {

            if(A[i]!=A[i+1] && !gcdList.contains(A[i]))
            {
                ans[ansIndex] = A[i];
                calculateGCD(gcdList,A[i]);
                ansIndex++;
            }

        }

        return ans;

    }

}
  //25 46 1 2 1 1 1 5 45 1 1 2 5 1 40 1 1 1 1 1 1 1 1 1 31 1