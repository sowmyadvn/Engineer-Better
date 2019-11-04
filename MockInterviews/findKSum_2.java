import java.io.*;
import java.util.*;

class Solution {
  static int len = 0;
  static int[] findArrayQuadruplet(int[] arr, int s) {
    // your code goes here
    len = arr.length;
    Arrays.sort(arr);
    List<List<Integer>> nums = findArrayQuadruplet(arr,s,4,0);
    if(nums == null || nums.size() == 0) return new int[]{};
    List<Integer> result = nums.get(0);
    return new int[]{result.get(0),result.get(1),result.get(2),result.get(3)};
  }
  
  static List<List<Integer>> findArrayQuadruplet(int[] arr, int s, int k, int index) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(index >= len)
      return res;
    
    if(k == 2) {
      int i = index, j = len-1;
      while(i < j) {
        if(arr[i] == s-arr[j]) {
           List<Integer> temp = new ArrayList<Integer>();
          temp.add(arr[i]);
          temp.add(arr[j]);
          res.add(temp);
          
          while(i < j && arr[i] == arr[i+1]) i++;
          while(i < j && arr[j-1] == arr[j]) j--;
          i++;
          j--;
        }
        else if(arr[j] < s-arr[i]) i++;
        else j--;
      }
    }
    else {
      for(int i = index; i < len-k+1; i++) {
        List<List<Integer>> temp = findArrayQuadruplet(arr,s-arr[i],k-1,i+1);
        if(temp != null) {
          for(List<Integer> t: temp) {
            t.add(0,arr[i]);
          }
          res.addAll(temp);
        }
        while(i < len-1 && arr[i] == arr[i+1]) i++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
    int[] result = findArrayQuadruplet(arr,20);
    int[] expected = {0,4,7,9};
    for(int i = 0; i < result.length; i++) {
      if(expected[i] != result.length) System.out.println("Failed");
    }
    System.out.println("Success");
  }

}

//2nd approach

import java.io.*;
import java.util.*;

class Solution {
  
  static int[] findArrayQuadruplet(int[] nums, int target) {
    // your code goes here
     int len = nums.length;
     if(len < 4)
      return new int[]{};
    else if(len == 4) {
      int sum = 0;
      for(int i: nums) sum+= i;
      if(sum == target) return nums;
      else return new int[]{};
    }
        Arrays.sort(nums);
        for(int i = 0; i < len-4; i++) {
            for(int j = i+1; j < len-3; j++) {
                int r = target - (nums[i]+nums[j]);
                int low = j+1, high = len-1;
                while(low < high) {
                    if(nums[low] + nums[high] < r)
                        low++;
                    else if(nums[low]+nums[high] > r)
                        high--;
                    else {
                        return new int[] {nums[i],nums[j],nums[low],nums[high]};
                    }
                }
            }
        }
        return new int[]{};
  }

}