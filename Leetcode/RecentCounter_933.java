/*
Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.

 

Example 1:

Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
Output: [null,1,2,3,3]
*/
class RecentCounter {

    List<Integer> stampList;
    public RecentCounter() {
        //Store all new incoming requests in queue
        stampList  = new ArrayList<Integer>();
    }
    
    public int ping(int t) {
        int count = 0;
        stampList.add(t);
        //Check if current time stamp-old time stamp <= 3000 and increment count if it is.
        for(int i=0; i < stampList.size(); i++) {
            if(t-stampList.get(i) <= 3000)
                count++;
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);

 Analysis: This approach is super slow and consumes lot of memory. So, a better approach would be to use queue. Above approach 
 took 512ms to run
 */

 class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }
    
    public int ping(int t) {
        queue.add(t);
        //queue size will always be current. That is only 3000 and below timestamp pings list stay
        while(queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */