/*
 * Day 2 · Basic · Palindrome Number (full reverse)
 * Done on: Wed 11 Nov 2026
 *
 * Question: Return true if n reads the same forwards and backwards.
 * Examples: 121 -> true, 10 -> false, -121 -> false, 0 -> true
 *
 * Approach: reverse n with the digit loop and compare with the ORIGINAL value.
 * Time O(digits), Space O(1)
 *
 * My mistakes (fixed):
 *   - the buggy version compared n == rev, but the loop had already reduced n to 0
 *     -> save a copy (original) before the loop
 *   - first suggested "n = rev" (that is an assignment, not a comparison)
 *   - variable names must match exactly (original vs orginal -> "cannot find symbol")
 * Note: reversing a large int can overflow; LeetCode 9 reverses only half the digits.
 */
public class PalindromeNumber {

    static boolean isPalindrome(int n) {
        int original = n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return original == rev;
    }

    public static void main(String[] args) {
        for (int x : new int[]{121, 10, -121, 0})
            System.out.println(x + " " + isPalindrome(x));
    }
}
