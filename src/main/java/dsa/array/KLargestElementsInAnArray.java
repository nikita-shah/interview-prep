/* created by nikita */
package dsa.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KLargestElementsInAnArray {
        public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

            ArrayList<Integer> temp ;

            A.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            A.sort((num1,num2)->num2-num1);
          temp = new ArrayList<Integer>(A.subList(0,B));
            return  temp;
        }

        public static void main(String args[])
        {
            ArrayList<Integer> input = new ArrayList<>();
            input.add(23);
            input.add(35);
            input.add(76);
            KLargestElementsInAnArray problem = new KLargestElementsInAnArray();

            List<Integer> result = problem.solve(input,1);
            System.out.println(result);
        }


}
