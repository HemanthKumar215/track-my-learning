/*
 * LeetCode 204 · Count Primes · Medium
 * Done on: Sun 15 – Mon 16 Nov 2026
 * https://leetcode.com/problems/count-primes/
 *
 * Question: return how many prime numbers are strictly less than n.
 * Examples: 10 -> 4 (2, 3, 5, 7), 0 -> 0, 1 -> 0, 2 -> 0
 *
 * Brute force: call isPrime (O(sqrt n)) on every number -> O(n * sqrt n).
 *   n = 5,000,000 -> about 11 billion steps -> Time Limit Exceeded.
 * Sieve of Eratosthenes: instead of testing each number, CROSS OUT the multiples of
 * every prime. Whatever is never crossed out is prime (nothing smaller divides it).
 *   p = 2 -> cross 4, 6, 8, 10 ...   p = 3 -> cross 6, 9, 12 ...   4 is crossed -> skip
 * Inner loop: start at p + p, jump by p (counting by p's, not doubling).
 * Time O(n log log n) (almost linear), Space O(n) for the boolean array.
 * Bigger idea: do the work once and store the answers -> same root as prefix sums and DP.
 *
 * Optimised version: start crossing at p * p (smaller multiples like 2p, 3p were already
 * crossed by 2 and 3), and the outer crossing loop only needs p * p < n.
 *
 * My notes: first thought the survivors were "odd numbers" (2 is even; 9, 15 are odd but
 * crossed) -> they are the PRIMES. Inner loop: tried m = 2, m++ (crosses everything) and
 * m * 2 (skips 9, 15) before p + p / m + p. Got the if condition (notPrime[p] != true,
 * shorter: !notPrime[p]) and the dry run (count = 4 for n = 10) myself.
 */
public class LC0204_CountPrimes {

    static class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for (int p = 2; p < n; p++) {
                if (!notPrime[p]) {
                    count++;
                    for (int m = p + p; m < n; m = m + p) {
                        notPrime[m] = true;
                    }
                }
            }
            return count;
        }

        public int countPrimesOptimised(int n) {
            if (n < 3) return 0;
            boolean[] notPrime = new boolean[n];
            for (int p = 2; (long) p * p < n; p++)
                if (!notPrime[p])
                    for (int m = p * p; m < n; m += p) notPrime[m] = true;
            int count = 0;
            for (int i = 2; i < n; i++) if (!notPrime[i]) count++;
            return count;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int n : new int[]{10, 0, 1, 2, 3, 20, 100, 5000000}) {
            long t = System.nanoTime();
            int a = s.countPrimes(n);
            long ms = (System.nanoTime() - t) / 1_000_000;
            System.out.println("n=" + n + " -> " + a + " " + s.countPrimesOptimised(n) + "  (" + ms + " ms)");
        }
    }
}
