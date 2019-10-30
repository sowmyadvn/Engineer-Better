/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

*/
class Solution {
    public void rotate(int[] nums, int k) {
        /*
        Strategy:
        1. swap last k numbers in array with first k numbers in the same order
        [1,2,3,4,7,6,5,4] k = 5
        0,5=>0,3
        4,2,3,1,7,6,5,4
        1,4=>1,4
        4,7,3,1,2,6,5,4
        2,3=>2,5
        4,7,6,1,2,3,5,4
        3,2=>3,6
        4,7,6,5,2,3,1,4
        o/p: [4,7,6,5,4,1,2,3] problem is when k > nums.length/2
        
        int i = 0, j = k, len = nums.length;
        for(i = 0; j != 0; i++ ) {
            if(i < j) {
                 nums[i] = nums[i] + nums[len-j];
                 nums[len-j] = nums[i] - nums[len-j];
                 nums[i] = nums[i] - nums[len-j];
            }
            j--;
        }   
        */
        /*
        O(N) Space and O(N) Time
        
        2. Store first len-k elements in array and attach after moving last k elements to beginning
        */
        if(nums.length < 2)
            return;
        if( k > nums.length) {
            k = k - nums.length;
        }
        int[] arr = new int[nums.length-k];
        int j = k, i = 0;
        for(i = 0; i < nums.length-j; i++) {
            arr[i] = nums[i];
        }
        for(i = 0; i < j; i++) {
            nums[i] = nums[i+nums.length-j];
        }
        for(i = j; i < nums.length; i++) {
            nums[i] = arr[i-j];
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        
        int j = 0, n = nums.length;
        if( n == 0)
            return;
        if(k > n)
            k = k%n;
        if(k == 0 || k == nums.length)
            return;
        int[] temp = new int[k];
        
        for(int i = n-k; i < n; i++) {
            temp[j++] = nums[i];
        }
        for(int i = n-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        
        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
