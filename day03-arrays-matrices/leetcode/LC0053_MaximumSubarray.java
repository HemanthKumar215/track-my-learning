/*
 * LeetCode 53 · Maximum Subarray · Medium
 * Done on: Tue 17 – Thu 19 Nov 2026 (revision: re-solved)
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Question: find the contiguous subarray with the largest sum and return the sum.
 * Examples: [-2,1,-3,4,-1,2,1,-5,4] -> 6 ([4,-1,2,1]), [5,4,-1,7,8] -> 23, [-3,-1,-2] -> -1
 *
 * Solution 1 (brute force): start i, end j = i.., running sum in the inner loop. O(n^2).
 *   (Re-adding the block each time would be O(n^3).)
 * Solution 2 (Kadane): a NEGATIVE running sum can only drag down whatever comes next, so
 *   throw it away and restart at 0. A sum that dips but stays positive is kept.
 *   At each number: cur += num; if cur > best, best = cur; if cur < 0, cur = 0.
 *   num: -2  1 -3  4 -1  2  1 -5  4
 *   cur: -2  1 -2  4  3  5  6  1  5   (before reset)
 *   best:-2  1  1  4  4  5  6  6  6
 * Order matters: update best BEFORE the reset, and start best at nums[0] (not 0), or an
 * all-negative array like [-3,-1,-2] would wrongly return 0.
 * Time O(n), Space O(1).
 *
 * My notes: brute force mine, but first said "break when the sum drops" (wrong: 4 -> 3
 * still helps). Then said "stop when the sum goes negative" myself, which is Kadane's
 * key idea. Table slips: forgot cur carries over (wrote -3 instead of 4 + (-1) = 3), let
 * best go down, updated best one row late, mixed up the cur and best columns. Filled in
 * both conditions (cur > best, cur < 0) myself.
 */
public class LC0053_MaximumSubarray {

    static class Solution {
        public int maxSubArray(int[] nums) {
            int cur = 0;
            int best = nums[0];
            for (int i = 0; i < nums.length; i++) {
                cur = cur + nums[i];
                if (cur > best) best = cur;
                if (cur < 0) cur = 0;
            }
            return best;
        }

        public int maxSubArrayBrute(int[] nums) {
            int best = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum > best) best = sum;
                }
            }
            return best;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tests = {{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {5, 4, -1, 7, 8}, {-3, -1, -2}, {1}, {-1}};
        for (int[] t : tests) System.out.println(s.maxSubArray(t) + " " + s.maxSubArrayBrute(t));   // 6 23 -1 1 -1
    }
}
