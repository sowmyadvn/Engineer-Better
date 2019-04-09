/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if( root == null)
            return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> arrList = new ArrayList<List<Integer>>();
        TreeNode current = root;
        queue.add(current);
        while(true) {
            List<Integer> innerList  = new ArrayList<Integer>();
            int count = queue.size();
            if(count == 0)
                break;
            while (count > 0){
                current = queue.poll();
                innerList.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right!= null) {
                    queue.add(current.right);
                }
                count--;
            }
            arrList.add(innerList);
        }
        return arrList;
    }
}

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
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return levels;
        levelOrder(root,0);
        return levels;
    }
    
    public void levelOrder(TreeNode root,int level) {
        //New level node
        if(levels.size() == level)
            levels.add(new ArrayList<Integer>());
        levels.get(level).add(root.val);
        //Add next level left and right
        if(root.left != null)
            levelOrder(root.left,level+1);
        if(root.right != null)
            levelOrder(root.right,level+1);
    }
}