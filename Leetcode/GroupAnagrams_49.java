class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res; 
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            
            if(map.get(s) == null)
                List<String> temp = new ArrayList<String>();
             map.get(s).add(strs[i]);
        }
        
        for(List<String> temp: map.values()) {
            res.add(temp);
        }
        return res;
    }
}
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/