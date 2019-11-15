class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int tempSum = 0, left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        while(right < nums.length) {
            while(tempSum < s && right < nums.length) {
                tempSum += nums[right++];
            }
            while(tempSum >= s) {
                min = Math.min(min,right-left);
                tempSum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}

/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

*/