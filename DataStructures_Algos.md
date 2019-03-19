# Cracking the Coding Interview

## 1. Arrays and Strings

## 2. LinkedLists

## 3. Stacks and queues

## 4. Trees and graphs

## 5. Bit Manipulation

### 2's Complement:
-K is represented as concat(1, 2 power N-1 - K) => -3 is represented as concat(1,8-3) = concat(1,5) = 1101, where N is number of bits

### Arithmetic vs Logical right shift:
Logical right shift ```>>>``` doesn't care the sign 10110101 >>> 1 => 01011010
Arithmetic right shift does care about it 10110101 >> 1 => 11011010

### Common bit tasks: Getting and setting:
1. **GET ith bit**: ``` (num & (1 << i)) ```
2. **SET ith bit**: ``` (num | (1 << i)) ```
3. **Clear ith bit**: ```(num & (~(1 << i))) ```
4. **Clear MSB to ith bit**:  ``` num & ((1 << i)-1)```
5. **Clear LSB to ith bit**: ``` num & (-1 << (i+1))```
6. **Update ith bit**: ``` num & (~(1 << i)) | (value << i)```

### Tips: 
1. Addition: When two equal values are added, eg. ```0110+0110``` = (0110)*2 => ```Shift the value left once``` => 1100 
2. Multiplication: 0100*0011 => 0100 is 4 => ```Left shift other value by 2``` => 0011 becomes 1100 
3. XOR: a ^ ~a = ```all 1's``` (x ^ 0 = x, x^ 1 = ~x, x ^ x = 0)
4. Negation: ~0 = ``` All 1's``` => 1111 << 2 => 1100
5. AND: ( x& 0 = 0, x & 1 = x, x & x = x)
6. OR: (x | 0 = x, x | 1 = 1, x | x = x)

## 6. Math and Logic Puzzles

## 7. Object Oriented Design

## 8. Recursion and dynamic programming
# Dynamic Programming Notes, Tips and Tricks
Dynamic Programming is: Recursion + Memoization (to prevent redoing the sub-problems).

Three kinds:
1. Top-down: Do for N and break it to multiple sub-problems
2. Bottom-up: Do for 1 and build until you get for N
3. Half-and-half: Reduce the possibilities to half every single time

Let's consider fibonacci for top-down and bottom-up to better understand.

Question: Compute nth fibonacci number
### 1. Top-down approach
```
int fibonacci(int n) {
	return fibonacci(n, new int[n+1]);
}

int fibonacci(int i,int[] memo) {
	if(i == 0 || i == 1) 
		return i;
	if( memo[i] == 0)
		fibonacci(i) = fibonacci(i-1, memo)+fibonacci(i-2, memo);

	return memo[i];
}
```

### 2. Bottom-up approach
To use memoization for bottom-up:

```
int fibonacci(int n) {
	if(n == 0 || n == 1)
		return n;
	memo[0] = 0;
	memo[1] = 1;
	for(int i = 2; i < n; i++) {
		memo[i] = memo[i-1]+memo[i-2];
	}

	return memo[n-1]+memo[n-2];

}

```
Approach without recursion and memoization:

```
int fibonacci(int n) {
	if(n == 0 || n == 1)
		return n;
	int a = 0, b = 1,c = 0;
	for(int i = 2; i < n; i++) {
		c = a + b;
		a = b;
		b = c;
	}
	return c;
}
```
### 3. Half-and-half approach
Half-and-half approach is where dataset is divided into half. Merge-sort and binary search are examples of half-and-half approach.
### Tips:
1. How to identy DP problems? "Design algorithm to compute nth", "Write code to list the first n", "Implement a method to calculate all" etc
2. Draw the recursive calls as a tree to analyze the run-time complexity for recursion algorithms
3. Before diving into recursive code, discuss trade-offs of iterative code and then choose between both the approaches


## 9. System design and scalability

## 10. Sorting and searching

## 11. Testing

## 12. C and C++

## 13. Java