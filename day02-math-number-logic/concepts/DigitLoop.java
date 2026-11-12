/*
 * Day 2 · Concept: the digit-extraction loop
 * Done on: Wed 11 Nov 2026
 *
 * n % 10 gives the last digit, n / 10 removes it; repeat until n is 0.
 * The loop runs once per digit -> O(number of digits) = O(log10 n).
 * rev = rev * 10 + d shifts rev one place left and attaches the new digit.
 *
 * My trace for n = 4721 (correct first try):
 *   n     d   sum   rev    n/10
 *   4721  1   1     1      472
 *   472   2   3     12     47
 *   47    7   10    127    4
 *   4     4   14    1274   0   -> stop
 */
public class DigitLoop {
    public static void main(String[] args) {
        int n = 4721, sum = 0, rev = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            rev = rev * 10 + d;
            n /= 10;
        }
        System.out.println(sum + " " + rev);   // 14 1274
    }
}
