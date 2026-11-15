/*
 * LeetCode 50 · Pow(x, n) · Medium
 * Done on: Sun 15 Nov 2026
 * https://leetcode.com/problems/powx-n/
 *
 * Question: compute x^n, where x is a double and n is any int (it can be negative).
 * Examples: (2.0, 10) -> 1024.0, (2.1, 3) -> 9.261, (2.0, -2) -> 0.25
 *
 * Approach: a negative power means "1 over": x^-n = (1/x)^n. So flip x to 1/x and make the
 * exponent positive ONCE in myPow, then run the plain fast power.
 * Trap: n = -2147483648. -n does not fit in an int (max 2147483647), so it wraps back to
 * -2147483648. Copy n into a long FIRST, then negate it.
 * Time O(log n), Space O(log n) recursive / O(1) iterative.
 *
 * My notes:
 *   - 2^-2 = 1/4 = 0.25, and flipping x plus negating n: got both
 *   - knew the fix for the overflow is long
 *   - first put 1/ inside the recursive helper -> it gets applied at every level
 *     (pow(2,4) came out as 0.0625). The sign is handled once, outside.
 *   - forgot the base case (e == 0) and the braces { } around the if block
 */
public class LC0050_PowXN {

    static class Solution {
        public double myPow(double x, int n) {
            long e = n;              // copy first, outside the if
            if (e < 0) {
                x = 1 / x;           // flip the base
                e = -e;              // safe, because e is a long
            }
            return pow(x, e);
        }

        private double pow(double x, long e) {
            if (e == 0) return 1;
            double half = pow(x, e / 2);
            if (e % 2 == 0) return half * half;
            else            return half * half * x;
        }

        // Iterative version (O(1) space): read the exponent's bits from the right.
        public double myPowIterative(double x, int n) {
            long e = n;
            if (e < 0) { x = 1 / x; e = -e; }
            double res = 1;
            while (e > 0) {
                if ((e & 1) == 1) res *= x;   // this bit is on -> include the current power
                x *= x;                       // x, x^2, x^4, x^8, ...
                e >>= 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double[][] tests = {{2.0, 10}, {2.1, 3}, {2.0, -2}, {1.0, -2147483648}, {2.0, -2147483648}, {0.5, 0}};
        for (double[] t : tests) {
            int n = (int) t[1];
            System.out.println(t[0] + "^" + n + " = " + s.myPow(t[0], n) + "  " + s.myPowIterative(t[0], n));
        }
    }
}
