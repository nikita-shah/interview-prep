package dsa.trees;

import java.util.LinkedList;

public class BinaryTreeFromArray<index> {
    //the way it is used as a input in scaler code
    //level wise, include -1 for nulls,
    //eg
    /*
                3
            1       4
          10  2   5

          will be = {3, 1,4,10,2,5,-1}

                3
            1       4
          10      5

          will be = {3, 1, 4,10,-1,5,-1}

     */

    static int index =0;
    public static TreeNode constructTreeFromLevelOrder(int[]A)
    {
        LinkedList<TreeNode>q =  new LinkedList<>();
        TreeNode root =  new TreeNode(A[0]);
        q.add(root);
        int index = 1;
        while (!q.isEmpty() && index < A.length)
        {
            //in every iteration,
            //pop from queue.
            //from right, left, attach it,
            //if not null put right left back in queue
            //here we do not need the informtion of when a level gets switched, hence we will not be storing null in the queue

            TreeNode curr = q.remove();
            curr.left = A[index]==-1? null:new TreeNode(A[index]);
            index++;
            curr.right = A[index]==-1?null:new TreeNode(A[index]);
            index++;
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        return root;
    }


}
