/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairs(n,memo);
    }
    
    private int climbStairs(int n, int[] memo) {
        if(n == 1 || n == 2 || n == 0)
            memo[n] = n;
        if(memo[n] == 0) 
            memo[n] = climbStairs(n-1,memo)+climbStairs(n-2,memo);
        
        return memo[n];
    }
    
}

//Bottom-up
public int climbStairs(int n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int one_step_before = 2;
    int two_steps_before = 1;
    int all_ways = 0;
    
    for(int i=2; i<n; i++){
    	all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
        one_step_before = all_ways;
    }
    return all_ways;
}