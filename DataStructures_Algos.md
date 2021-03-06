# Cracking the Coding Interview

## 1. Arrays and Strings
An algorithm problem's input is often a string or array. Without auto-completion of any IDE, the following methods should be 
remembered.
```
toCharArray() //get char array of a String
charAt(int x) //get a char at the specific index
length() //string length
length //array size 
substring(int beginIndex) 
substring(int beginIndex, int endIndex)
Integer.valueOf()//string to integer
String.valueOf()/integer to string
Arrays.sort()  //sort an array
Arrays.toString(char[] a) //convert to string
Arrays.copyOf(T[] original, int newLength)
System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
String xStr = String.format("%32s", Integer.toBinaryString(x)).replace(' ','0'); //Int to Binary conversion (32-bit)
```
## 2. LinkedLists
The implementation of a linked list is pretty simple in Java. Each node has a value and a link to next node.
```
class Node {
	int val;
	Node next;
 
	Node(int x) {
		val = x;
		next = null;
	}
}
```
## 3. Stacks and queues

Two popular applications of linked list are stack and queue.

Stack
```
class Stack{
	Node top; 
 
	public Node peek(){
		if(top != null){
			return top;
		}
 
		return null;
	}
 
	public Node pop(){
		if(top == null){
			return null;
		}else{
			Node temp = new Node(top.val);
			top = top.next;
			return temp;	
		}
	}
 
	public void push(Node n){
		if(n != null){
			n.next = top;
			top = n;
		}
	}
}
```
Queue
```
class Queue{
	Node first, last;
 
	public void enqueue(Node n){
		if(first == null){
			first = n;
			last = first;
		}else{
			last.next = n;
			last = n;
		}
	}
 
	public Node dequeue(){
		if(first == null){
			return null;
		}else{
			Node temp = new Node(first.val);
			first = first.next;
			return temp;
		}	
	}
}
```
The Java standard library contains a class called "Stack". Another class from Java SDK is LinkedList, which can be used as a 
Queue (add() and remove()). (LinkedList implements the Queue interface.) If a stack or queue is required to solve problems 
during your interview, they are ready to be used.

## 4. Trees and graphs
### Traversals:
#### 1. Pre-order: Root, Left, Right
Applications:
 1. Retrieve sorted nodes in BST using in-order traversal
 2. Create a complete replica of the tree
 3. Prefix expression
```
1) Create an empty stack nodeStack and push root node to stack.
2) Do following while nodeStack is not empty.
….a) Pop an item from stack and print it.
….b) Push right child of popped item to stack
….c) Push left child of popped item to stack

Right child is pushed before left child to make sure that left subtree is processed first.
```
Recursive strategy:
```
Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
```
Leetcode approach pre-order:
```
Easier approach:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root != null) {
            s.push(root);
        }
        TreeNode cur;
        while (!s.empty()) {
            cur = s.pop();
            answer.add(cur.val);            // visit the root
            if (cur.right != null) {
                s.push(cur.right);          // push right child to stack if it is not null
            }
            if (cur.left != null) {
                s.push(cur.left);           // push left child to stack if it is not null
            }
        }
        return answer;
    }
}
```
### 2. Post-order: Left, Right, Root
Applications:
##### 1. Calculating the results of mathematical operations:
You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations. If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet a operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.
##### 2. Deleting the nodes in tree:
It is worth noting that when you delete nodes in a tree, deletion process will be in post-order. That is to say, when you delete a node, you will delete its left child and its right child before you delete the node itself.
 3. Postfix expression
