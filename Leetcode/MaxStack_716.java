/*
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.

*/
class MaxStack {

    /** initialize your data structure here. */
    List<Integer> stack;
    int max, maxSize;
    public MaxStack() {
        stack = new ArrayList<Integer>();
        max = Integer.MIN_VALUE;
        maxSize = 0;
    }
    
    public void push(int x) {
        stack.add(x);
        if(x >= max) {
            max = x;
            maxSize = stack.size()-1;
        }
    }
    
    public int pop() {
        int popElement = stack.remove(stack.size()-1);
        if(popElement == max) {
            updateMax();
        }
        return popElement;
            
            
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int peekMax() {
        return max;
    }
    
    public int popMax() {
        int popElement = stack.remove(maxSize);
        updateMax();
        return popElement;
    }
    
    private void updateMax() {
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i < stack.size(); i++) {
            if(temp <= stack.get(i) ) {
                temp = stack.get(i);
                maxSize = i;
            }
        }
        max = temp;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */