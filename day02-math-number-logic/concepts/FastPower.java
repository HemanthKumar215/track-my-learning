/*
 * Day 2 · Concept · Fast Power (exponentiation by squaring)
 * Done on: Sun 15 Nov 2026
 *
 * Question: compute x^n for n >= 0 faster than multiplying x by itself n times.
 * Idea: x^n = x^(n/2) * x^(n/2), times one extra x if n is odd.
 *   3^5 -> half = 3^2 = 9 -> odd -> 9 * 9 * 3 = 243
 * The exponent halves on each call, so Time O(log n) and Space O(log n) (recursion stack).
 *
 * My notes: worked out that same-base powers add (2^a * 2^b = 2^(a+b)).
 * Mix-up to watch: n / 2 is the EXPONENT (how many times), half is the VALUE (what you multiply).
 * Rewrote it from memory on Sun 15 Nov (wrote "Static" with a capital S: keywords are lowercase).
 */
public class FastPower {

    static long pow(long x, int n) {
        if (n == 0) return 1;
        long half = pow(x, n / 2);
        if (n % 2 == 0) return half * half;
        else            return half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(pow(3, 5) + " " + pow(2, 10) + " " + pow(7, 0) + " " + pow(2, 62));   // 243 1024 1 4611686018427387904
    }
}
