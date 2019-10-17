/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, list, new ArrayList<Integer>(),target, 0);
        return list;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tempList,int remain, int start) {
        if(remain < 0) return;
        if(remain == 0) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums,list,tempList,remain-nums[i],i);
            tempList.remove(tempList.size()-1);
        }
    }
}