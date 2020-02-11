/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/

// Time complexity: O(NM) where N number of strings, M is the length of the string
// Space complexity: O(1) as we only have O(1) auxilliary space. List of lists is for result and is not considered auxilliary space
// Submission on leetcode successful: Yes

/*
Algorithm:
=========
1. Use prime factorization to store 26 letters, as there is restriction that only lower case are permitted.
2. Store prime factor as key and list of words with same prime factor as values 
3. Return the list of lists of anagrams
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case
        if(strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();
        
        int[] primes = new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71, 73,79,83,89,97,101};
        
        Map<Long, List<String>> wordMap = new HashMap<Long, List<String>>();
        
        for(int i = 0; i < strs.length; i++) {
            // calculate prime factor for every string
            Long key = calcPrimeFactor(primes,strs[i]);
            
            if(!wordMap.containsKey(key)) {
                wordMap.put(key, new ArrayList<String>());
            }
            // add the words to the map with prime factor as key and list of anagram strings as values
            wordMap.get(key).add(strs[i]);
        }
        
        return new ArrayList<>(wordMap.values());
    }
    
    private Long calcPrimeFactor(int[] primes, String str) {
        Long factor = 1L;
        
        for(int i = 0; i < str.length(); i++) 
            factor *= primes[str.charAt(i) - 'a'];
        
        return factor;
    }
}