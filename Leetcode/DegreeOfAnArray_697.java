/* Another smart approach is to use list to store degree,first and last elements */

class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int maxVal = Integer.MIN_VALUE, maxKey = 0;
        for(int i=0; i < nums.length; i++) {
            if(map.get(nums[i]) == null)
                map.put(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);  
            if(map.get(nums[i]).size() > maxVal) {
                maxVal = map.get(nums[i]).size();
            }
        }
        int diff = Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()) {
            int sz = entry.getValue().size();
            int tempDiff = entry.getValue().get(sz-1)-entry.getValue().get(0)+1;
            if(sz == maxVal) {
                if(diff > tempDiff) 
                     diff = tempDiff;
            }
        }
        return diff;
    }
}

/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>(), first = new HashMap<>();
        int degree = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            if(count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                res = i-first.get(nums[i])+1;
            }
            else if(count.get(nums[i]) == degree) {
                res = Math.min(res, i - first.get(nums[i])+1);
            }
        }
        return res;
    }
}