/*
 * Day 2 · Concept: binary and bit operators
 * Done on: Thu 12 Nov 2026
 *
 * & (AND): 1 only if both bits are 1      | (OR): 1 if at least one is 1
 * ^ (XOR): 1 if the bits are different    n & 1: last bit     n >>> 1: drop last bit
 *
 *   12 = 1100, 10 = 1010
 *   12 & 10 = 1000 = 8      12 | 10 = 1110 = 14      12 ^ 10 = 0110 = 6
 *
 * XOR facts: x ^ x = 0, x ^ 0 = x, order does not matter.
 *   So in 4 ^ 1 ^ 2 ^ 1 ^ 2 the pairs cancel: 4 ^ 0 ^ 0 = 4
 *
 * My mistakes (fixed):
 *   - described the method but forgot to convert the binary answers back to decimal
 *   - wrote "400" for 4 ^ 0 ^ 0 (it is still an expression: 4 ^ 0 = 4)
 */
public class BitBasics {
    public static void main(String[] args) {
        System.out.println((12 & 10) + " " + (12 | 10) + " " + (12 ^ 10));   // 8 14 6
        System.out.println(4 ^ 1 ^ 2 ^ 1 ^ 2);                               // 4
        System.out.println((7 ^ 7 ^ 3) + " " + (9 ^ 4 ^ 1 ^ 4 ^ 9) + " "
                + (6 ^ 2 ^ 8 ^ 2 ^ 6) + " " + (10 ^ 10 ^ 15 ^ 20 ^ 20));     // 3 1 8 15
        System.out.println(Integer.toBinaryString(11) + " " + (11 & 1) + " " + (11 >>> 1));   // 1011 1 5
    }
}
