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