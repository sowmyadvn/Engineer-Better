import java.util.HashMap;
import java.util.Map;
/*
 * Google:
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 * 
 * Intuition: When a map has value to be arr[i], it means k-arr[i] is the key. So, return true as the pair is present
 * Complexity: Time:O(N) One pass, space: O(N) for Map
 */
public class AddUptoK1 {
	//Map to store numbers that sum up to k
	public boolean addUpK(int[] arr,int k) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i < arr.length; i++) {
			if(map.containsValue(arr[i]))
				return true;
			else {
				map.put(arr[i], k-arr[i]);
			}
		}
		return false;
	}
}
