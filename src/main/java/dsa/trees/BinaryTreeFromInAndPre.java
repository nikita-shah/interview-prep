package dsa.trees;

import java.util.ArrayList;

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
public class BinaryTreeFromInAndPre {
    //my method using array list
    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        int rootVal = pre.get(0);
        TreeNode root = new TreeNode(rootVal);
        if(in.size()==1 || pre.size()==1) return root;
        int rootIndex = in.indexOf(rootVal);

        //	subList(int fromIndex, int toIndex)
        //  from is inclusive and to is exclusive

        ArrayList<Integer> inLeftNew = new ArrayList(in.subList(0,rootIndex));
        ArrayList<Integer> preLeftNew = new ArrayList(pre.subList(1,rootIndex+1));

        root.left = buildTree(preLeftNew,inLeftNew);

        ArrayList<Integer> inRightNew = new ArrayList(in.subList(rootIndex+1,in.size()));
        ArrayList<Integer> preRightNew = new ArrayList(pre.subList(rootIndex+1,pre.size()));
        root.right = buildTree(preRightNew,inRightNew);
        return root;
    }

    //the one taught in class using arrays
    public TreeNode buildTreeArray(int[] pre, int[] in, int pre_s,int pre_e,int in_s,int in_e) {

        //if this has to be base case it has to be previous to  int rootVal = pre[pre_s];
        // other wise we might get array index out of bounds exception

        if(in_s>in_e||pre_s>pre_e) return null;

        //root will be pre[0]
        int rootVal = pre[pre_s];
        TreeNode root = new TreeNode(rootVal);

        //if(in_s==in_e||pre_s==pre_e) return root; .. this as a base case only  also works the other if wont be needed then

        int rootIndex = indexOf(rootVal,in,in_s,in_e);

        int lengthOfInorder = rootIndex-in_s;
        int pre_s_left = pre_s+1;
        int pre_e_left = pre_s_left + lengthOfInorder -1;

        root.left = buildTreeArray(pre,in,pre_s_left,pre_e_left,in_s,rootIndex-1);

        lengthOfInorder = in_e-rootIndex;
        int pre_s_right = pre_e_left+1;
        int pre_e_right = pre_e;

        root.right = buildTreeArray(pre,in,pre_e_left+1,pre_e_right,rootIndex+1,in_e);
        return root;
    }

    private int indexOf(int data, int[]arr, int in_s,int in_e)
    {
        for (int i=in_s;i<=in_e;i++)
        {
            if(arr[i]==data)
                return i;
        }
        return -1;
    }

}
