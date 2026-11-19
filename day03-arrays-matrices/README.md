# Day 03 · Arrays & Matrices

**Planned:** 1 day (3–5 hours) · **Started:** Mon 16 Nov 2026 (Wed 18 Nov: MSC test, no study) · **In progress**

Starts with a **revision test**: problems solved before Day 1, re-solved from memory.

## Timeline

| Date | What I did | Problems |
|---|---|---|
| **Mon 16 Nov** | Revision: LC 283 Move Zeroes from memory (extra array → in place) | 1 |
| **Mon 16 – Tue 17 Nov** | Revision: LC 121 brute force (from memory) → one pass with minPrice | 1 |
| **Tue 17 Nov** | Revision: LC 169 Majority Element (Boyer–Moore voting) | 1 |
| **Thu 19 Nov** | Revision: LC 53 Maximum Subarray: brute force → Kadane (table trace, then code) | 1 |

## What I learned
- **Write index:** one pointer reads every element, another (`index`) writes only the ones you keep. Everything after `index` is leftover and gets overwritten.
- A new `int[]` starts filled with 0s, but an existing array keeps its old values, so in place needs a second pass.
- **Track the best so far** (LC 121): to sell today for the most profit, buy at the cheapest price before today. Keeping `minPrice` replaces the whole inner loop, O(n²) → O(n).
- **Boyer–Moore voting** (LC 169): `count == 0` → new candidate (check this FIRST); same → +1, different → −1. Works with any number of different values when a majority (> n/2) is guaranteed.
- **Kadane** (LC 53): a negative running sum never helps the future, so reset it to 0. Update `best` before the reset, and start `best` at `nums[0]` for all-negative arrays.

## Problems

| Date | Problem | Type | File |
|---|---|---|---|
| Mon 16 Nov | LC 283 Move Zeroes (revision) | Easy | [LC0283_MoveZeroes.java](leetcode/LC0283_MoveZeroes.java) |
| Mon 16 – Tue 17 Nov | LC 121 Best Time to Buy and Sell Stock (revision) | Easy | [LC0121_BestTimeToBuySellStock.java](leetcode/LC0121_BestTimeToBuySellStock.java) |
| Tue 17 Nov | LC 169 Majority Element (revision) | Easy | [LC0169_MajorityElement.java](leetcode/LC0169_MajorityElement.java) |
| Tue 17 – Thu 19 Nov | LC 53 Maximum Subarray (revision) | Medium | [LC0053_MaximumSubarray.java](leetcode/LC0053_MaximumSubarray.java) |
