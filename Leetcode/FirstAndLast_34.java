/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int mid = (low+high)/2;
        if(nums[low] > target || nums[high] < target)
            return new int[]{-1,-1};
        
        while(nums[mid] != target) {
            if(nums[mid] < target) {
                low = mid;
            }
            else if(nums[mid] > target) {
                high = mid;
            }
            else
                return new int[]{-1,-1};
            mid = (high+low)/2;
        }
        int ct1 = mid, ct2 = mid;
       if(nums[mid] == target) {
           while(ct1 >= 0 && nums[ct1] == target) ct1--;
           while(ct2 <= nums.length-1 && nums[ct2] == target) ct2++;
           return new int[]{++ct1,--ct2};
       }
        return new int[]{-1,-1};
    }
}
//O(log N)
class Solution {
    public int extremeInsertionRange(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = (low+high)/2;
            if(nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            }
            else
                low = mid+1;

        }
        return low;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] relRange = {-1,-1};
        int left = extremeInsertionRange(nums,target,true);
        if(left == nums.length || nums[left] != target)
            return relRange;
        relRange[0] = left;
        relRange[1] = extremeInsertionRange(nums,target,false)-1;
        
        return relRange;
    }
}