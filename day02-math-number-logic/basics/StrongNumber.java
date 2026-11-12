/*
 * Day 2 · Basic · Strong Number (Capgemini)
 * Done on: Thu 12 Nov 2026
 *
 * Question: n is a Strong number if it equals the sum of the factorials of its digits.
 * Examples: 145 -> true (1! + 4! + 5! = 1 + 24 + 120), 123 -> false, 2 -> true
 *
 * My design: a helper fact(d) that returns d!, and isStrong(n) that adds fact(digit)
 * for every digit and compares with the saved original.
 * Time O(digits * 9), Space O(1). Faster: precompute 0!..9! in an array (O(digits)).
 *
 * My mistakes in fact() (fixed):
 *   - return was inside the loop -> returned after the first multiplication
 *   - multiplied into d itself (which holds the input) -> 3 became 3 * 3! = 18;
 *     a product needs its own result variable starting at 1
 *   - 0! = 1 needs no special case: for d = 0 the loop runs zero times and result stays 1
 *   - isStrong needs a final return (return orginal == sum;)
 */
public class StrongNumber {

    static int fact(int d) {
        int result = 1;
        for (int i = 1; i <= d; i++) {
            result = result * i;
        }
        return result;
    }

    static boolean isStrong(int n) {
        int orginal = n, sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += fact(d);
            n = n / 10;
        }
        return orginal == sum;
    }

    static final int[] FACT = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    static boolean isStrongFast(int n) {
        int sum = 0;
        for (int t = n; t > 0; t /= 10) sum += FACT[t % 10];
        return n > 0 && sum == n;
    }

    public static void main(String[] args) {
        System.out.println(isStrong(145) + " " + isStrong(123) + " " + isStrong(2));          // true false true
        System.out.println(isStrongFast(145) + " " + isStrongFast(40585));                    // true true
    }
}
