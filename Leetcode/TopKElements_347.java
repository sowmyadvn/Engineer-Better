class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>(Collections.reverseOrder());
        Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int i : nums) {
            map2.put(i, map2.getOrDefault(i,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry: map2.entrySet()) {
            int val = entry.getValue();
            if(map.get(val) == null) 
                map.put(val, new ArrayList<Integer>());
            map.get(val).add(entry.getKey());
        }
        int ct = 0;
        List<Integer> topK = new ArrayList<Integer>();
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()) {
            for(int i: entry.getValue()) {
                if(ct < k) {
                    topK.add(i);
                    ct++;
                }
                else 
                    return topK;
            }
         }
        
        return topK;
    }
}

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}