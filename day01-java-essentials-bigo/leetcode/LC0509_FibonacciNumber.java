/*
 * LeetCode 509 · Fibonacci Number · Easy                     Status: Independent
 * Done on: Wed 11 Nov 2026
 * https://leetcode.com/problems/fibonacci-number/
 *
 * Question: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2). Return F(n).
 * Examples: n = 2 -> 1, n = 4 -> 3, n = 10 -> 55
 *
 * Brute force: plain recursion fib(n-1) + fib(n-2) -> O(2^n) (recomputes the same values)
 * My approach: keep only the last two values a, b.
 *   Update order matters: a = b (old b) BEFORE b = c, otherwise a gets the new value.
 * Time O(n), Space O(1)
 *
 * Dry run n = 4:  a=0 b=1 | i=2: c=1 a=1 b=1 | i=3: c=2 a=1 b=2 | i=4: c=3 a=2 b=3 -> 3
 */
public class LC0509_FibonacciNumber {

    static class Solution {
        public int fib(int n) {
            if (n < 2) return n;
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }
            return b;
        }

        public int fibRecursive(int n) {            // O(2^n): only for comparison
            if (n < 2) return n;
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(2) + " " + s.fib(4) + " " + s.fib(10));   // 1 3 55
        System.out.println(s.fibRecursive(10));                            // 55
    }
}
