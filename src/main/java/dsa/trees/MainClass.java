package dsa.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    public static void main(String args[])
    {
        BinaryTreeFromInAndPre binaryTreeFromInAndPre = new BinaryTreeFromInAndPre();

        //my method using array list
        ArrayList<Integer>pre = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer>in = new ArrayList<>(Arrays.asList(3,2,4,1,5));

        TreeNode constructedTree = binaryTreeFromInAndPre.buildTree(pre,in);


        int[]preArr = new int[]{1,2,3,4,5};
        int[]inArr = new int[]{3,2,4,1,5};
        //the one taught in class uding arrays
        TreeNode constructedTree1 = binaryTreeFromInAndPre.buildTreeArray(preArr,inArr,0,4,0,4);
        printTree(constructedTree1);

    }

    private static void printTree(TreeNode root)
    {
        System.out.println("Pre order");
        Traversals.preOrderIter(root);
        System.out.println("In order");
        Traversals.inOrderIter(root);
        System.out.println("Post order");
        Traversals.postOrderIter(root);
    }





}
