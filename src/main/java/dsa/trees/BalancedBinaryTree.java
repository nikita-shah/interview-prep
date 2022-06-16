package dsa.trees;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class BalancedBinaryTree {

    public int isBalanced(TreeNode A) {
        Info ans  = isBalancedTree(A);
        return ans.isBalanced==true?1:0;

    }

    private Info isBalancedTree (TreeNode A)
    {
        if (A==null)
            return new Info(-1,true);

        Info left = isBalancedTree(A.left);
        Info right = isBalancedTree(A.right);

        if(Math.abs(left.height-right.height)<=1 && left.isBalanced && right.isBalanced)
            return new Info(1+Math.max(left.height,right.height),true);
        return new Info(1+Math.max(left.height,right.height),false);
    }

}

class Info{
    int height;
    boolean isBalanced;
    Info(int height, boolean isBalanced)
    {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}



