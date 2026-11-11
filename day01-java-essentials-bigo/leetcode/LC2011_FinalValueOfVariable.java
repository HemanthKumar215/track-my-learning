/*
 * LeetCode 2011 · Final Value of Variable After Performing Operations · Easy
 * Done on: Wed 11 Nov 2026
 * Status: Hint-assisted
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 *
 * Question: x starts at 0; each operation is "++X", "X++", "--X" or "X--". Return the final x.
 * Examples: ["--X","X++","X++"] -> 1; ["++X","++X","X++"] -> 3; ["X++","++X","--X","X--"] -> 0
 *
 * My first plan: if op is "X++" add 1, else subtract 1.
 *   Bug: "++X" is also an increment, so it fell into the else branch.
 * Fix 1: check both forms with equals (never == for Strings).
 * Fix 2 (my insight): index 1 is '+' in both increments and '-' in both decrements.
 * Time O(n), Space O(1)
 */
public class LC2011_FinalValueOfVariable {

    static class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int x = 0;
            for (String op : operations) {
                if (op.charAt(1) == '+') x++;
                else x--;
            }
            return x;
        }

        public int finalValueEquals(String[] operations) {
            int x = 0;
            for (String op : operations) {
                if (op.equals("++X") || op.equals("X++")) x++;
                else x--;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));       // 1
        System.out.println(s.finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));       // 3
        System.out.println(s.finalValueEquals(new String[]{"X++", "++X", "--X", "X--"}));          // 0
    }
}
