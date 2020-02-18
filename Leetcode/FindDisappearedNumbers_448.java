// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


/*
Approach-1:
=========
1. Take temporary array and as soon as a number is found, update exact index with -1
2. Now, iterate through temp array and check if any index is not -1
3. Whichever indices aren't -1 couldn't be found in the array
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] temp = new int[nums.length];
        
        List<Integer> result = new ArrayList<>();
        //Update found number index to -1
        for(int i = 0; i < nums.length; i++) {
            temp[nums[i]-1] = -1;
        }
        // If not -1, then that number was not found, so add it to arraylist
        for(int i = 0; i < nums.length; i++) {
            if(temp[i] != -1) 
                result.add(i+1);
        }
        return result;
    }
}

/*
Approach-2:
===========
1. Similar to above approach except that instead of using additional space, negate the value which is stored in the array at
that index.
2. If at an index, value is positive, that means the value doesn't exist in the array
*/



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if( nums == null || nums.length == 0) return result;
        // update positive values to negative when the number is found
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if(nums[val-1] > 0)
                nums[val-1] = -(nums[val-1]);
        }
        // check whichever index is positive and add it to list
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}
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