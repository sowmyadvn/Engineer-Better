/**
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return root;
        //Check if root is less than L, then result must be towards right
        if(root.val < L)
            return trimBST(root.right,L,R);
        //Check for root > R, then result is on left
        if(root.val > R)
            return trimBST(root.left,L,R);
        //If <= R and >= L, then keep trimming its left and right sub-trees
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        
        return root;
    }
}