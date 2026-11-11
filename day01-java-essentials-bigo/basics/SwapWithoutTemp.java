/*
 * Day 1 · Basic · Swap Two Numbers Without a Temp Variable   Status: Independent
 * Done on: Wed 11 Nov 2026
 *
 * Question: Swap a and b without using a third variable.
 * Example: a = 5, b = 9 -> a = 9, b = 5
 *
 * Approach 1 (arithmetic): store both numbers in a as a + b, then recover each.
 *   a = 5, b = 9 -> a = 14 -> b = 14 - 9 = 5 -> a = 14 - 5 = 9
 *   (still correct in Java even if a + b overflows, because int wrap-around is consistent)
 * Approach 2 (XOR): x ^ x = 0 and x ^ 0 = x, and it can never overflow.
 * Time O(1), Space O(1)
 */
public class SwapWithoutTemp {
    public static void main(String[] args) {
        int a = 5, b = 9;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);   // 9 5

        int c = 5, d = 9;
        c = c ^ d;
        d = c ^ d;   // (c^d)^d = c
        c = c ^ d;   // (c^d)^c = d
        System.out.println(c + " " + d);   // 9 5
    }
}
