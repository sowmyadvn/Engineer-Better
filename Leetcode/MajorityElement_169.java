/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0, max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == max) {
                count++;
                if(count > nums.length/2)
                    return nums[i];
            }
            else {
                max = nums[i];
                count = 1;
            }
        }
        return nums[nums.length-1];
        
        //return nums[nums.length/2];
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = nums[0];
        for(int i:nums) {
            if(map.get(i) != null) {
                int val = map.get(i);
                if(++val > nums.length/2) {
                    max = i;
                    break;
                }
                map.put(i,val);
            } 
            else
                map.put(i,1);
        }
        return max;
    }
}