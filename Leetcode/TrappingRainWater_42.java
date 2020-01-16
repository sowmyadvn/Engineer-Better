class Solution {
    public int trap(int[] nums) {
        int n = nums.length,res = 0; 
        int right = n-1,left = 0;
        int maxLeft = 0, maxRight = 0;
        
        while(left <= right) {
            if(nums[left] <= nums[right]) {
                if(nums[left] >= maxLeft) maxLeft = nums[left];
                else res += maxLeft-nums[left];
                left++;
            }
            else {
                if(nums[right] >= maxRight) maxRight = nums[right];
                else res += maxRight-nums[right];
                right--;
            }
        }
        return res;
    }
}

class Solution {
    public int trap(int[] arr) {
        int maxRight = 0,  maxLeft = 0;
        int left = 0, right = arr.length-1, res = 0;
        
        while(left < right) {
            maxLeft = Math.max(maxLeft,arr[left]);
            maxRight = Math.max(maxRight,arr[right]);
            if(maxLeft <= maxRight) {
                res += maxLeft-arr[left];
                left++;
            }
            else {
                res += maxRight-arr[right];
                right--;
            }
        }
        return res;
    }
}
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/