/*
 * Day 2 · Basic · Prime Check
 * Done on: Thu 12 Nov 2026
 *
 * Question: Return true if n is prime.
 * Examples: 29 -> true, 30 -> false, 1 -> false, 2 -> true, 9 -> false
 *
 * Key idea: divisors come in pairs (i, n/i); the smaller one is always <= sqrt(n).
 * So test every i from 2 while i * i <= n (e.g. 37: test 2..6 only).
 * Time O(sqrt n) instead of O(n), Space O(1)
 *
 * Pattern ("search for a counter-example"): return early only when you find proof
 * (a divisor -> NOT prime); the other answer (prime) goes AFTER the loop.
 *
 * My mistakes (fixed, then rewrote it correctly from memory):
 *   - wrote i % n instead of n % i (does i divide n?)
 *   - started at 0 (n % 0 crashes) and later at 3 (skips 2)
 *   - used < instead of <= (25 = 5 * 5 was missed)
 *   - returned true when a divisor was found (it means NOT prime)
 *   - put "else return false" inside the loop -> stopped after the first check
 *   - edge case n == 0 not handled -> use n < 2
 */
public class PrimeCheck {

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int x : new int[]{2, 9, 29, 1, 25, 37})
            System.out.println(x + " " + isPrime(x));
    }
}
