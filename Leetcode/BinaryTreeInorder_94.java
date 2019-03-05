/**
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recrusive version: O(N)S:O(N)T where N is the number of Nodes
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeList = new ArrayList<Integer>();
        if(root != null)
            return inorderTraversal(root, treeList);
        return treeList;
    }
    
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> treeList) {
        
        if(root != null && root.left != null)
            inorderTraversal(root.left, treeList);
        treeList.add(root.val);
        if(root != null && root.right != null)
            inorderTraversal(root.right, treeList);
        return treeList;
    }
}