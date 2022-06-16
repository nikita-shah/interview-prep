package dsa.trees.bst;

import dsa.trees.TreeNode;

import java.util.ArrayList;

public class MainClass {
    public static void main(String args[])
    {
    KthSmallestNode kthSmallestNode = new KthSmallestNode();
    TreeNode root = new TreeNode(1);
    System.out.println(kthSmallestNode.kthsmallest(basic3NodeTree(2,1,3),2));
    }


    public static TreeNode basic3NodeTree(int root, int left, int right)
    {
        TreeNode rootNode =  new TreeNode(root);
        TreeNode leftNode = new TreeNode(left);
        TreeNode rightNode =  new TreeNode(right);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;


    }

    //do this later too would be interesting
    public static TreeNode constructTreeFromArray(ArrayList<Integer>serialized)
    {
        //its a level order representation -1 meaning null
        return null;

    }
}
