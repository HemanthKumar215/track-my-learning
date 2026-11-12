/*
 * Day 2 · Basic · GCD (Euclid) and LCM
 * Done on: Thu 12 Nov 2026
 *
 * Question: Find gcd(a, b) and lcm(a, b).
 * Examples: gcd(48, 18) = 6, gcd(36, 60) = 12, lcm(4, 6) = 12
 *
 * Euclid: gcd(a, b) = gcd(b, a % b); when b becomes 0 the answer is a.
 *   gcd(48,18) -> (18,12) -> (12,6) -> (6,0) -> 6
 * Time O(log min(a, b)), Space O(1). Brute force (count down from min) is O(min(a, b)).
 *
 * LCM = a / gcd * b: DIVIDE FIRST so the intermediate value stays small
 * (a * b can overflow int: 100000 * 100000 = 10^10), and cast to long before multiplying.
 *
 * My notes:
 *   - no need to swap when a < b: the first step does it automatically
 *   - loop on b != 0 (a % b divides by b)
 *   - update order like Fibonacci: a = b before b = d
 *   - lcm should REUSE the gcd method instead of rebuilding it
 */
public class GcdAndLcm {

    static int gcd(int a, int b) {
        while (b != 0) {
            int d = a % b;
            a = b;
            b = d;
        }
        return a;
    }

    static int gcdRecursive(int a, int b) {
        return b == 0 ? a : gcdRecursive(b, a % b);
    }

    static long lcm(int a, int b) {
        return (long) a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 18) + " " + gcd(36, 60) + " " + gcdRecursive(36, 60));   // 6 12 12
        System.out.println(lcm(4, 6) + " " + lcm(100000, 100000) + " " + lcm(100000, 99999)); // 12 100000 9999900000
    }
}
