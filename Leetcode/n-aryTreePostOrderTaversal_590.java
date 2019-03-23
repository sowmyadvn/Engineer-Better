/*
Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree: 

Return its postorder traversal as: [5,6,3,2,4,1].

 
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
    public List<Integer> postorder(Node root) {
        List<Integer> aList = new ArrayList<Integer>();
        if(root == null)
            return aList;
        else if(root.children.isEmpty()) {
            aList.add(root.val);
            return aList;
        }
        else {
            
            List<Integer> lst = new ArrayList<Integer>();
            for(Node item: root.children) {
                lst = postorder(item);
                for(Integer i: lst) 
                    aList.add(i);
            }
        }
        aList.add(root.val);
        return aList;
    }
}