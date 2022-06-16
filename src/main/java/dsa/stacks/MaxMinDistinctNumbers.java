package dsa.stacks;

import java.util.Stack;

public class MaxMinDistinctNumbers {
        public int solve(int[] A) {

            int[]nseLeft = new int[A.length];
            int[]nseRight = new int[A.length];
            int[]ngeLeft = new int[A.length];
            int[]ngeRight = new int[A.length];

            Stack<Integer> nse = new Stack<>();
            Stack<Integer>nge = new Stack<>();



            int ans = 0 ;
            int mod = (int)(1E9+7);

            for(int i=0;i<A.length;i++)
            {
                //nseleft
                while(!nse.empty() && A[nse.peek()] >= A[i])
                {
                    nse.pop();
                }
                if(nse.empty())
                {
                    nseLeft[i] = -1;
                }
                else
                {
                    nseLeft[i] = nse.peek();
                }
                nse.push(i);


                //ngeLeft
                while(!nge.empty() && A[nge.peek()] <= A[i])
                {
                    nge.pop();
                }
                if(nge.empty())
                {
                    ngeLeft[i] = -1;
                }
                else
                {
                    ngeLeft[i] = nge.peek();
                }
                nge.push(i);

            }

            nse = new Stack<>();
            nge = new Stack<>();

            for(int i=A.length-1;i>=0;i--)
            {
                //nseRight
                while(!nse.empty() && A[nse.peek()] >= A[i])
                {
                    nse.pop();
                }
                if(nse.empty())
                {
                    nseRight[i] = -1;
                }
                else
                {
                    nseRight[i] = nse.peek();
                }
                nse.push(i);


                //ngeRight
                while(!nge.empty() && A[nge.peek()] <= A[i])
                {
                    nge.pop();
                }
                if(nge.empty())
                {
                    ngeRight[i] = -1;
                }
                else
                {
                    ngeRight[i] = nge.peek();
                }
                nge.push(i);

            }

            //an element A[i] will contribute as min element
            //in subarrays whose start point range is i-nseLeft[i] = startRange
            //in subarrays whose end point range is nseRight[i]-i = endRange
            //total subarrays A[i] will be min is startRange*endRange = contriAsMin

            //an element A[i] will contribute as max element
            //in subarrays whose start point range is i-ngeLeft[i] = startRange
            //in subarrays whose end point range is ngeRight[i]-i = endRange
            //total subarrays A[i] will be max is startRange*endRange = contriAsMax

            //contribution in total value = +contriAsMax -contriAsMin


            System.out.println("nseLeft");
            for(int i=0;i<A.length;i++)
            {
                System.out.println( nseLeft[i]);
            }

            System.out.println("ngeLeft");
            for(int i=0;i<A.length;i++)
            {
                System.out.println( ngeLeft[i]);
            }

            System.out.println("nseRight");
            for(int i=0;i<A.length;i++)
            {
                System.out.println( nseRight[i]);
            }

            System.out.println("ngeRight");
            for(int i=0;i<A.length;i++)
            {
                System.out.println( ngeRight[i]);
            }

            //an element A[i] will contribute as min element
            //in subarrays whose start point range is i-nseLeft[i] = startRange
            //in subarrays whose end point range is nseRight[i]-i = endRange
            //total subarrays A[i] will be min is startRange*endRange = contriAsMin

            //an element A[i] will contribute as max element
            //in subarrays whose start point range is i-ngeLeft[i] = startRange
            //in subarrays whose end point range is ngeRight[i]-i = endRange
            //total subarrays A[i] will be max is startRange*endRange = contriAsMax

            //contribution in total value * (contriAsMax -contriAsMin)

            for(int i=0;i<A.length;i++)
            {
                long startRange = nseLeft[i] == -1 ? i+1 : (i-nseLeft[i]);
                long endRange = nseRight[i] == -1 ? A.length-i : (nseRight[i]-i);
                long contriAsMin = ( startRange *  endRange);


                startRange = ngeLeft[i] == -1 ? i+1: (i-ngeLeft[i]);
                endRange = ngeRight[i] == -1 ? A.length-i  : (ngeRight[i]-i);
                long contriAsMax = (  startRange *  endRange );

                int eleContri = (int)(A[i]%mod*(contriAsMax-contriAsMin)%mod)%mod;

                System.out.println("Contri of "+A[i]+" as min : "+contriAsMin+" as max : "+contriAsMax+" total : "+eleContri);

                ans = ( ans%mod + eleContri )%mod;
            }


            return ans;



        }



}

