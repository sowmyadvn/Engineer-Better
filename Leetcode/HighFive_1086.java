/*
Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.

Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.

 

Example 1:

Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 

Note:

1 <= items.length <= 1000
items[i].length == 2
The IDs of the students is between 1 to 1000
The score of the students is between 1 to 100
For each student, there are at least 5 scores
*/
class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < items.length; i++) {
            if(map.get(items[i][0]) != null) {
                map.get(items[i][0]).add(items[i][1]);
            }
            else  {
                map.put(items[i][0],new ArrayList<Integer>());
                map.get(items[i][0]).add(items[i][1]);
            }
        }

        for(int i = 0; i < items.length; i++) {
                Collections.sort(map.get(items[i][0]), Collections.reverseOrder());
        }
        int[][] result = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()) {
            int sum = 0;
            for(int k = 0; k < 5; k++) {
                sum+= entry.getValue().get(k);
            }
            result[i][0] = entry.getKey();
            result[i][1] = sum/5;
            i++;
        }
        return result;
    }
}


class Solution {
    public int[][] highFive(int[][] items) {
    
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        
       for(int[] item : items){
           int id = item[0];
           int score = item[1];
           
           if(!map.containsKey(id)){
               PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
               pq.offer(score);
               map.put(id, pq);
           }else{
               PriorityQueue<Integer> pq = map.get(id);
               pq.offer(score);
               if(pq.size() > 5){
                   pq.poll();
               }
               map.put(id, pq);
           }
       }
        
        int index = 0;
        
        int[][] res = new int[map.size()][2];
        
       for(int id : map.keySet()){
           
           res[index][0] = id;
        
           PriorityQueue<Integer> pq = map.get(id);
           int sum = 0;
           int size = pq.size();
           
           while(!pq.isEmpty()){
               sum+= pq.poll();
           }
         
           res[index][1] = sum/size;
           
           index++;
           
       }
        
      
        return res;
       
    }
}
