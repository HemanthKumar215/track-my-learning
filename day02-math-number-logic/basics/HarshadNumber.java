/*
 * Day 2 · Basic · Harshad (Niven) Number (Capgemini)
 * Done on: Thu 12 Nov 2026
 *
 * Question: n is a Harshad number if it is divisible by the sum of its digits
 * (any number of digits).
 * Examples: 18 -> true (1+8 = 9), 19 -> false, 156 -> true (sum 12), 123 -> false
 *
 * Approach: digit loop for the sum (saving the original first), then one modulo.
 * Time O(digits), Space O(1)
 *
 * Notes: solved on my own, including saving the original.
 *   - n = 0 gives sum = 0 and original % 0 throws ArithmeticException -> guard n <= 0
 *   - "return original % sum == 0;" is the short form of if/else returning true/false
 */
public class HarshadNumber {

    static boolean isHarshad(int n) {
        if (n <= 0) return false;
        int sum = 0;
        int orginal = n;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return orginal % sum == 0;
    }

    public static void main(String[] args) {
        for (int x : new int[]{18, 19, 21, 156, 123, 1729})
            System.out.println(x + " " + isHarshad(x));
    }
}
