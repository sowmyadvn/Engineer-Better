/**
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    //Use DFS to check if every nested integer instance is nested list recursively
    private int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for(NestedInteger ni: list) {
            //Check if integer
            if(ni.isInteger()) {
                sum += ni.getInteger()*depth;
            }
            else { 
                //Call depthSum on the inner list
                sum += depthSum(ni.getList(),depth+1);
            }
        }
        return sum;
    } 
}

/*
Time complexity: Every nested list and element is traversed, so if there are 6 elements in different depths in 4 nested 
lists, N=10. So, N here is elements+lists. O(N)
Space complexity: If D is depth, atmost D calls are placed on stack at a time.So, O(D) space complexity
*

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
            return depthSum(nestedList,1);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(int i=0; i < nestedList.size(); i++) {
            if(nestedList.get(i).getInteger() == null) 
                sum += depthSum(nestedList.get(i).getList(),depth+1);
            else
                sum += nestedList.get(i).getInteger()*depth;
        }
        return sum;    
    }
}