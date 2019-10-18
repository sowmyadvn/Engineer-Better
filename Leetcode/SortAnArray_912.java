class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    
    private void quickSort(int[] nums, int begin, int end) {
        if(begin < end) {
            int partitionIndex = partition(nums,begin,end);
            quickSort(nums, begin, partitionIndex-1);
            quickSort(nums,partitionIndex+1,end);
        }
    }
    
    private int partition(int[] nums, int begin, int end) {
        int pivot = nums[end];
        int i = begin-1;
        for(int j = begin; j < end; j++) {
            if(nums[j] <= pivot) {
                i++;
                
                int swapTemp = nums[i];
                nums[i] = nums[j];
                nums[j] = swapTemp;
            }
        }
        int swapTemp = nums[end];
        nums[end] = nums[i+1];
        nums[i+1] = swapTemp;
        
        return i+1;
    }
}

/*
Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
 

Note:

1 <= A.length <= 10000
-50000 <= A[i] <= 50000
*/

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,nums.length);
        return nums;
    }
    
    private void mergeSort(int[] nums, int n) {
        if(n < 2) return;
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];
        
        for(int i=0; i < mid; i++)
            l[i]=nums[i];
        for(int i = mid; i < n; i++)
            r[i-mid] = nums[i];
        
        mergeSort(l,mid);
        mergeSort(r,n-mid);
        merge(nums,l,r,mid,n-mid);
    }
    
    private void merge(int[] nums,int[] l,int[] r,int left, int right) {
        int i = 0, j = 0, k = 0;
        while(i < left && j < right) {
            if(l[i] < r[j]) {
                nums[k++] = l[i++];
            }
            else
                nums[k++] = r[j++];
        }
        
        while(i < left) {
            nums[k++] = l[i++];
        }
        
        while(j < right) {
            nums[k++] = r[j++];
        }
    }
}