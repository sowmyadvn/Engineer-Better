/*

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

//Time complexity: O(NK) time and O(K+N) space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Window size would be 
        if(nums.length < k || k == 0)
            return new int[]{};
        int[] window = new int[nums.length-k+1];
        //Store k values in arraylist
        List<Integer> list = new ArrayList<Integer>();
        int i = 0, cur = 0;
        
        //Add values to list
        while(i < k) {
            list.add(nums[i++]);
        }
        //Find maximum element in arraylist. 
        int index = 0;
        window[index++] = Collections.max(list);
        for(; i < nums.length; i++) {
            //Remove first element and add new element at the end
            int rm = list.remove(0);
            list.add(nums[i]);
            window[index++] = Collections.max(list);
        }
        return window;
    }
}

