/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Solution {
    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> list) {
        if(tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));    
        else {
            for(int i = 0; i < nums.length; i++) {
                if(!tempList.contains(nums[i])) {       
                    tempList.add(nums[i]);          //Add nums[i] to end
                    backtrack(nums,tempList,list);  //Call backtrack with that option
                    tempList.remove(tempList.size()-1); //Now, undo adding nums[i] so actual one is unchanged
                }
            }
        }
    }
        
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>(), list);
        return list;
    }
}