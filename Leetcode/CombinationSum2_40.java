class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums,list,new ArrayList<Integer>(), target,0);
        return list;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tempList, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backtrack(nums,list,tempList,remain-nums[i],i+1);
                tempList.remove(tempList.size()-1);
            }
        }
        
    }
}
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/