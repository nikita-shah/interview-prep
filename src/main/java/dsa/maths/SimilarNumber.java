/* created by nikita */
package dsa.maths;

public class SimilarNumber {


        public String solve(String A) {

            String similarGreaterNumber ="";
            int firstSmallestNUmber= Integer.MAX_VALUE;
            int secondSmallestNumber = Integer.MAX_VALUE;
            boolean greatestNumber =false;
            int[]inputNumber ;
            //convert input string to array of int
            for (int i=0;i<A.length();i++) {
              //  inputNumber[i] = A.charAt(i);
                if(A.charAt(i)<firstSmallestNUmber)
                {
                    firstSmallestNUmber = A.charAt(i);
                }
                if(A.charAt(i)<secondSmallestNumber && A.charAt(i)>firstSmallestNUmber)
                {
                    secondSmallestNumber = A.charAt(i);
                }
            }

            if(firstSmallestNUmber == secondSmallestNumber)
                similarGreaterNumber = "-1";

            

            for (int i=0;i<A.length()-1;i++)
            {
                if(A.charAt(i) >= A.charAt(i+1))
                    greatestNumber = true;
            }
            if(greatestNumber)
                similarGreaterNumber = "-1";

            else {

                char temp = A.charAt(0);

                for (int i = 0; i < A.length()-1; i++) {

                   // if (A.charAt(i+1)>temp)

                }

                //if smallest number is -1
                if (firstSmallestNUmber == -1 || secondSmallestNumber == -1)
                    similarGreaterNumber = "-1";
            }

            return similarGreaterNumber;
        }


}
