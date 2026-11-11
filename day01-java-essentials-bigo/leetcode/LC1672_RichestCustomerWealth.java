/*
 * LeetCode 1672 · Richest Customer Wealth · Easy             Status: Independent
 * Done on: Wed 11 Nov 2026
 * https://leetcode.com/problems/richest-customer-wealth/
 *
 * Question: accounts[i][j] = money customer i has in bank j. Return the largest row sum.
 * Examples: [[1,5],[7,3],[3,5]] -> 10; [[1,2,3],[3,2,1]] -> 6
 *
 * My approach: outer loop over customers (rows), inner loop over banks (columns),
 * reset the sum for every customer, keep a running maximum.
 * Time O(m * n), Space O(1)
 *
 * Polish points: declaring sum INSIDE the outer loop limits its scope and resets it
 * automatically; highest = 0 works only because money is never negative
 * (in general start at Integer.MIN_VALUE).
 */
public class LC1672_RichestCustomerWealth {

    static class Solution {
        public int maximumWealth(int[][] accounts) {
            int sum = 0;
            int highest = 0;
            for (int i = 0; i < accounts.length; i++) {
                for (int j = 0; j < accounts[i].length; j++) {
                    sum += accounts[i][j];
                }
                if (sum > highest) {
                    highest = sum;
                }
                sum = 0;
            }
            return highest;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));   // 10
        System.out.println(s.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));     // 6
    }
}
