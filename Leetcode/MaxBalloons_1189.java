class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
        }
        int val = map.get('o');
        map.put('o',val/2);
        val = map.get('l');
        map.put('l',val/2);
        int min = Integer.MAX_VALUE;
        for(int v: map.values()) {
            if(v == 0)
                return 0;
            if(v < min)
                min = v;
        }
        return min;
    }
}

class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] bal = new char[26];
        int count = 0;
        for(int i = 0; i < text.length();i++) 
            bal[text.charAt(i)-'a']++;
        
        while(true) {
            if(bal['b'-'a'] <= 0 || bal['a'-'a'] <= 0 || bal['l'-'a'] <= 1 || bal['o'-'a'] <= 1 || bal['n'-'a'] <= 0  ) 
                break;
            else {
                count++;
                bal['b'-'a']--;
                bal['a'-'a']--;
                bal['l'-'a'] -= 2;
                bal['o'-'a'] -= 2;
                bal['n'-'a']--;
            }
        }
        return count;
    }
}
/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only
*/