```
1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child 
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
```
Recursive strategy:
```
Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
```
### 3. In-order: Left, Root, Right
Applications:
1. Check whether a tree is BST
```
Approach:
"When an inherently recursive problem has to be converted to iterative,explicit stack is required."
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
```
Recursive strategy:
```
Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
```
Note: For all the above, deque (double ended queue) can also be used
### 4. Level-order traversal or Breadth First Search
Typically uses QUEUE unlike other traversals, which uses STACK.
```
printLevelorder(tree)
1) Create an empty queue q
2) temp_node = root /*start from root*/
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node’s children (first left then right children) to q
    c) Dequeue a node from q and assign it’s value to temp_node
```
If level order traversal requires line-by-line results or list of lists returned, requires counting of nodes in every level:
```
1) Create an empty queue q
2) current = root, countNodes = q.size()
3) Loop while true:
   a) countNodes = q.size()
   b) if(countNodes == 0) then break;
   c) while(countNodes > 0):
       i. current = q.poll() and add to list
       ii. left != null? push to queue
       iii. right != null? push to queue
       iv. countNodes--;
   d) Add inner list to list of lists
4) return list of lists
```
Recursive strategy:
```
/*Function to print level order traversal of tree*/
printLevelorder(tree)
for d = 1 to height(tree)
   printGivenLevel(tree, d);

/*Function to print all nodes at a given level*/
printGivenLevel(tree, level)
if tree is NULL then return;
if level is 1, then
    print(tree->data);
else if level greater than 1, then
    printGivenLevel(tree->left, level-1);
    printGivenLevel(tree->right, level-1);
```
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
Recursion is a way to express a function, in terms of smaller instances of itself.

To understand it further, you need to internalize and practice the following ideas.

### Thinking of a problem in top to bottom manner.

Let’s say you need to sum up an array of numbers. One way to see it, is going through all numbers one by one and accumulating the sum in a variable. This is bottom to top approach.

Another way is thinking that, if somehow you can get the sum of all numbers in the array except last, you can find the final answer by adding that sum with the last number.

In fact, there are multiple ways to follow the top to bottom approach — you can also find the answer, by breaking the array in following pairs, and then adding their resultant sums.

1. first number, full array except first element
2. first half of the array, second half of the array
3. first third of the array, last two third of the array
4. second number, full array except second number
The list is endless. There are potentially infinite ways to break up a problem into sub-problems.

Before you delve into solving recursion problems in full, practice thinking in top to bottom manner. Try listing out multiple possible ways to do this for many problems.

### Finding and writing a recursive pattern.

Now, that you have practiced breaking the larger problem into smaller ones, try comparing the features of both larger and smaller problems, and see if you can find a pattern.

Let’s continue on our previous example of finding sum of an array. If we break it into last element and the whole array except last element, we can see the following features :

For larger problem (find sum of whole array) :
Input is array of numbers
1. We need to find sum of numbers at continuous indexes
2. First index to include in sum is 0
3. Last index to include is size(array) - 1

For smaller problem (find sum of whole array except last element) :
Input is array of numbers
1. We need to find sum of numbers at continuous indexes
2. First index to include in sum is 0
3. Last index to include is size(array) - 2
Once, you try to list out the features, you can easily see that there are certain commonalities, with only few feature, changing between them. The idea is to express the common parts using a function, whose parameters are the changing features. In this example, the changing feature is end index.

We can express the large problem as :

```sum( array, size(array)-1 )```
And the smaller one as :

```sum( array, size(array)-2 )```
The pattern is :

```sum( array, endIndex )```
Finally, we can express the recursion as :

```sum( array, endIndex ) = sum( array, endIndex-1 ) + array[ endIndex ]```
Again, practice listing out features of the problems, once you have broken them down, and try finding patterns. Since there are multiple ways of breaking down a problem, you will find out that not every strategy leads to good patterns, and also that there is more than one breaking strategy that will solve the problem.

### Finding the boundary of recursion.

In the above example, you can see, that to solve sum( array, 10 ), I need sum( array, 9 ), and then to solve that, sum( array, 8 ), and so on. Following the trend, try to see when the function parameters don’t make sense. We need to stop the recursion before that. In this example, it does not makes sense, if endIndex is negative. So, we can write :

sum( array, endIndex ) = if( endIndex >= 0 ) then: sum( array, endIndex-1 ) + array[ endIndex ] else: 0
Practice finding the trend of the function parameter, and not doing the recursive call, when you reach the invalid parameter state.

To become comfortable with concept of recursion, you need to practice solving problems.

### Dynamic Programming is: Recursion + Memoization (to prevent redoing the sub-problems).

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

## 9. System design and scalability

## 10. Sorting and searching

## 11. Testing

## 12. C and C++

## 13. Java
