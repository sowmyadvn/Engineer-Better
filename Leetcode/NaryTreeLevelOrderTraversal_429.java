
/*
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:

 



 

We should return its level order traversal:

[
     [1],
     [3,2,4],
     [5,6]
]
 

Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
	//List of lists as class variable
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return levels;
		//Call helper levelOrder method
        levelOrder(root,0);
        return levels;
    }
    //If levels size() equals level, it means new arraylist has to be created for next level
    public void levelOrder(Node root, int level) {
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
		//Add nodes' values to the list
        levels.get(level).add(root.val);
		
		//For all of nodes' children, call levelOrder recursively
        for(Node child: root.children) {
            levelOrder(child,level+1);
        }
    }
}
