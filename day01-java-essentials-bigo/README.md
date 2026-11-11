# Day 01 · Java Essentials & Big-O

**Dates:** Nov 8–11, 2026 · **Status:** ✅ Done

## What I learned
- **Overflow happens at the moment of the operation.** `int * int` overflows before it is stored, even into a `long`. Fix: make one operand long first: `(long) a * b` or `50000L * 50000`. A cast outside the parentheses, `(long)(a * b)`, is too late.
- **Casting comes before division:** `(double) 7 / 2 = 3.5`, but `(double)(7 / 2) = 3.0`.
- **Loop counting:** `<` vs `<=`; the condition is checked before each run; a halving loop runs about log₂ n times.
- **Big-O:** nested loops multiply (O(n²)), sequential loops add (O(n)), constants are dropped, and a fixed outer loop (×2) keeps it O(n).
- **Methods return, callers print.** Return types must match (`String.valueOf` to turn a number into a String).
- **switch:** a case without `break`/`return` falls through into the next case.
- **`double / 0` is Infinity; `int / 0` throws ArithmeticException.**
- **Strings:** compare with `equals`, chars with `==`. Strings are immutable; StringBuilder changes the same object.
- **`x++` vs `++x`** only matters when the value is used in the same expression.

## Problems

| Problem | Type | Status | File |
|---|---|---|---|
| Overflow & casting (Q1–Q4) | Concept | Corrected | [OverflowAndCasting.java](concepts/OverflowAndCasting.java) |
| Loop counting & Big-O (Q5–Q7) | Concept | Corrected | [LoopsAndBigO.java](concepts/LoopsAndBigO.java) |
| String vs StringBuilder | Concept | Needs revision | [StringVsStringBuilder.java](concepts/StringVsStringBuilder.java) |
| Leap Year | Basic | Hint-assisted | [LeapYear.java](basics/LeapYear.java) |
| Floyd's Triangle | Basic | Independent | [FloydTriangle.java](basics/FloydTriangle.java) |
| Swap Without Temp | Basic | Independent | [SwapWithoutTemp.java](basics/SwapWithoutTemp.java) |
| Calculator (switch) | Basic | Hint-assisted | [Calculator.java](basics/Calculator.java) |
| LC 1480 Running Sum | Easy | Hint-assisted | [LC1480_RunningSum.java](leetcode/LC1480_RunningSum.java) |
| LC 1470 Shuffle the Array | Easy | Independent | [LC1470_ShuffleTheArray.java](leetcode/LC1470_ShuffleTheArray.java) |
| LC 509 Fibonacci Number | Easy | Independent | [LC0509_FibonacciNumber.java](leetcode/LC0509_FibonacciNumber.java) |
| LC 1672 Richest Customer Wealth | Easy | Independent | [LC1672_RichestCustomerWealth.java](leetcode/LC1672_RichestCustomerWealth.java) |
| LC 1929 Concatenation of Array | Easy | Independent | [LC1929_ConcatenationOfArray.java](leetcode/LC1929_ConcatenationOfArray.java) |
| LC 2011 Final Value of Variable | Easy | Hint-assisted | [LC2011_FinalValueOfVariable.java](leetcode/LC2011_FinalValueOfVariable.java) |
| LC 1108 Defanging an IP Address | Easy | Hint-assisted | [LC1108_DefangingIPAddress.java](leetcode/LC1108_DefangingIPAddress.java) |

## Revise before Day 3
- Where to put a cast so overflow can't happen.
- Big-O of nested loops.
- Tracing StringBuilder: `setCharAt` replaces one char; `reverse` moves every char.
