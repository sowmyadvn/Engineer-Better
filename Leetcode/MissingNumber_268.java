/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[n-1] != n)
            return n;
        for( int i = 0; i < nums.length; i++) {
            if(i != nums[i])
                return i;
        }
        return 0;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
       int sum = 0;
       for(int i = 0; i < nums.length; i++) {
           sum += nums[i];
       } 
        
       int total = (nums.length*(nums.length+1))/2;
       
       return total-sum; 
    }
}