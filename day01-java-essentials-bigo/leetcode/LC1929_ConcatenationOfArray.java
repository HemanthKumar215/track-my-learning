import java.util.Arrays;

/*
 * LeetCode 1929 · Concatenation of Array · Easy
 * Done on: Wed 11 Nov 2026
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * Question: Return ans of length 2n with ans[i] = ans[i + n] = nums[i] (nums written twice).
 * Examples: [1,2,1] -> [1,2,1,1,2,1]; [1,3,2,1] -> [1,3,2,1,1,3,2,1]
 *
 * My approach: outer loop runs 2 times (copy nums twice), write pointer count moves forward.
 *   Change 2 to k to write nums k times.
 * Single-loop version: ans[i] = nums[i]; ans[i + n] = nums[i];
 * Time O(n) (2n steps: the outer loop is a fixed 2, so nested does NOT mean n^2), Space O(n)
 */
public class LC1929_ConcatenationOfArray {

    static class Solution {
        public int[] getConcatenation(int[] nums) {
            int n = nums.length;
            int[] ans = new int[2 * n];
            int count = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    ans[count] = nums[j];
                    count++;
                }
            }
            return ans;
        }

        public int[] getConcatenationOneLoop(int[] nums) {
            int n = nums.length;
            int[] ans = new int[2 * n];
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i];
                ans[i + n] = nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getConcatenation(new int[]{1, 2, 1})));            // [1, 2, 1, 1, 2, 1]
        System.out.println(Arrays.toString(s.getConcatenationOneLoop(new int[]{1, 3, 2, 1})));  // [1, 3, 2, 1, 1, 3, 2, 1]
    }
}
