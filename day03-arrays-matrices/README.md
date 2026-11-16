# Day 03 · Arrays & Matrices

**Planned:** 1 day (3–5 hours) · **Started:** Mon 16 Nov 2026 · **In progress**

Starts with a **revision test**: problems solved before Day 1, re-solved from memory.

## Timeline

| Date | What I did | Problems |
|---|---|---|
| **Mon 16 Nov** | Revision: LC 283 Move Zeroes from memory (extra array → in place) | 1 |

## What I learned
- **Write index:** one pointer reads every element, another (`index`) writes only the ones you keep. Everything after `index` is leftover and gets overwritten.
- A new `int[]` starts filled with 0s, but an existing array keeps its old values, so in place needs a second pass.

## Problems

| Date | Problem | Type | File |
|---|---|---|---|
| Mon 16 Nov | LC 283 Move Zeroes (revision) | Easy | [LC0283_MoveZeroes.java](leetcode/LC0283_MoveZeroes.java) |
