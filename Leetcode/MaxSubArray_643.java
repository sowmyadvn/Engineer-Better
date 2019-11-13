class Solution {
    public double findMaxAverage(int[] nums, int k) {
        List<Double> res = new ArrayList<>();
        int ksum = 0;
        for(int i = 0; i < k; i++) {
            ksum += nums[i];
        }
        res.add(ksum*1.0/k);
        double max = res.get(0);
        for(int j = 0; j < nums.length-k; j++) {
            ksum = ksum-nums[j]+nums[j+k];
            double cur = ksum*1.0/k;
            res.add(cur);
        }
        
        return Collections.max(res);
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int ksum = 0;
        for(int i = 0; i < k; i++) {
            ksum += nums[i];
        }
        double max = (ksum*1.0/k);
        
        for(int j = 0; j < nums.length-k; j++) {
            ksum = ksum-nums[j]+nums[j+k];
            double cur = ksum*1.0/k;
            if(cur > max)
                max = cur;
        }
        
        return max;
    }
}

/*
1 12 -5 -6 50 3 12 k = 4

1+12-5-6 = 2/4  // 0

2-1+50 = 51/4 = 12.75

51-12+3 = 42/4 = 10.5

42+5+12 = 59/4 = 14.75
*/

/*
1 12 -5 -6 50 3 12 k = 4

1+12-5-6 = 2/4  // 0

2-1+50 = 51/4 = 12.75

51-12+3 = 42/4 = 10.5

42+5+12 = 59/4 = 14.75
*/

/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array wi
*/