import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode 136 · Single Number · Easy
 * Done on: Thu 12 Nov 2026
 * https://leetcode.com/problems/single-number/
 *
 * Question: Every element appears twice except one. Find it with O(1) extra space.
 * Examples: [4,1,2,1,2] -> 4; [2,2,1] -> 1; [1] -> 1
 *
 * Approach 1 (my idea): HashMap of counts, return the key with count 1.  O(n) time, O(n) space
 * Approach 2: XOR everything. x ^ x = 0 and x ^ 0 = x, so every pair cancels and the
 *   single number is left.  O(n) time, O(1) space
 *   x starts at 0 for the same reason a sum starts at 0 (0 ^ a = a), NOT because of indexing.
 *
 * Trace [2,2,1]: x = 0 -> 2 -> 0 -> 1
 *
 * Edge case I raised: if there might be NO single number, XOR returns 0 and cannot tell
 * that apart from "the single number is 0" ([3,3,5,5] and [0,3,3] both give 0).
 * XOR relies on the guarantee; the HashMap version can detect "none".
 */
public class LC0136_SingleNumber {

    static class Solution {
        public int singleNumber(int[] nums) {
            int x = 0;
            for (int i = 0; i < nums.length; i++) {
                x = x ^ nums[i];
            }
            return x;
        }

        public int singleNumberHashMap(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int v : nums) count.put(v, count.getOrDefault(v, 0) + 1);
            for (int key : count.keySet())
                if (count.get(key) == 1) return key;
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{4, 1, 2, 1, 2}) + " " + s.singleNumber(new int[]{2, 2, 1}));   // 4 1
        System.out.println(s.singleNumberHashMap(new int[]{4, 1, 2, 1, 2}) + " " + s.singleNumberHashMap(new int[]{3, 3, 5, 5}));   // 4 -1
    }
}
