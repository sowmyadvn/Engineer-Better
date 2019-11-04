/************************************** YET TO FIX ***************************************/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int interval = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char i: tasks) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int uniq = n+1,diff = 0;
        if(tasks.length <= n) 
            diff = 0;
        else {
            diff = ;
        }
        
        while(!map.isEmpty()) {
            int temp = uniq; 
            Iterator<Map.Entry<Character,Integer>> iter = map.entrySet().iterator();
            while(iter.hasNext() && temp > 0) {
                Map.Entry<Character,Integer> entry = iter.next(); 
                System.out.println(entry.getKey()+" "+interval);
                if(entry.getValue() == 1) {
                    iter.remove();
                } 
                else {
                    int val = entry.getValue();
                    entry.setValue(--val); 
                }
                interval++;
                temp--;
            }
            if(temp > 0 && !map.isEmpty()) {
                interval += temp;
            }
        }
        return interval;
    }
}

/*
<A,5>,<B,2>,<C,1>
A->B->A->B->A->C->idle->idle->A

A,B,C,A,B,idle,A,idle,idle,A,idle,idle,A
A 0 B 1 C 2 A 3 B 4 A 6 A 8 A 10

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/