class Solution {
    int len = 0; 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return fourSum(nums,target, 4, 0);
    }
    
    private List<List<Integer>> fourSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        if(index >= len)
            return arr;
        if(k == 2) {
            int j = len-1, i = index;
            while(i < j) {
                if( target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    arr.add(temp);
                    while(i < j && nums[i] == nums[i+1]) i++;
                    while(i < j && nums[j-1] == nums[j]) j--;
                    i++;
                    j--;
                }
                else if(target-nums[i] > nums[j]) {
                    i++;   
                }
                else {
                    j--;
                }
            }
        }
        else {
            for(int i = index; i < len-k+1; i++) {
                List<List<Integer>> temp = fourSum(nums,target-nums[i],k-1,i+1);
                if(temp != null) {
                    for(List<Integer> t : temp) {
                        t.add(0,nums[i]);
                    }
                    arr.addAll(temp);
                    
                    while(i < len-1 && nums[i] == nums[i+1]) i++;
                }
               
            }
        }
        return arr;
    }
}