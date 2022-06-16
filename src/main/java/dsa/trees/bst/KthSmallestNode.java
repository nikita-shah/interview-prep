package dsa.trees.bst;

import dsa.trees.TreeNode;

public class KthSmallestNode {
    int count = 0;
    public int kthsmallest(TreeNode A, int B) {
        if(A.left==null
                &&A.right==null)
            return A.val;

        return  inOrderTillK(A,B);

    }


    private int inOrderTillK(TreeNode A, int B)
    {
        if(A==null)
            return  -1;

        int leftAns = inOrderTillK( A.left, B) ;
        count++;

        if(B==count)
        {   count++;
            return A.val;
        }

        if(leftAns > 0 )
        {
            return leftAns;
        }

        return  inOrderTillK( A.right, B);
    }


}
