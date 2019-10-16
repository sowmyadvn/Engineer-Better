/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class Solution {
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            System.out.println();
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || (i > 0 && nums[i-1] == nums[i] && !used[i-1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list,tempList,nums,used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
}