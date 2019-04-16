/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
*/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //Store alphalog+indices of occurrences
        Map<String,List<Integer>> map = new TreeMap<>();
        //to preserve order of numeric strings
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < logs.length; i++) {
            //Split each string into 2
            String[] temp = logs[i].split(" ",2);
            //Search for numbers: found? add index to list
            if(temp[1].matches(".*\\d.*"))
                list.add(i);
            //If not found, store in map, such that alphanumeric key is stored to the end
            else {
                String s = new String(temp[1]+" "+temp[0]);
                if(map.containsKey(s)) {
                    map.get(s).add(i);
                }
                else { 
                    //Indices with same key and value stored in innerList
                    List<Integer> innerList = new ArrayList<Integer>();
                    innerList.add(i);
                    map.put(temp[1]+" "+temp[0],innerList);
                }
            }
        }
        //Result array
        String[] result = new String[logs.length];
        int j = 0;
        //Create string builder and bring every string to original form
        //Now append to result n times, if size of inner list is n
        for(Map.Entry<String,List<Integer>> entry: map.entrySet()) {
            StringBuilder sb = new StringBuilder(entry.getKey());
            int count = entry.getValue().size();
            int pos = entry.getKey().lastIndexOf(" ");
            String key = entry.getKey().substring(pos+1);
            sb.delete(pos,entry.getKey().length());
            while(count != 0) {
                result[j++] = key+" "+sb.toString();
                count--;
            }
        }
        //Append digit logs
        for(int i: list) {
            result[j++] = logs[i];
        }
        return result;
     }
}
/*
Instead of sorting in the default order, we'll sort in a custom order we specify.

The rules are:

Letter-logs come before digit-logs;
Letter-logs are sorted alphanumerically, by content then identifier;
Digit-logs remain in the same order.
It is straightforward to translate these ideas into code.

*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}