/*
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

Return its preorder traversal as: [1,3,5,6,2,4].

 

Note:

Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorder(Node root) {
        List<Integer> aList = new ArrayList<Integer>();
        return preorder(root,aList);
    }
    
    public List<Integer> preorder(Node root, List<Integer> aList) {
        if(root == null)
            return aList;
        else {
            aList.add(root.val);
            for(Node n: root.children) {
                aList = preorder(n, aList);
            }
        }
        return aList;
    }
}