/*
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