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


public class EqualTreePartition {

    int ans = 0;
    int entireSum = 0;
    public int solve(TreeNode A) {

        entireSum = sumOfSubtreeRootedAtA(A);

        System.out.println(entireSum);

        if(entireSum%2!=0)
            return 0;
        else
            isDividePoss(A);

        return ans;
    }

    int sumOfSubtreeRootedAtA(TreeNode A)
    {
        if(A==null)
        {
            return 0;
        }
        int subTreeLeft = sumOfSubtreeRootedAtA(A.left);
        int subTreeRight = sumOfSubtreeRootedAtA(A.right);

        return subTreeLeft+A.val+subTreeRight;
    }

    int isDividePoss(TreeNode A)
    {
        if(A==null)
        {
            return 0;
        }
        int subTreeLeft = isDividePoss(A.left);
        int subTreeRight = isDividePoss(A.right);

        if(subTreeLeft == entireSum/2 || subTreeRight == entireSum/2)
            ans = 1;
        return subTreeLeft+A.val+subTreeRight;
    }

    public static void main(String[]arags)
    {
        EqualTreePartition equalTreePartition = new EqualTreePartition();
        int[]A = new int[]{ 106, -1 ,480, 454, 321, -1, -1, 719, -1, -1, -1 };
        TreeNode root1 = BinaryTreeFromArray.constructTreeFromLevelOrder(A);
        System.out.println(equalTreePartition.solve(root1));
    }
}

