import java.util.Arrays;

/*
 * LeetCode 1480 · Running Sum of 1d Array · Easy            Status: Hint-assisted
 * https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Question: Return an array where element i is nums[0] + nums[1] + ... + nums[i].
 * Examples: [1,2,3,4] -> [1,3,6,10]; [3,1,2,10,1] -> [3,4,6,16,17]
 *
 * Brute force: re-add from index 0 for every i -> O(n^2)
 * Optimal: reuse the previous answer: res[i] = res[i-1] + nums[i] -> O(n) time, O(n) space
 *          (in place: nums[i] += nums[i-1] -> O(1) extra space). This is a PREFIX SUM.
 *
 * My notes: the key line was mine; I needed help with res[0] and starting the loop at 1
 * (starting at 0 would read res[-1] -> ArrayIndexOutOfBoundsException).
 * Edge case to say in interviews: "I assume the array is not empty."
 */
public class LC1480_RunningSum {

    static class Solution {
        public int[] runningSum(int[] nums) {
            int[] res = new int[nums.length];
            res[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res[i] = res[i - 1] + nums[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.runningSum(new int[]{1, 2, 3, 4})));       // [1, 3, 6, 10]
        System.out.println(Arrays.toString(s.runningSum(new int[]{3, 1, 2, 10, 1})));   // [3, 4, 6, 16, 17]
    }
}
