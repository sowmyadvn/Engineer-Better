/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i = 0; i < sArr.length; i++) {
            if(sArr[i] != tArr[i])
                return false;
        }
        return true;
    }
}

/*
Approach: Convert to char array, sort and then compare. O(N log N) where N is length of the string.
Hash table approach can also be used. O(N) Time complexity.
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> smap = new HashMap<Character,Integer>();
        Map<Character,Integer> tmap = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(smap.containsKey(s.charAt(i))) {
                int key = smap.get(s.charAt(i));
                smap.put(s.charAt(i),++key);
                }
            else
                smap.put(s.charAt(i),1);
        }
        
        for(int i = 0; i < t.length(); i++) {
            if(tmap.containsKey(t.charAt(i))) {
                int key = tmap.get(t.charAt(i));
                tmap.put(t.charAt(i),++key);
                }
            else
                tmap.put(t.charAt(i),1);
        }
        
        if(smap.equals(tmap))
            return true;
        
        return false;

    }
}