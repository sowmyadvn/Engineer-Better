class Solution {
    public String countAndSay(int n) {
        int ct = 1,in = 1;
        String num = "1";
        while(ct < n) {
            in = 1;
            StringBuilder res = new StringBuilder();
            for(int i = 1; i < num.length(); i++) {
                if(num.charAt(i-1) == num.charAt(i)) 
                    in++;
                else {
                    res.append(""+Integer.toString(in)+num.charAt(i-1));
                    in = 1;
                }
            }
            res.append(""+Integer.toString(in)+num.charAt(num.length()-1));
            
            num = res.toString();
            ct++;
        }
        return num;
    }
}