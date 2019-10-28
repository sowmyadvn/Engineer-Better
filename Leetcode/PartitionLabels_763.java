class Solution {
    public List<Integer> partitionLabels(String S) {
       if(S == null || S.length() == 0)
           return new ArrayList<Integer>();
        Map<Character,int[]> map = new LinkedHashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int[] range = map.getOrDefault(c,new int[]{-1,-1});
            if(range[0] == -1) {
                range[0] = i;
                range[1] = i;
            }
            else 
                range[1] = i;
            map.put(c,range);
        }
        
        int[] temp = null;
         List<Integer> result = new ArrayList<>();
        
        for(Map.Entry<Character,int[]> entry: map.entrySet()) {
            int[] curr = entry.getValue();
            if(temp == null)
                    temp = curr;
            else {
                if(curr[0] < temp[1]) 
                    temp = new int[]{temp[0],Math.max(temp[1],curr[1])};
                else {
                    result.add(temp[1]-temp[0]+1);
                    temp = curr;
                }
            }
        }
        result.add(temp[1]-temp[0]+1);
        return result;
    }
}
/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/