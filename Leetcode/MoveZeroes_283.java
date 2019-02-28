/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0)
            return;
        int count = 0, j = 0,len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) {
                count++;
            }
        }
        if(count == 0)
            return;
        int k = count;
        for(int i = 0; i < len; i++) {
            if(len-k > 0 && nums[i] != 0) {
                nums[j] = nums[i];
                j++;
                k--;
            }
        }
        for(int i = len-count; i < len; i++) {
            nums[i] = 0;
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                nums[lastNonZero++] = nums[i];
        }
        
        for(int i = lastNonZero; i< nums.length; i++)
          nums[i] = 0;
    }
}

/*
Approach: Two pointer approach. Check for lastNonZero element and replace zeroes with them. Now, replace non-zero repetitive
elements with 0.
*/