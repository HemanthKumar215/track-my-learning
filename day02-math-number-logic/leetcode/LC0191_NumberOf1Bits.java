/*
 * LeetCode 191 · Number of 1 Bits · Easy
 * Done on: Thu 12 Nov 2026
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Question: Count the 1s in the binary form of n.
 * Examples: 11 (1011) -> 3; 128 (10000000) -> 1
 *
 * Approach: the digit loop in binary.
 *   n % 10 (last digit)  ->  n & 1   (last bit)
 *   n / 10 (drop digit)  ->  n >>> 1 (drop bit)
 * Use >>> (fills with 0) not >> (copies the sign bit -> negative n never reaches 0).
 * Brackets matter: (n & 1) == 1, because == binds tighter than &.
 * Time O(32) = O(1), Space O(1)
 * Faster: n = n & (n - 1) removes the lowest 1-bit, so the loop runs once per 1-bit.
 *
 * My mistake (fixed): checked n % 10 == 1 (a decimal digit, not a bit; fails for 13 = 1101).
 */
public class LC0191_NumberOf1Bits {

    static class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) count++;
                n = n >>> 1;
            }
            return count;
        }

        public int hammingWeightKernighan(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(11) + " " + s.hammingWeight(128) + " " + s.hammingWeight(13));   // 3 1 3
        System.out.println(s.hammingWeightKernighan(11) + " " + s.hammingWeight(-1));                      // 3 32
    }
}
