class Solution {
    public int countCharacters(String[] words, String chars) {
        if(words.length == 0 || chars.length() == 0)
            return 0;
        int res = 0;
        Map<Character,Integer> set = new HashMap<>(), map = new HashMap<>();
        for(int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            set.put(c,set.getOrDefault(c,0)+1);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(int i = 0; i < words.length; i++) {
            set.putAll(map);
            int ct = 0;
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if(!set.containsKey(c))
                    continue;
                else {
                    if(set.get(c) == 1)
                        set.remove(c);
                    else {
                        int val = set.get(c);
                        set.put(c,--val);
                    }
                        
                    ct++;
                }
            }
            if(ct == words[i].length()) 
                res += ct;
        }
        return res;
    }
}

/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.
*/