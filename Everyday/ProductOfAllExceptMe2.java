/* 
Uber:

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/


public class ProductOfAllExceptMe2 {
	public int[] calculateProductExceptMe(int[] arr) {
		boolean zero = false;
		int prod = 1;
		//Check for zero and set flag
		for(int i=0; i < arr.length; i++) {
			if(arr[i] != 0)
				prod *= arr[i];
			else
				zero = true;
		}
		
		if(!zero) {
			for(int i=0;i < arr.length;i++) {
			//If zero flag not set, no divide by zero exception
				arr[i] = prod/arr[i];
			}
		}
			
		else {
			for(int i = 0; i < arr.length; i++) {
			//Make sure not to divide by zero
				if(arr[i] != 0)
					arr[i] = 0;
				else
					arr[i] = prod;
			}
		}
		return arr;
	}
}


