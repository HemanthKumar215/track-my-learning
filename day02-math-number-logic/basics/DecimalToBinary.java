/*
 * Day 2 · Basic · Decimal to Binary (Capgemini)
 * Done on: Fri 13 Nov 2026
 *
 * Question: Convert a non-negative integer to its binary string without library methods.
 * Examples: 10 -> "1010", 13 -> "1101", 1 -> "1", 0 -> "0"
 *
 * Approach: the digit loop with base 2: take the last bit (n % 2 or n & 1), drop it
 * (n / 2 or n >>> 1), append to a StringBuilder. The bits come out last-first, so
 * reverse() once at the end. Same code with 8 gives octal.
 * Time O(log n), Space O(log n)
 *
 * Trace 13: append 1, 0, 1, 1 -> "1011" -> reverse -> "1101"
 *
 * My mistakes (fixed):
 *   - returned 0 (an int) from a String method -> must be "0"
 *   - forgot StringBuilder.reverse() (String has no reverse method)
 */
public class DecimalToBinary {

    static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n & 1);
            n = n >>> 1;
        }
        return sb.reverse().toString();
    }

    static String toBase(int n, int base) {          // works for bases 2..10
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % base);
            n = n / base;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBinary(10) + " " + toBinary(13) + " " + toBinary(1) + " " + toBinary(0));   // 1010 1101 1 0
        System.out.println(toBase(64, 8) + " " + Integer.toBinaryString(13));                            // 100 1101
    }
}
