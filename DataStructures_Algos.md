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
**GET ith bit**: ``` (num & (1 << i)) ```
**SET ith bit**: ``` (num | (1 << i)) ```
**Clear ith bit**: ```(num & (~(1 << i))) ```
**Clear MSB to ith bit**:  ``` num & ((1 << i)-1)```
**Clear LSB to ith bit**: ``` num & (-1 << (i+1))```
**Update ith bit**: ``` num & (~(1 << i)) | (value << i)```

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

## 9. System design and scalability

## 10. Sorting and searching

## 11. Testing

## 12. C and C++

## 13. Java