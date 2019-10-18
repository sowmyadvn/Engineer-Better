
/*
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
!!!!!!!TIME :IMIT EXCEEDED!!!!!!!!!
*/
class Solution {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        int count = 1;
        for(int i = 3; i < n; i+=2) {
            count += isPrime(i)?1:0;
        }
        return count;
    }
    
    private boolean isPrime(int n) {
        for(int i = 2; i < n/2; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(notPrime[i] == false)
                count++;
            for(int j = 2; i*j < n; j++) {
                notPrime[i*j] = true;
            }
        }
        return count;
    }
}