/*
ˇime: O(S+T)
Space: O(S+T)
Algorithm:
=========
1. Develop stringbuilder after deleting unnecessary # and characters
2. Compare both the strings now and return false if not matching
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S == null || T == null)
            return false;
        if(S.length() == 0 && T.length() == 0)
            return true; 
        if(S.length() == 0 || T.length() == 0)
            return false;
        
        StringBuilder sb1 = developString(S); 
        StringBuilder sb2 = developString(T); 
        
        return sb1.toString().equals(sb2.toString()); 
    }
    
    // create stringbuilder for backspace string
    private StringBuilder developString(String str) {
        int len = str.length(); 
        StringBuilder sb = new StringBuilder(); 
        
        for(int i = 0; i < len; i++) {
            int sblen = sb.length(); 
            char c = str.charAt(i); 
            // check if char is # and there is valid char to delete in stringbuilder 
            //append to stringbuilder if char is not #
            if(i == 0) {
                if(str.charAt(i) != '#') {
                    sb.append(c); 
                }
            }
            else if(str.charAt(i) == '#') {
                if(sblen > 0)
                    sb.deleteCharAt(sblen-1); 
            }
            else 
                sb.append(c); 
        }
        return sb; 
    }
}

/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/