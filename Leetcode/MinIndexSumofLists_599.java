/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.

*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> alist = new ArrayList<String>();
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++) {
            if(Arrays.asList(list2).contains(list1[i])) {
                int j = Arrays.asList(list2).indexOf(list1[i]);
                if(i+j < sum) {
                    sum = i+j;
                    if(alist.size() > 0)
                        alist.remove(alist.size()-1);
                    alist.add(list1[i]);
                } 
                else if (i+j == sum) {
                    alist.add(list1[i]);
                }
            }
        }
        String[] strarr = new String[alist.size()];
        for(int i = 0; i < alist.size();i++) {
            strarr[i] = alist.get(i);
        }
        return strarr;
    }
}