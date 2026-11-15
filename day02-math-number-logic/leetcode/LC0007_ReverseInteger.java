/*
 * LeetCode 7 · Reverse Integer · Medium
 * Done on: Fri 13 – Sun 15 Nov 2026
 * https://leetcode.com/problems/reverse-integer/
 *
 * Question: Reverse the digits of a 32-bit int; return 0 if the result overflows.
 * Examples: 123 -> 321, -123 -> -321, 120 -> 21, 1534236469 -> 0
 *
 * Approach: the digit loop with while (x != 0) so negatives work (Java's % keeps the sign:
 * -123 % 10 = -3). Before rev * 10 + d, check rev against Integer.MAX_VALUE / 10
 * (214748364) and Integer.MIN_VALUE / 10 (-214748364): if rev is already past them,
 * multiplying by 10 would overflow, so return 0. No long needed.
 * Time O(log n), Space O(1)
 *
 * Trace 120: rev 0 -> 2 -> 21 (the trailing zero disappears on its own).
 * My notes: worked out the limits; writing Integer.MAX_VALUE / 10 is clearer than 214748364.
 */
public class LC0007_ReverseInteger {

    static class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int d = x % 10;
                if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) return 0;
                rev = rev * 10 + d;
                x /= 10;
            }
            return rev;
        }

        public int reverseWithLong(int x) {          // simpler, but the problem disallows 64-bit
            long rev = 0;
            while (x != 0) { rev = rev * 10 + x % 10; x /= 10; }
            return (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) ? 0 : (int) rev;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int x : new int[]{123, -123, 120, 1534236469, -2147483648, 0})
            System.out.println(x + " -> " + s.reverse(x) + " " + s.reverseWithLong(x));
    }
}
