class Solution {
    int len = 0; 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return fourSum(nums,target, 4, 0);
    }
    
    private List<List<Integer>> fourSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        if(index >= len)
            return arr;
        if(k == 2) {
            int j = len-1, i = index;
            while(i < j) {
                if( target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    arr.add(temp);
                    while(i < j && nums[i] == nums[i+1]) i++;
                    while(i < j && nums[j-1] == nums[j]) j--;
                    i++;
                    j--;
                }
                else if(target-nums[i] > nums[j]) {
                    i++;   
                }
                else {
                    j--;
                }
            }
        }
        else {
            for(int i = index; i < len-k+1; i++) {
                List<List<Integer>> temp = fourSum(nums,target-nums[i],k-1,i+1);
                if(temp != null) {
                    for(List<Integer> t : temp) {
                        t.add(0,nums[i]);
                    }
                    arr.addAll(temp);
                    
                    while(i < len-1 && nums[i] == nums[i+1]) i++;
                }
               
            }
        }
        return arr;
    }
}
/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/