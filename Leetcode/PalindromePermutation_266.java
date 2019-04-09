/*

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
*/
class Solution {
    public boolean canPermutePalindrome(String s) {
        int palct = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if(map.get(chr) != null) {
                int val = map.get(chr);
                map.put(chr,++val);
            }
            else
                map.put(chr,1);
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()%2 != 0)
                palct++;
        }   
        if(palct <= 1)
            return true;
        
        return false;
    }
}