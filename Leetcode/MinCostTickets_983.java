class Solution {
    Set<Integer> set;
    int[] dp;
    int[] costs; 
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[366]; 
        set = new HashSet<>();
        this.costs = costs;
        // add travel days to the set for constant time search
        for(int day: days)
            set.add(day);
        
        return calculateCost(1);
    }
    
    private int calculateCost(int day) {
        if(day > 365)
            return 0; 
        
        if(dp[day] != 0)
            return dp[day];
        
        int total = 0;
        if(set.contains(day)) {
            total = Math.min(calculateCost(day+1) + costs[0],Math.min(calculateCost(day+7) + costs[1], calculateCost(day+30) + costs[2])); 
        }
        else
            total = calculateCost(day+1);
          
        dp[day] = total;
        return total;
    }
}