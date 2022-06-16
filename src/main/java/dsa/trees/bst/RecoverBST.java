package dsa.trees.bst;

import dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/*
HARD problem in scaler .. very imp
 */

public class RecoverBST {

    int prev = -1;
    int first = -1;
    int middle = -1;
    int last = -1;

    public ArrayList<Integer> recoverTree(TreeNode A) {
        TreeNode curr = A;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                //visit current node //check for inversions
                checkForInversion(curr);
                prev = curr.val;
                //check for right subtree
                curr = curr.right;
            }
            else
            {
                TreeNode pred = findInOrderPred_morris(curr);
                if(pred.right==null)
                {
                    //the left subtree is not visited yet
                    //store the link from pred right to current node to come back after left subtree
                    pred.right = curr;
                    //go and visit the left subtree now
                    curr = curr.left;
                }
                else
                {
                    //here pred.right == curr
                    //so we have visited the left subtree and come back
                    //so visit the current node
                    //check for inversions
                    checkForInversion(curr);
                    prev = curr.val;
                    //go and visit right subtree
                    curr = curr.right;

                }
            }
        }

        ArrayList<Integer>ans = new ArrayList<>();
        ans.add(first);
        ans.add(last!=-1?last:middle);
        Collections.sort(ans);
        return ans;
    }

    public  TreeNode findInOrderPred_morris(TreeNode node)
    {
        //since we have linked right of predecessor to node itself
        //extra condition will get added now
        TreeNode givenNode = node;
        node = node.left;
        while(node!=null && node.right!=null && node.right!=givenNode)
        {
            node = node.right;
        }
        return node;
    }

    private void checkForInversion(TreeNode curr)
    {

        //this method is very very imp
        //check the video solution for this to understand it
        if(prev > curr.val)
        {
            if(first==-1)
            {
                first = prev;
                middle = curr.val;
            }
            else
            {
                last = curr.val;
            }

        }
    }

}
