class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int p: preorder) {
            if( p < low)
                return false;
            while(!stack.isEmpty() && p > stack.peek()) 
                low = stack.pop();
            stack.push(p);
        }
        return true;
    }
}

class Solution {
    int i = 1;
    public boolean verifyPreorder(int[] A) {
        return (A.length == 0 || (verifyPreorder(A,Integer.MIN_VALUE,A[0]) && verifyPreorder(A,A[0],Integer.MAX_VALUE))); 
    }
    
    private boolean verifyPreorder(int[] A, int left, int right) {
        if(i == A.length || A[i] > right) return true;
        int mid = A[i++];
        return mid > left && verifyPreorder(A,left,mid) && verifyPreorder(A,mid,right);
    }
}
/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
Follow up:
Could you do it using only constant space complexity?

*/