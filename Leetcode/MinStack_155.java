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