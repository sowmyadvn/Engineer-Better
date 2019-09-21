class Solution {
    public int calculateTime(String keyboard, String word) {
        //Distance is word[i]-curr. Iterate through word to calculate distance for finger to move
        int curr = 0, distance = 0;
        for(int i = 0; i < word.length(); i++) {
            int temp = keyboard.indexOf(word.charAt(i));
            distance += Math.abs(curr-temp);
            curr = temp;
        }
        return distance;
    }
}