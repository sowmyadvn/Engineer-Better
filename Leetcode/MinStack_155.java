/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
class MinStack {

    /** initialize your data structure here. */
    List<Integer> stack;
    int min;
    public MinStack() {
        stack = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack.add(x);
        if(x < min)
            min = x;
    }
    
    public void pop() {
        int popEle = stack.remove(stack.size()-1);
        if(popEle == min) {
            int temp = Integer.MAX_VALUE;
            for(int val: stack) {
                if(temp > val)
                    temp = val;
            }
            min = temp;
        }
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.get(stack.size()-1);
        
        return -1;
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Time Complexity : O(1)
// Space Complexity : O(N) where N is number of values inserted in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Trying to come up with 1 stack solution was challenging


// Your code here along with comments explaining your approach

//Basic idea is to store old minimum and new minimum consecutively in stack i.e. every old/new min will have pushes to stack multiple times
//This is to easily update old min value when pop() is called


class MinStack {

    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    
    public void push(int x) {
        //Push old minimum just before new minimum again if it is greater than current minimum

        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
        
    }
    
    public void pop() {
        //Pop old minimum along with new minimum to update min
        if(stack.pop() == min) {
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

// If no stack library has to be used: use linkedlist node with 2 values: val and min. Every node has its min always updated
class MinStack {

    private Node head; 
    public void push(int x) {
        // Update min by comparing old min and new value
        if(head == null) 
            head = new Node(x,x);
        // current node would be new head
        // its next node would be old head
        else 
            head = new Node(x,Math.min(x,head.min),head);
    }
    
    public void pop() {
        //remove head 
        head = head.next;   
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val, min;
        Node next;
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
        
        private Node(int val,int min) {
            this(val,min,null);
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();


 // Time Complexity : O(1)
// Space Complexity : O(N) where N is number of values inserted in stack
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach

// Use 2 stacks where one stack has values and other has current minimum value. When current min is equal to 
// popped value, pop from minstack
*/

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack, minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        // Update min if x <= min
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }
    
    public void pop() {
        // Pop from minstack if stack top and minstack top are equal
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}