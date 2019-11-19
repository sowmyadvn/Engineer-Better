/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        height(list,root);
        return list;
    }
    private int height(List<List<Integer>> list, TreeNode root) {
        if(root == null)
            return -1;
        int level = 1 + Math.max(height(list,root.left),height(list,root.right));
        if(level >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        root.left = root.right = null;
        return level;
    }
}
/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []         
*/