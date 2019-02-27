/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
class MovingAverage {
    
    private List<Integer> window;
    int size;
    long sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new ArrayList<Integer>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(window.size() < size ) {
            window.add(val);
            sum = sum+val;
        }
        else {
            sum = sum-window.get(0)+val;
            window.remove(0);
            window.add(val);
        }
        return (double) sum/window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

/*
Approach: Create arraylist to keep track of the values being added. Then, use sum variable to keep track of the sum, instead 
of calculating every single time. 
O(1)T:O(N)S
*/