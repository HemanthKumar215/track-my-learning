/*
 * Day 1 · Basic · Leap Year
 * Done on: Mon 9 Nov 2026
 *
 * Question: Return true if a year is a leap year.
 *   divisible by 4 -> leap, EXCEPT divisible by 100 -> not leap, EXCEPT divisible by 400 -> leap
 * Examples: 2024 -> true, 1900 -> false, 2000 -> true, 2023 -> false
 *
 * Approach: two separate cases make a leap year:
 *   case 1: divisible by 4 AND not by 100   (2024)
 *   case 2: divisible by 400                (2000)
 * Time O(1), Space O(1)
 *
 * My mistakes (fixed):
 *   - wrote "Static" (keywords are lowercase)
 *   - no return on the false path ("missing return statement")
 *   - treated %400 as a reason to REJECT; it is an exception that brings years back -> needs ||
 */
public class LeapYear {

    // My version: two ifs that each return true
    static boolean isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0) return true;   // case 1
        if (year % 400 == 0) return true;                    // case 2
        return false;
    }

    // Same logic as one expression
    static boolean isLeapOneLine(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        for (int y : new int[]{2024, 1900, 2000, 2023})
            System.out.println(y + " " + isLeap(y) + " " + isLeapOneLine(y));
    }
}
