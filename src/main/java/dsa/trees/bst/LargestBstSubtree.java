package dsa.trees.bst;

//this contains logic fro counting number of nodes in a bst as well as
//the  logic for whether a tree rooted at the given node is bst or not.


import dsa.trees.TreeNode;

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
public class LargestBstSubtree {

  //the min size of largest bst is 1
    //as any leaf node is always a bst
    int ans = 1;
    public int solve(TreeNode A) {
        BSTInfo result = largestBST(A);
        return ans;
    }

    private BSTInfo largestBST (TreeNode A)
    {
        if(A==null)
            return new BSTInfo(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);
        BSTInfo left = largestBST(A.left);
        BSTInfo right = largestBST(A.right);

        if (left.isBST && right.isBST)
        {
            if(left.maxInSubtree < A.val && right.minInSubtree > A.val)
            {
                int newMax = Math.max(A.val,right.maxInSubtree);
                int newMin = Math.min(A.val,left.minInSubtree);
                int numNodes = left.numberOfNodesInSubTree + right.numberOfNodesInSubTree +1;
                ans = Math.max(ans,numNodes);
                return new BSTInfo(newMax,newMin,true,numNodes);
            }

        }
        return new BSTInfo(Integer.MIN_VALUE,Integer.MAX_VALUE,false,-1);
    }
}


class BSTInfo{

    int maxInSubtree;
    int minInSubtree;
    boolean isBST;
    int numberOfNodesInSubTree;
    BSTInfo(int maxInSubtree,int minInSubtree,boolean isBST, int numberOfNodesInSubTree)
    {
        this.isBST = isBST;
        this.maxInSubtree = maxInSubtree;
        this.minInSubtree = minInSubtree;
        this.numberOfNodesInSubTree = numberOfNodesInSubTree;
    }

}
