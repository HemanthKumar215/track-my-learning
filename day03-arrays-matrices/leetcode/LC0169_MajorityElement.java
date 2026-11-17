/*
 * LeetCode 169 · Majority Element · Easy
 * Done on: Tue 17 Nov 2026 (revision: re-solved)
 * https://leetcode.com/problems/majority-element/
 *
 * Question: return the element that appears more than n/2 times (it always exists).
 * Examples: [2,2,1,1,1,2,2] -> 2, [3,2,3] -> 3, [1] -> 1
 *
 * Solution 1: count each element (O(n^2)), or a HashMap of counts (O(n) time, O(n) space).
 * Solution 2 (Boyer–Moore voting): keep a candidate and a count.
 *   count == 0 -> the current number becomes the candidate
 *   same as candidate -> count++, different -> count--
 *   Every non-majority number (whatever its value) cancels at most one majority vote, and
 *   the majority has more than half the votes, so it is always left at the end.
 *   Trace [2,2,1,1,1,2,2]: (2,1) (2,2) (2,1) (2,0) (1,1) (1,0) (2,1) -> 2
 *   Without a guaranteed majority ([1,2,3] -> 3) you would need a second pass to verify.
 * Time O(n), Space O(1).
 *
 * My notes: remembered the +1 / -1 idea myself. First thought count goes to -1 when it hits
 * 0 (it must restart with a new candidate instead). Asked whether it works with more than
 * two different values (yes). First code checked count == 0 AFTER the vote and started
 * count at 0 with candidate = nums[0] -> [1,2,2] returned 1. Fixed: loop from i = 0 and
 * check count == 0 first; the if/else right after gives the new candidate its first vote.
 */
public class LC0169_MajorityElement {

    static class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }
                if (nums[i] == candidate) count++;
                else count--;
            }
            return candidate;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tests = {{2, 2, 1, 1, 1, 2, 2}, {3, 2, 3}, {1}, {1, 2, 2}, {3, 1, 3, 2, 3}};
        for (int[] t : tests) System.out.print(s.majorityElement(t) + " ");   // 2 3 1 2 3
        System.out.println();
    }
}
