import java.util.Arrays;

/*
 * LeetCode 268 · Missing Number · Easy
 * Done on: Thu 12 Nov 2026
 * https://leetcode.com/problems/missing-number/
 *
 * Question: nums has n distinct numbers from the range 0..n; one is missing. Return it.
 * Examples: [3,0,1] -> 2; [0,1] -> 2; [9,6,4,2,3,5,7,0,1] -> 8
 *
 * Approaches:
 *   Brute force: for each i in 0..n, search the array          O(n^2) time, O(1) space
 *   Sort + gap (mine): first i with nums[i] != i, else n         O(n log n) time, O(1) space
 *   Sum formula (mine): n(n+1)/2 - actual sum                    O(n) time, O(1) space
 *   XOR: x = n ^ (all i) ^ (all nums[i]); pairs cancel            O(n) time, O(1) space, no overflow
 *
 * My mistakes (fixed):
 *   - first idea was min/max: the range is already known (0..n), and it fails when the
 *     missing number is at an end ([0,1] -> 2, [1,2,3] -> 0)
 *   - returned i after the loop: i only exists inside the for loop (scope) -> return nums.length
 *   - the "not found inside the array" answer (n) goes AFTER the loop, never as an else inside it
 * Overflow: n <= 10^4 on LeetCode so n(n+1) fits in int; for larger n use long or XOR.
 */
public class LC0268_MissingNumber {

    static class Solution {
        public int missingNumberSort(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) return i;
            }
            return nums.length;
        }

        public int missingNumber(int[] nums) {
            int n = nums.length;
            int result = 0;
            int missing;
            int sum = n * (n + 1) / 2;
            for (int i = 0; i < n; i++) {
                result += nums[i];
            }
            missing = sum - result;
            return missing;
        }

        public int missingNumberXor(int[] nums) {
            int x = nums.length;
            for (int i = 0; i < nums.length; i++) x ^= i ^ nums[i];
            return x;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{3, 0, 1}) + " " + s.missingNumber(new int[]{0, 1})
                + " " + s.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));            // 2 2 8
        System.out.println(s.missingNumberSort(new int[]{3, 0, 1}) + " " + s.missingNumberSort(new int[]{0, 1})
                + " " + s.missingNumberXor(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));         // 2 2 8
    }
}
