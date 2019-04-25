/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length();i++) {
            if(map.containsKey(s.charAt(i)))
               map.put(s.charAt(i),-1);
             else
               map.put(s.charAt(i),i);
        }
        int index = -1;
        for(Map.Entry<Character,Integer> entry: map.entrySet()) {
            if(entry.getValue() != -1) {
                index = entry.getValue();
                break;
            }
            
        }               
        return index;
    }
}