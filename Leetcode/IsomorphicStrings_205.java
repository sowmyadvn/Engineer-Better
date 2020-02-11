/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/



// Time complexity: O(N) where N is number of characters in string
// Space complexity: O(1) as we only have 256 characters that we can create mapping to
// Submission on leetcode successful: Yes


/*
1. Store character arrays for s,t to check if a maps b, b also maps a and that all mappings are valid. 
2. If so, they are considered isomorphic, else return false
*/
class Solution {
    
    char[] sMap = new char[256];
    char[] tMap = new char[256];
    
    public boolean isIsomorphic(String s, String t) {
        if( s == null || t == null) 
            return false;
        int slen = s.length();
        
        //Unmatched string lengths
        if(slen != t.length())
           return false;
        
        //Check if all chars in s array to different chars in t
        for(int i = 0; i < slen; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if(sMap[sChar - ' '] == 0) 
                sMap[sChar - ' '] = tChar;
            else {
                if(sMap[sChar - ' '] != tChar) return false;
            }
            
            //Check if all chars in t array to different chars in s
            if(tMap[tChar - ' '] == 0) 
                tMap[tChar - ' '] = sChar;
            else {
                if(tMap[tChar - ' '] != sChar) return false;
            }
        }
        return true;
    }
}


/*
1. Store character maps for s,t to check if all mappings (both a->b and b->a) are valid. 
2. If so, they are considered isomorphic, else return false
*/
class Solution {
    
    Map<Character, Character> sMap = new HashMap<>();
    Map<Character, Character> tMap = new HashMap<>();
    
    public boolean isIsomorphic(String s, String t) {
        if( s == null || t == null) 
            return false;
        int slen = s.length();
        
        //Unmatched string lengths
        if(slen != t.length())
           return false;
        
        //Check if all chars in s map to different chars in t
        for(int i = 0; i < slen; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // add key-value pair if not found
            if(!sMap.containsKey(sChar)) 
                sMap.put(sChar, tChar);
            else {
                // unmatched mappings - not isomorphic
                if(!(sMap.get(sChar).equals(tChar))) 
                   return false;
            }
            
            //Check if all chars in t map to different chars in s
            if(!tMap.containsKey(tChar)) 
                tMap.put(tChar, sChar);
            else {
                if(!(tMap.get(tChar).equals(sChar))) 
                   return false;
            }
        }
        return true;
    }
}




