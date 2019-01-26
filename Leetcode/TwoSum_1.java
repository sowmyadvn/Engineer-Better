/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

/*
Approach: First thought of brute force solution. It would involve traversing through array each time for complement of element
that sums up to target. This is O(N2) time and O(1) space. In order to improve the efficiency, a data structure that reduces 
search time has to be used. Hashmap has lookup time of O(1), even if space trade off is required. So, as return values are 
indices, value along with index is stored in hash map and if complement not found, it is added to the map. If found, indices 
are returned.

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer,Integer> numsMap = new HashMap<>();
         //Value is key and index is value
        
         for(int i = 0; i < nums.length; i++ ) {
             int complement = target - nums[i];
             if(numsMap.containsKey(complement))
                 return new int[]{numsMap.get(complement),i};
             
             numsMap.put(nums[i],i);
         }
        throw new IllegalArgumentException("No two sum solution");
    }
}
