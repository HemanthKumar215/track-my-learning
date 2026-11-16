/*
 * LeetCode 283 · Move Zeroes · Easy
 * Done on: Mon 16 Nov 2026 (revision: re-solved from memory)
 * https://leetcode.com/problems/move-zeroes/
 *
 * Question: move all 0s to the end of the array IN PLACE, keeping the relative order of
 * the non-zero numbers.
 * Examples: [0,1,0,3,12] -> [1,3,12,0,0], [0] -> [0], [1,2] -> [1,2]
 *
 * Solution 1 (extra array): copy non-zeros into a new int[] with a write index; the rest is
 *   already 0 because a new int[] starts filled with 0s. O(n) time, O(n) space. Not in place.
 * Solution 2 (in place, two passes): the write index writes into nums itself.
 *   Pass 1: copy every non-zero to nums[index], index++.
 *   Pass 2: from index to the end, set 0 (those slots still hold old values).
 *   Trace [0,1,0,3,12]: after pass 1 -> [1,3,12,3,12], index = 3 -> pass 2 -> [1,3,12,0,0]
 * Time O(n), Space O(1).
 *
 * My notes: planned the extra-array version first (and knew a new int[] is all zeros),
 * then worked out the second pass myself. Wrote the in-place code from memory with no bugs.
 */
import java.util.Arrays;

public class LC0283_MoveZeroes {

    static class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            for (int i = index; i < n; i++) {
                nums[i] = 0;
            }
        }

        public int[] moveZeroesExtraArray(int[] nums) {
            int[] res = new int[nums.length];
            int index = 0;
            for (int x : nums) if (x != 0) res[index++] = x;
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tests = {{0, 1, 0, 3, 12}, {0}, {1, 2}, {0, 0, 1}, {4, 0, 5, 0, 0, 6}};
        for (int[] t : tests) {
            int[] extra = s.moveZeroesExtraArray(t);
            s.moveZeroes(t);
            System.out.println(Arrays.toString(t) + " " + Arrays.toString(extra));
        }
    }
}
