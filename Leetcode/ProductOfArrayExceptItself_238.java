class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int prod = 1;
        left[0] = 1;
        // left product
        for( int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1]*left[i-1];
        }
        
        right[nums.length - 1] = 1;
        prod = 1;

        //right product
        for( int i = nums.length-2; i >= 0; i--) {
            right[i] = nums[i+1]*right[i+1];
        }

        //updating array with the result
        for(int i = 0; i < nums.length; i++) {
            right[i] = right[i] * left[i];
        }
        
        return right;
    }
}
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/