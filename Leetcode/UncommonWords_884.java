/*
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

 

Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]

*/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] aWords = A.split(" ");
        String[] bWords = B.split(" ");
        //map to store word and frequency of occurrence
        Map<String,Integer> map = new HashMap<String,Integer>();
        if(!A.equals(""))
            insertIntoMap(map,aWords);
        if(!B.equals(""))
            insertIntoMap(map,bWords);
        //Check if frequency is 1 and append to list
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1)
                list.add(entry.getKey());
        }
        return  list.toArray(new String[list.size()]);
    }
    //Insert words from two arrays into the map
    public void insertIntoMap(Map<String,Integer> map, String[] aWords) {
        for(int i = 0; i < aWords.length; i++) {
            if(map.get(aWords[i]) == null)
                    map.put(aWords[i],1);
                else {
                    int val = map.get(aWords[i]);
                    val++;
                    map.put(aWords[i],val);
                }
            }
    }
}