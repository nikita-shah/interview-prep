package dsa.trees;


import java.util.*;


/*
   recursive - 3
   iterative with space(stack) - 3
   iterative morris without space -3
   (only morris inorder traversal exists)
 */
public class Traversals {

    //morris algorithm for inorder tree traversal is left to implement  ---> IMP

    //write down code for level order traversal too

    public static void preOrderRec(TreeNode root)
    {
        if(root==null)
            return;
        System.out.println(root.val);
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public static void inOrderRec(TreeNode root)
    {
        if(root==null)
            return;
        inOrderRec(root.left);
        System.out.println(root.val);
        inOrderRec(root.right);
    }

    public static void postOrderRec(TreeNode root)
    {
        if(root==null)
            return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.println(root.val);
    }




    //this inorder iterative does not work this way...
    //try to dry run with a simple tree rooted at 1 having left as 2 and right as 3
    //it ll get stuck at 2
    public static void inOrderIter_notWorking(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.peek();
            if(node.left!=null) {
                stack.push(node.left);
            }
            else
            {
                TreeNode nodeCurr = stack.pop();
                System.out.println(nodeCurr.val);
                if(nodeCurr.right!=null) {
                    stack.push(node.right);
                }
            }
        }
    }


    //Preferred iterative traversals
    public static void preOrderIter(TreeNode root)
    {
        TreeNode curr =  root;
        Stack<TreeNode>stack = new Stack<>();
        while(curr!=null || !stack.empty())
        {
            if(curr!=null)
            {
                System.out.println(curr.val);
                //push current element as we will need to go right later
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                //we have no more left to go
                //pop and go to its right
                //as the popped node would have been already visited
                TreeNode top = stack.pop();
                curr = top.right;
            }
        }
    }

    public static void inOrderIter(TreeNode root)
    {
        TreeNode currNode = root;
        Stack<TreeNode>stack = new Stack<>();
        while(!stack.empty() || currNode!=null)
        {
            if(currNode!=null) {
                //pushing curr as we will need it later to visit itself and to go right
                stack.push(currNode);
                currNode = currNode.left;
            }
            else
            {
                //if curr is null, that means we have gone left and reached null, its time
                //to top from stack visit it and go right
                TreeNode top =  stack.pop();
                System.out.println(top.val);
                currNode = top.right;
            }
        }
    }


    //GFG postorder iterative traversal -> https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/?ref=lbp

    public static void postOrderIter(TreeNode root)
    {
        //post order is LRD, its difficut to achieve it with above logics
        //achieve a reverse of post order i.e modified preorder DRL and
        //reverse the result and print it
        ArrayList<Integer> reversePostOrder = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.empty())
        {
            if(curr!=null) {
                reversePostOrder.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            else
            {
                //we have reached trying to reach the right
                //pop
                //momve left
                TreeNode top = stack.pop();
                curr = top.left;

            }
        }
        //reverse the array list
        for(int i=0,j=reversePostOrder.size()-1 ; i<=j ; i++,j--)
        {
            int temp = reversePostOrder.get(j);
            reversePostOrder.set(j,reversePostOrder.get(i));
            reversePostOrder.set(i,temp);
        }

        //print the reversed list
        for(int i=0;i<reversePostOrder.size();i++)
        {
            System.out.println(reversePostOrder.get(i));
        }


    }

    public static void postOrderIter_gfg(TreeNode root)
    {
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        s.push(curr);
        while(!s.empty())
        {
            if(curr!=null)
            {
                if (curr.right != null) {
                    s.push(curr.right);
                }
                s.push(curr);
                curr= curr.left;
            }
            else
            {
                TreeNode node = s.pop();
                //3cases node.right = null, node.right != top node.right = top
                TreeNode top =  s.peek();
                if(node.right==null || node.right!=top)
                {
                    System.out.println(node.val);
                    curr=null;
                }
                else
                {
                    curr = s.pop();
                    s.push(node);
                }
            }

        }
    }

