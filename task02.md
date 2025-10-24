# Problem: Vowel Counter

## Description

Write a method, `countVowels`, to return the total number of vowels found in a given input string. Vowels are 'a', 'e', 'i', 'o', and 'u' (both uppercase and lowercase).

## Constraints and Edge Cases

- The check must be case-insensitive.
- If the input string is null or empty (""), return 0.

## Examples

| Input (inputString) | Output | Explanation                     |
|----------------------|--------|---------------------------------|
| "hello"              | 2      | Contains 'e' and 'o'.          |
| "Education"          | 5      | Contains 'E', 'u', 'a', 'i', 'o'. |
| ""                   | 0      | Empty string constraint.        |
| "rhythm"             | 0      | Contains no vowels.            |

## Function Signature (Java)

```java
public static int countVowels(String inputString)
```
