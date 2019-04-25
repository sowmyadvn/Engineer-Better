/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i < nums.length; i++) {
            map.put(nums[i],1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(i+1))
                list.add(i+1);
        }
        return list;
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet hSet = new HashSet(nums.length);
        int num = 1;
        for(int i = 0; i < nums.length; i++) {
            hSet.add(nums[i]);
        }
        List<Integer> result = new ArrayList(nums.length-hSet.size());
        for(int i = 1; i <= nums.length; i++) {
            if(!hSet.contains(i))
                result.add(i);
        }
        
        return result;
    }
}