class Solution {
    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        if(str == null || str.length() == 0 || k == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int windowStart = 0, windowEnd = 0, maxLen = 0;
        int i = 0, j = 0;
        while(i < str.length() && j < str.length() && windowStart <= windowEnd) {
            while(windowEnd < str.length() && (map.size() < k || map.containsKey(str.charAt(i)))) {
                map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
                i++;
                windowEnd++;
            }
            maxLen = Math.max(maxLen,windowEnd-windowStart);
            while(windowStart < str.length() && map.size() >= k) {
              int val = map.get(str.charAt(j));
              if(val > 1)
                map.put(str.charAt(j),val-1);
              else 
                map.remove(str.charAt(j));
              j++;
              windowStart++;
            }
        }
      return maxLen;  
    }
}
/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/