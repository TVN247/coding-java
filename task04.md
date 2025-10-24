# Problem 4 — Count Substrings of Length 2

## Description
Write a method `countSubstringsLength2` that takes a string `inputString` and returns the total number of substrings of length exactly 2 that can be formed from the input string.

## Constraints and edge cases
- If `inputString` is `null` or its length is less than 2, return `0`.

## Examples

| Input     | Substrings                    | Output | Explanation                                    |
|-----------|-------------------------------|--------|------------------------------------------------|
| "hello"   | "he", "el", "ll", "lo"        | 4      | A string of length N has N−1 overlapping substrings of length 2 (5 − 1 = 4). |
| "abc"     | "ab", "bc"                    | 2      | 3 − 1 = 2                                     |
| "a"       | —                             | 0      | Length is less than 2                         |
| ""        | —                             | 0      | Empty string                                  |

## Function Signature (Java)
```java
public static int countSubstringsLength2(String inputString)
```
