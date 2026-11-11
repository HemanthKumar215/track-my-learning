/*
 * Day 1 · Basic · Floyd's Triangle                           Status: Independent
 * Done on: Mon 9 Nov 2026
 *
 * Question: Print n rows; row i has i numbers, continuing from where the previous row stopped.
 * Example (n = 4):
 *   1
 *   2 3
 *   4 5 6
 *   7 8 9 10
 *
 * Approach: nested loops; the counter is declared OUTSIDE both loops so it keeps
 * counting across rows (inside the outer loop it would restart at 1 every row).
 * Time O(n^2) (prints n(n+1)/2 numbers), Space O(1)
 */
public class FloydTriangle {

    static void floyd(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        floyd(4);
    }
}
