/*
 * LeetCode 9 · Palindrome Number · Easy
 * Done on: Fri 13 Nov 2026
 * https://leetcode.com/problems/palindrome-number/
 *
 * Question: Return true if integer x reads the same forwards and backwards.
 * Examples: 121 -> true, -121 -> false, 10 -> false
 *
 * Solution 1 (Day 2): reverse the whole number and compare. Risk: reversing a big int
 * (2147483647 -> 7463847412) overflows.
 * Solution 2 (optimal): reverse only the second half. Stop when x <= rev.
 *   even length 1221:  x = 12, rev = 12  -> x == rev
 *   odd length 12321:  x = 12, rev = 123 -> x == rev / 10 (drop the middle digit)
 * Guard: negatives, and numbers ending in 0 (except 0 itself), are never palindromes.
 * Time O(log n), Space O(1), no overflow.
 *
 * My notes: first suggested reversing the full number (works, but overflow risk);
 * traced the half-reversal loop correctly; return must be the boolean comparison,
 * not rev (an int).
 */
public class LC0009_PalindromeNumber {

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int rev = 0;
            while (x > rev) {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            return x == rev || x == rev / 10;
        }

        public boolean isPalindromeFullReverse(int x) {
            if (x < 0) return false;
            long rev = 0;                                // long avoids the overflow
            for (int t = x; t > 0; t /= 10) rev = rev * 10 + t % 10;
            return rev == x;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int x : new int[]{121, -121, 10, 1221, 12321, 123, 0, 2147483647})
            System.out.println(x + " " + s.isPalindrome(x) + " " + s.isPalindromeFullReverse(x));
    }
}
