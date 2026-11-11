/*
 * Day 1 · Concept: integer overflow and casting
 *
 * Rule learned: overflow depends on the types AT THE MOMENT OF THE OPERATION,
 * not on the variable you store the result in.
 *
 * My mistakes (fixed):
 *   - thought (double) a / b would be an error            -> it is 3.5
 *   - thought (double) (a / b) gives 3.5                   -> it is 3.0 (int division happened first)
 *   - thought big * big prints 2500000000                  -> int overflow wraps to -1794967296
 *   - thought long x = 50000 * 50000 is safe               -> right side is int*int, overflows first
 *   - thought (long) (50000 * 50000) is safe               -> cast happens AFTER the overflow
 */
public class OverflowAndCasting {
    public static void main(String[] args) {
        int a = 7, b = 2;
        System.out.println(a / b);              // 3    int / int drops the decimal
        System.out.println(a % b);              // 1    remainder
        System.out.println((double) a / b);     // 3.5  cast applies to a first, then double / int
        System.out.println((double) (a / b));   // 3.0  a / b = 3 already, then cast

        int big = 50000;
        System.out.println(big * big);          // -1794967296  int overflow wraps silently
        long safe = (long) big * big;
        System.out.println(safe);               // 2500000000   long * int is done in long

        long x1 = 50000 * 50000;                // WRONG: int * int overflows, then widened
        long x2 = 50000L * 50000;               // right: L makes it a long literal
        long x3 = (long) (50000 * 50000);       // WRONG: cast is too late
        long x4 = 50000 * (long) 50000;         // right: one operand is long before multiplying
        System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);

        // Overflow in real code: summing an array
        int[] arr = {2_000_000_000, 2_000_000_000};
        long total = 0;                         // long + int -> done in long
        for (int v : arr) total += v;
        int total2 = 0;                         // int + int -> overflows
        for (int v : arr) total2 += v;
        System.out.println(total + " " + total2);   // 4000000000 -294967296

        // Pre vs post increment
        int x = 3;
        int y = x++ + ++x;                      // 3 + 5
        System.out.println(x + " " + y);        // 5 8
    }
}
