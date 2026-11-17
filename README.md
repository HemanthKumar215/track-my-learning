# Track My Learning: Java DSA

My day-by-day preparation for software engineering placements: Java fundamentals → DSA patterns → LeetCode Easy, Medium and Hard. All code is Java 15 compatible.

Every solution file starts with the **question**, examples, my **approach**, **time/space complexity** and the **mistakes I made** along the way, followed by the code and a `main` method that runs the examples.

## Progress

| Day | Topic | Dates | Study days | Basics | LeetCode | Status |
|---|---|---|---|---|---|---|
| 01 | [Java Essentials & Big-O](day01-java-essentials-bigo) | 8–11 Nov 2026 | 3 (of 4 calendar days) | 4 | 7 | ✅ Done |
| 02 | [Math & Number Logic + Bits](day02-math-number-logic) | 11–16 Nov 2026 | 5 (of 6 calendar days) | 7 | 7 | ✅ Done |
| 03 | [Arrays & Matrices](day03-arrays-matrices) | 16 Nov 2026 – | 2 so far | 0 | 3 | ⏳ In progress |
| 04 | Strings & StringBuilder | | | | | |
| 05 | Hashing (HashMap / HashSet) | | | | | |
| 06 | Two Pointers, Sliding Window, Prefix Sums | | | | | |
| 07 | Sorting, Intervals, Greedy & Heaps | | | | | |
| 08 | Binary Search | | | | | |
| 09 | Recursion & Backtracking | | | | | |
| 10 | Linked Lists | | | | | |
| 11 | Stacks, Queues & Monotonic Stack | | | | | |
| 12 | Binary Trees, BST & Tries | | | | | |
| 13 | Graphs | | | | | |
| 14 | Dynamic Programming | | | | | |

## LeetCode solved

| # | Problem | Difficulty | Pattern | Date | Code |
|---|---|---|---|---|---|
| 7 | Reverse Integer | Medium | Math (overflow check) | 15 Nov | [Day 2](day02-math-number-logic/leetcode/LC0007_ReverseInteger.java) |
| 9 | Palindrome Number | Easy | Math (half reversal) | 13 Nov | [Day 2](day02-math-number-logic/leetcode/LC0009_PalindromeNumber.java) |
| 50 | Pow(x, n) | Medium | Fast power (divide & conquer) | 15 Nov | [Day 2](day02-math-number-logic/leetcode/LC0050_PowXN.java) |
| 121 | Best Time to Buy and Sell Stock | Easy | Running minimum | 17 Nov | [Day 3](day03-arrays-matrices/leetcode/LC0121_BestTimeToBuySellStock.java) |
| 136 | Single Number | Easy | XOR / bit manipulation | 12 Nov | [Day 2](day02-math-number-logic/leetcode/LC0136_SingleNumber.java) |
| 169 | Majority Element | Easy | Boyer–Moore voting | 17 Nov | [Day 3](day03-arrays-matrices/leetcode/LC0169_MajorityElement.java) |
| 191 | Number of 1 Bits | Easy | Bit manipulation | 12 Nov | [Day 2](day02-math-number-logic/leetcode/LC0191_NumberOf1Bits.java) |
| 204 | Count Primes | Medium | Sieve of Eratosthenes | 16 Nov | [Day 2](day02-math-number-logic/leetcode/LC0204_CountPrimes.java) |
| 268 | Missing Number | Easy | Sum formula / XOR | 12 Nov | [Day 2](day02-math-number-logic/leetcode/LC0268_MissingNumber.java) |
| 283 | Move Zeroes | Easy | Write index (in place) | 16 Nov | [Day 3](day03-arrays-matrices/leetcode/LC0283_MoveZeroes.java) |
| 509 | Fibonacci Number | Easy | Iteration (DP preview) | 11 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC0509_FibonacciNumber.java) |
| 1108 | Defanging an IP Address | Easy | StringBuilder | 11 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC1108_DefangingIPAddress.java) |
| 1470 | Shuffle the Array | Easy | Index mapping | 9 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC1470_ShuffleTheArray.java) |
| 1480 | Running Sum of 1d Array | Easy | Prefix sum | 9 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC1480_RunningSum.java) |
| 1672 | Richest Customer Wealth | Easy | 2D array traversal | 11 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC1672_RichestCustomerWealth.java) |
| 1929 | Concatenation of Array | Easy | Index mapping | 11 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC1929_ConcatenationOfArray.java) |
| 2011 | Final Value of Variable After Performing Operations | Easy | String / char check | 11 Nov | [Day 1](day01-java-essentials-bigo/leetcode/LC2011_FinalValueOfVariable.java) |

Solved earlier, code not added yet: 1 Two Sum, 11 Container With Most Water, 53 Maximum Subarray, 88 Merge Sorted Array, 128 Longest Consecutive Sequence, 217 Contains Duplicate, 238 Product of Array Except Self, 242 Valid Anagram.

## How to run a file

```bash
cd day01-java-essentials-bigo/leetcode
javac LC1480_RunningSum.java
java LC1480_RunningSum
```
