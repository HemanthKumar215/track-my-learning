# Day 02 · Math & Number Logic + Bits

**Planned:** 1 day (3–5 hours) · **Started:** Wed 11 Nov 2026 · **In progress**

## Timeline

| Date | What I did | Problems |
|---|---|---|
| **Wed 11 Nov** (evening) | Digit-loop trace (4721), Palindrome Number bug fix, started Armstrong | 2 |
| **Thu 12 Nov** | Finished Armstrong; divisors & √n; Prime Check (rewrote from memory); GCD (Euclid), LCM; binary & bit operators; XOR; LC 136, LC 191 | 6 |

## What I learned
- **Digit loop:** `n % 10` = last digit, `n / 10` drops it; runs once per digit. The loop destroys `n`, so **save a copy** if you need the original later (palindrome, Armstrong).
- **Base vs exponent:** to compute `d^k`, multiply by `d` and loop `k` times.
- **Primes in O(√n):** divisors come in pairs, the smaller one ≤ √n. Loop `i = 2; i * i <= n`.
- **Search-for-a-counter-example pattern:** return early only on proof (divisor found → not prime); the "yes" answer goes after the loop.
- **Euclid's GCD:** `gcd(a, b) = gcd(b, a % b)` until `b = 0`. O(log n). **LCM** = `a / gcd * b` (divide first to avoid overflow); reuse the method you already wrote.
- **Bits:** `&` both, `|` either, `^` different. `n & 1` = last bit, `n >>> 1` drops it (binary version of the digit loop).
- **XOR:** `x ^ x = 0`, `x ^ 0 = x`, order doesn't matter, so pairs cancel. Only valid when exactly one single number is guaranteed.

## Problems

| Date | Problem | Type | File |
|---|---|---|---|
| Wed 11 Nov | Digit-extraction loop | Concept | [DigitLoop.java](concepts/DigitLoop.java) |
| Wed 11 Nov | Palindrome Number (full reverse) | Basic | [PalindromeNumber.java](basics/PalindromeNumber.java) |
| Wed 11 – Thu 12 Nov | Armstrong Number | Basic | [ArmstrongNumber.java](basics/ArmstrongNumber.java) |
| Thu 12 Nov | Prime Check (√n) | Basic | [PrimeCheck.java](basics/PrimeCheck.java) |
| Thu 12 Nov | GCD (Euclid) and LCM | Basic | [GcdAndLcm.java](basics/GcdAndLcm.java) |
| Thu 12 Nov | Binary, &, \|, ^, XOR cancelling | Concept | [BitBasics.java](concepts/BitBasics.java) |
| Thu 12 Nov | LC 136 Single Number | Easy | [LC0136_SingleNumber.java](leetcode/LC0136_SingleNumber.java) |
| Thu 12 Nov | LC 191 Number of 1 Bits | Easy | [LC0191_NumberOf1Bits.java](leetcode/LC0191_NumberOf1Bits.java) |

## Still to do on Day 2
Fast power (concept) · LC 9 Palindrome Number (half reversal) · LC 7 Reverse Integer · Strong Number · Harshad Number · Decimal to Binary · LC 268 Missing Number · LC 204 Count Primes · LC 50 Pow(x, n)
