/**
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode increasingBST(TreeNode root) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue = increasingBST(root, queue);
        TreeNode head = null;
        if(!queue.isEmpty()) {
            head = new TreeNode(queue.poll());
            TreeNode temp = head;
            while(!queue.isEmpty()) {
                TreeNode curr = new TreeNode(queue.poll());
                temp.left = null;
                temp.right = curr;
                temp = temp.right;
            }
        }
        return head;
    }
    
    public Queue<Integer> increasingBST(TreeNode root,Queue<Integer> queue) {
        if(root == null)
            return queue;
        if(root.left != null)
            increasingBST(root.left, queue);
        queue.add(root.val);
        if(root.right != null)
            increasingBST(root.right, queue);
        
        return queue;
    }
}