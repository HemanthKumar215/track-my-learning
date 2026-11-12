/*
 * Day 2 · Basic · Armstrong Number (Capgemini)
 * Done on: Wed 11 – Thu 12 Nov 2026
 *
 * Question: n is an Armstrong number if it equals the sum of its digits,
 * each raised to the power of the number of digits.
 * Examples: 153 -> true (1^3 + 5^3 + 3^3), 9474 -> true, 123 -> false
 *
 * Approach: two passes. Pass 1 counts the digits (k). Pass 2 adds d^k for each digit.
 * Compare the sum with the saved original.
 * Time O(k^2) where k = number of digits (at most 10 for an int), Space O(1)
 *
 * My mistakes (fixed):
 *   - second loop condition was "orginal < 0" (digit loops run while x > 0)
 *   - second loop would have destroyed the copy needed for the final compare
 *     -> reload n = orginal and loop on n again
 *   - power loop: thought it should run d times; it must run digit (k) times
 *     (multiply by the BASE, loop EXPONENT times; d times would give d^d)
 */
public class ArmstrongNumber {

    static boolean isArmstrong(int n) {
        int sum = 0;
        int digit = 0;
        int orginal = n;

        while (n > 0) {              // pass 1: count digits
            n = n / 10;
            digit++;
        }

        n = orginal;                 // reload: n is 0 after pass 1
        while (n > 0) {              // pass 2: add d^digit
            int d = n % 10;
            int power = 1;
            for (int i = 0; i < digit; i++)
                power = power * d;
            sum += power;
            n = n / 10;
        }
        return orginal == sum;
    }

    public static void main(String[] args) {
        for (int x : new int[]{153, 9474, 123})
            System.out.println(x + " " + isArmstrong(x));
    }
}
