class Solution {
    public String getHint(String secret, String guess) {
        int b = 0, c = 0;
        StringBuilder sb = new StringBuilder(secret);
        StringBuilder sc = new StringBuilder(guess);
        int i = 0;
        while(i < sb.length()) {
            if(sb.charAt(i) == sc.charAt(i)) {
                sb.deleteCharAt(i);
                sc.deleteCharAt(i);
                b++;
            }
            else
                i++;
        }
        i = 0;
        while(i < sb.length()) {
            if(sc.toString().contains(""+sb.charAt(i))) {
                int index = sc.indexOf(""+sb.charAt(i));
                sc.deleteCharAt(index);
                sb.deleteCharAt(i);
                c++;
            }
            else
                i++;
        }
        return b+"A"+c+"B";
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int b = 0,  c= 0;
        int[] nums = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) b++;
            else {
                if(nums[secret.charAt(i)-'0']++ < 0) c++;
                if(nums[guess.charAt(i)-'0']-- > 0) c++;
            }
        }
        return b+"A"+c+"B";
    }
}

/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
*/