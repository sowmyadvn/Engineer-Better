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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        zigzagHelper(root,list,0);
        return list;
    }
    
    private void zigzagHelper(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null)
            return;
        if(level >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        if(level%2 == 0) {
            list.get(level).add(root.val);
        }
        else
            list.get(level).add(0,root.val);
        
        zigzagHelper(root.left,list,level+1);
        zigzagHelper(root.right,list,level+1);
    }
}
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/