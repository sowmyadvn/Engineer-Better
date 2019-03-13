/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    private Node prev;
    public Node flatten(Node head) {
        //Base case
        if(head == null)
            return null;
        Node temp = head;
        //Tail pointer, note: class variable to pass between method calls
        prev = head;
        
        while(temp != null) {
            if(temp.child != null) {
                //Disconnect old node and point to new node, also update prev's new connection
                Node newNode = temp.next;
                temp.next = flatten(temp.child);
                temp.child = null;
                temp.next.prev = temp;
                prev.next = newNode;
                if(newNode != null)
                    newNode.prev = prev;
            }
            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}