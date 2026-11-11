import java.util.Arrays;

/*
 * LeetCode 1470 · Shuffle the Array · Easy                   Status: Independent
 * Done on: Mon 9 Nov 2026
 * https://leetcode.com/problems/shuffle-the-array/
 *
 * Question: nums = [x1..xn, y1..yn]; return [x1, y1, x2, y2, ..., xn, yn].
 * Example: [2,5,1,3,4,7], n = 3 -> [2,3,5,4,1,7]
 *
 * My approach: a write pointer k; each iteration writes nums[i] then nums[i+n] at k++.
 *   (res[k++] = x writes at k, THEN increases k: post-increment)
 * Formula version: res[2i] = nums[i] (x's at even indices), res[2i+1] = nums[i+n] (y's at odd).
 * Time O(n), Space O(n)
 */
public class LC1470_ShuffleTheArray {

    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[2 * n];
            int k = 0;
            for (int i = 0; i < n; i++) {
                res[k++] = nums[i];
                res[k++] = nums[i + n];
            }
            return res;
        }

        public int[] shuffleFormula(int[] nums, int n) {
            int[] res = new int[2 * n];
            for (int i = 0; i < n; i++) {
                res[2 * i] = nums[i];
                res[2 * i + 1] = nums[i + n];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));          // [2, 3, 5, 4, 1, 7]
        System.out.println(Arrays.toString(s.shuffleFormula(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4))); // [1, 4, 2, 3, 3, 2, 4, 1]
    }
}
