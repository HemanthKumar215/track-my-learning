# Day 01 · Java Essentials & Big-O

**Planned:** 1 day (3–5 hours) · **Took:** 4 calendar days (Sun 8 – Wed 11 Nov 2026), **3 study days** (no study on Tue 10 Nov) · **Status:** ✅ Done

## Timeline

| Date | What I did | Problems |
|---|---|---|
| **Sun 8 Nov** | Overflow and casting (prediction questions Q1–Q3) | 0 problems, 3 concept questions |
| **Mon 9 Nov** | Overflow in loops (Q4), loop counting (Q5), Big-O (Q6–Q7); Leap Year, Floyd's Triangle, LC 1480, LC 1470 | 4 |
| Tue 10 Nov | — no study — | 0 |
| **Wed 11 Nov** | LC 509, Swap Without Temp, Calculator (switch), LC 1672, LC 2011, x++ vs ++x, LC 1929, StringBuilder lesson, LC 1108 | 7 |

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

| Date | Problem | Type | Status | File |
|---|---|---|---|---|
| Sun 8 – Mon 9 Nov | Overflow & casting (Q1–Q4) | Concept | Corrected | [OverflowAndCasting.java](concepts/OverflowAndCasting.java) |
| Mon 9 Nov | Loop counting & Big-O (Q5–Q7) | Concept | Corrected | [LoopsAndBigO.java](concepts/LoopsAndBigO.java) |
| Mon 9 Nov | Leap Year | Basic | Hint-assisted | [LeapYear.java](basics/LeapYear.java) |
| Mon 9 Nov | Floyd's Triangle | Basic | Independent | [FloydTriangle.java](basics/FloydTriangle.java) |
| Mon 9 Nov | LC 1480 Running Sum | Easy | Hint-assisted | [LC1480_RunningSum.java](leetcode/LC1480_RunningSum.java) |
| Mon 9 Nov | LC 1470 Shuffle the Array | Easy | Independent | [LC1470_ShuffleTheArray.java](leetcode/LC1470_ShuffleTheArray.java) |
| Wed 11 Nov | LC 509 Fibonacci Number | Easy | Independent | [LC0509_FibonacciNumber.java](leetcode/LC0509_FibonacciNumber.java) |
| Wed 11 Nov | Swap Without Temp | Basic | Independent | [SwapWithoutTemp.java](basics/SwapWithoutTemp.java) |
| Wed 11 Nov | Calculator (switch) | Basic | Hint-assisted | [Calculator.java](basics/Calculator.java) |
| Wed 11 Nov | LC 1672 Richest Customer Wealth | Easy | Independent | [LC1672_RichestCustomerWealth.java](leetcode/LC1672_RichestCustomerWealth.java) |
| Wed 11 Nov | LC 2011 Final Value of Variable | Easy | Hint-assisted | [LC2011_FinalValueOfVariable.java](leetcode/LC2011_FinalValueOfVariable.java) |
| Wed 11 Nov | LC 1929 Concatenation of Array | Easy | Independent | [LC1929_ConcatenationOfArray.java](leetcode/LC1929_ConcatenationOfArray.java) |
| Wed 11 Nov | String vs StringBuilder | Concept | Needs revision | [StringVsStringBuilder.java](concepts/StringVsStringBuilder.java) |
| Wed 11 Nov | LC 1108 Defanging an IP Address | Easy | Hint-assisted | [LC1108_DefangingIPAddress.java](leetcode/LC1108_DefangingIPAddress.java) |

## Revise before Day 3
- Where to put a cast so overflow can't happen.
- Big-O of nested loops.
- Tracing StringBuilder: `setCharAt` replaces one char; `reverse` moves every char.
