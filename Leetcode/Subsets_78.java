class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<Integer>(),result,0);
        return result;
    }
    
    private void backtrack(int[] nums,List<Integer> tempList, List<List<Integer>> result,int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums,tempList,result,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/