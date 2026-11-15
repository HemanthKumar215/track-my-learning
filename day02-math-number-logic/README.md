# Day 02 · Math & Number Logic + Bits

**Planned:** 1 day (3–5 hours) · **Started:** Wed 11 Nov 2026 · **In progress**

## Timeline

| Date | What I did | Problems |
|---|---|---|
| **Wed 11 Nov** (evening) | Digit-loop trace (4721), Palindrome Number bug fix, started Armstrong | 2 |
| **Thu 12 Nov** | Finished Armstrong; divisors & √n; Prime Check (rewrote from memory); GCD (Euclid), LCM; binary & bit operators; XOR; LC 136, LC 191; LC 268 (sort, sum, XOR); Harshad; Strong | 9 |
| **Fri 13 Nov** (morning) | Warm-up from memory (isPrime, singleNumber); Decimal to Binary; LC 9 (half reversal) | 2 |
| Sat 14 Nov | — other exams — | 0 |
| **Sun 15 Nov** | LC 7 Reverse Integer (overflow check) | 1 |

## What I learned
- **Digit loop:** `n % 10` = last digit, `n / 10` drops it; runs once per digit. The loop destroys `n`, so **save a copy** if you need the original later (palindrome, Armstrong).
- **Base vs exponent:** to compute `d^k`, multiply by `d` and loop `k` times.
- **Primes in O(√n):** divisors come in pairs, the smaller one ≤ √n. Loop `i = 2; i * i <= n`.
- **Search-for-a-counter-example pattern:** return early only on proof (divisor found → not prime); the "yes" answer goes after the loop.
- **Euclid's GCD:** `gcd(a, b) = gcd(b, a % b)` until `b = 0`. O(log n). **LCM** = `a / gcd * b` (divide first to avoid overflow); reuse the method you already wrote.
- **Bits:** `&` both, `|` either, `^` different. `n & 1` = last bit, `n >>> 1` drops it (binary version of the digit loop).
- **XOR:** `x ^ x = 0`, `x ^ 0 = x`, order doesn't matter, so pairs cancel. Only valid when exactly one single number is guaranteed.
- **Return placement (came up 3 times):** inside a loop, return only when you FIND the answer; the "not found" answer goes after the loop. A variable declared in `for (...)` doesn't exist after the loop.
- **A product starts at 1** in its own variable (factorial, power); a sum starts at 0.
- **isPrime memory hook:** start at 2, include the root (`i * i <= n`).
- **Overflow check without long** (LC 7): before `rev * 10 + d`, compare `rev` with `Integer.MAX_VALUE / 10` and `Integer.MIN_VALUE / 10`.
- **Half reversal** (LC 9) avoids overflow: stop when `x <= rev`, compare `x == rev || x == rev / 10`.

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
| Thu 12 Nov | LC 268 Missing Number | Easy | [LC0268_MissingNumber.java](leetcode/LC0268_MissingNumber.java) |
| Thu 12 Nov | Harshad Number | Basic | [HarshadNumber.java](basics/HarshadNumber.java) |
| Thu 12 Nov | Strong Number | Basic | [StrongNumber.java](basics/StrongNumber.java) |
| Fri 13 Nov | Decimal to Binary | Basic | [DecimalToBinary.java](basics/DecimalToBinary.java) |
| Fri 13 Nov | LC 9 Palindrome Number (half reversal) | Easy | [LC0009_PalindromeNumber.java](leetcode/LC0009_PalindromeNumber.java) |
| Fri 13 – Sun 15 Nov | LC 7 Reverse Integer | Medium | [LC0007_ReverseInteger.java](leetcode/LC0007_ReverseInteger.java) |

## Still to do on Day 2
Fast power (concept) · LC 50 Pow(x, n) · LC 204 Count Primes
