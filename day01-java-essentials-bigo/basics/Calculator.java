/*
 * Day 1 · Basic · Simple Calculator Using switch              Status: Hint-assisted
 * Done on: Wed 11 Nov 2026
 *
 * Question: Return the result of a op b as a String for + - * /.
 *   Return "Cannot divide by zero" for division by 0 and "Unknown operator" otherwise.
 * Examples: calc(8,'/',2) -> "4.0", calc(3,'*',4) -> "12.0",
 *           calc(1,'/',0) -> "Cannot divide by zero", calc(2,'%',3) -> "Unknown operator"
 *
 * Approach: switch on the operator; every case RETURNS, so no break is needed.
 * Time O(1), Space O(1)
 *
 * My mistakes (fixed):
 *   - printed results instead of returning them (methods return; the caller prints)
 *   - returned a double from a String method (needs String.valueOf)
 *   - printed the divide-by-zero message without returning -> fell through into default
 * Note: double / 0 gives Infinity (no error); int / 0 throws ArithmeticException.
 */
public class Calculator {

    static String calc(double a, char op, double b) {
        switch (op) {
            case '+': return String.valueOf(a + b);
            case '-': return String.valueOf(a - b);
            case '*': return String.valueOf(a * b);
            case '/': if (b == 0) { return "Cannot divide by zero"; } else return String.valueOf(a / b);
            default:  return "Unknown operator";
        }
    }

    public static void main(String[] args) {
        System.out.println(calc(8, '/', 2));
        System.out.println(calc(3, '*', 4));
        System.out.println(calc(1, '/', 0));
        System.out.println(calc(2, '%', 3));
    }
}
