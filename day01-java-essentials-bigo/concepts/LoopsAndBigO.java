/*
 * Day 1 · Concept: counting loop iterations and Big-O
 *
 * Rules learned:
 *   - nested loops MULTIPLY (n * n = O(n^2)); loops one after another ADD (n + n = O(n))
 *   - a loop that halves or doubles runs about log2(n) times -> O(log n)
 *   - constants are dropped: O(2n) is written O(n)
 *   - a nested loop whose outer loop runs a FIXED number of times (like 2) is still O(n)
 *
 * My mistakes (fixed):
 *   - counted i = 0 as a run in the halving loop (condition 0 > 0 is false, body does not run)
 *   - said a plain n x n nested loop was O(n)
 *   - said the "j doubles" inner loop was O(2n); it is O(n log n)
 */
public class LoopsAndBigO {
    public static void main(String[] args) {
        int n = 16;
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) a++;           // n      = 16
        for (int i = 1; i <= n; i++) b++;          // n      = 16
        for (int i = 0; i <= n; i++) c++;          // n + 1  = 17
        for (int i = n; i > 0; i /= 2) d++;        // 16, 8, 4, 2, 1 -> 5 = log2(16) + 1
        System.out.println(a + " " + b + " " + c + " " + d);

        n = 1000;
        long p = 0, q = 0, s = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) p++;    // O(n^2)      ~ 1,000,000
        for (int i = 0; i < n; i++) q++;
        for (int j = 0; j < n; j++) q++;                                // O(n)        ~ 2,000
        for (int i = 0; i < n; i++) for (int j = 1; j < n; j *= 2) s++; // O(n log n) ~ 10,000
        System.out.println(p + " " + q + " " + s);
    }
}
