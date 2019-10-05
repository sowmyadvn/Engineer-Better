/*
Given an array of integers A, return the largest integer that only occurs once.

If no integer occurs once, return -1.

 

Example 1:

Input: [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: 
The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it's the answer.
Example 2:

Input: [9,9,8,8]
Output: -1
Explanation: 
There is no number that occurs only once.
 

Note:

1 <= A.length <= 2000
0 <= A[i] <= 1000
*/
class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i: A) {
            if(map.containsKey(i)) {
                int val = map.get(i);
                map.put(i,++val);
            }
            else 
                map.put(i,1);
        }
        int large = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1 && entry.getKey() > large)
                large = entry.getKey();   
        }
        if(large < -1)
            return -1;
        
        return large;
    }
}

class Solution {
    public int largestUniqueNumber(int[] A) {
        int result = -1;
        int[] temp = new int[1001];
        for(int i = 0; i < A.length; i++) {
            temp[A[i]]++;
        }
        
        for(int i = temp.length-1;i >= 0; i--) {
            if(temp[i] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}