    /*
      whil on each node, find predecessor, link to itself, go left
      if going left gives you null, visit the current node , go right
      if pred is already linked, visit current node, unlink pred and go right

      The idea is in inorder we want keep going to the left, when we want to return, that is when we use stack,
      since we dont want to use stack here, we will have to link the inorder precessor and the next node.
      a node's inorder predecessor will never have a right child
      as by defination, inorder predecessor of a node is the rightmost node in the left subtree,
      so the predecessor will never have right child.
      hence that pointer is available for us to use
      we will point a node's predecessors's right to the node.

      so start from root,
      if you can go left, maybe you should, before you go left, find the current nodes' predecessor
       if the predecessor's right is not linked
        prdecessor.right = curr node
        go left curr = curr.left
       if predecessor right was linked,
        make that pred.right = null
        // this means left subtree was visited and we hae come back, so tie to visit the right subtree
        go right  curr = curr.right

      if you cant go left, meaning time for current node to be visited, visit it
      and go to right (if it was time to go back right pointer will still lead us correctly)

      check for its predecessor, if the predecessors right is pointing to curr node,
      make it null like before and go right;
     */
    public static void inOrderMorris(TreeNode root)
    {
        TreeNode curr = root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                //visit current node
                System.out.println(curr.val);
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
                    System.out.println(curr.val);
                    pred.right = null;
                    //go and visit right subtree
                    curr = curr.right;

                }
            }
        }
    }

    public static TreeNode findInOrderPred(TreeNode node)
    {
        //case 1 .. node does not have any left child,
            //  node  does not have an inorder predecessor
        //case 2.. node has a leaf node as left child
            // the left child is the predecessor
        //case 3..node has a left subtree
            //right most element of the leftsubtree is predecessor
            //or  if no right subtree to left child of node then the left child is predecessor

        node = node.left; //case 1 we could have a null right here
        while(node!=null && node.right!=null)
        {
            node = node.right;
        }
        return node;
    }

    public static TreeNode findInOrderPred_morris(TreeNode node)
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

    public static void levelOrderTraversal(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> levelOrderTraversal = new ArrayList<ArrayList<Integer>>();
        TreeNode curr = root;
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(curr);
        q.add(null);
        ArrayList<Integer>level = new ArrayList<Integer>();
        while(!q.isEmpty() )
        {
            curr = q.remove();
            if(curr!=null)
            {
                System.out.println(curr.val);
                level.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            else
            {
              System.out.println("#");
              if(q.isEmpty()) break;
              else {
                  q.add(null);
                  ArrayList<Integer>filledLevel = new ArrayList<>();
                  filledLevel.addAll(level);
                  levelOrderTraversal.add(filledLevel);
                  level.clear();
              }
            }
        }
    }

    //leetcode
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>levelOrderTraversal = new ArrayList<>();
        TreeNode curr = root;
        if(curr == null) return levelOrderTraversal;
        Queue<TreeNode> q =  new LinkedList<>();
        q.add(curr);
        q.add(null);
        ArrayList<Integer>level = new ArrayList<Integer>();

        while(!q.isEmpty() )
        {
            curr = q.remove();

            if(curr!=null)
            {
                level.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            else
            {

                if(q.isEmpty())
                {
                    ArrayList<Integer>filledLevel = new ArrayList<>();
                    filledLevel.addAll(level);
                    levelOrderTraversal.add(filledLevel);
                    level.clear();
                    break;
                }
                else
                {
                    q.add(null);
                    ArrayList<Integer>filledLevel = new ArrayList<>();
                    filledLevel.addAll(level);
                    levelOrderTraversal.add(filledLevel);
                    level.clear();
                }
            }
        }
        return levelOrderTraversal;
    }

    public static void main(String args[])
    {
        TreeNode root = BinaryTreeFromArray.constructTreeFromLevelOrder(new int[]{5,8,3,1,7,6,-1});
        //inOrderMorris(root);
        //postOrderIter_gfg(root);
        TreeNode root1 = BinaryTreeFromArray.constructTreeFromLevelOrder(new int[]{ 3,9,20,-1,-1,15,7});
        levelOrderTraversal(root1);
    }

}
