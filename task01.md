# Problem: Vowel Checker

## Description
Write a function, `isVowel`, that takes a single string input, `charInput`, and determines if it represents a vowel character. Vowel characters are 'a', 'e', 'i', 'o', and 'u' (both uppercase and lowercase). The function should return a boolean value.

## Constraints and Edge Cases
- The input must be a string.

| Constraint       | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| Input Length     | If the length of the input string is not exactly 1, the function must immediately return False. |
| Case Sensitivity  | The check must be case-insensitive.                                        |

## Examples

| Input (charInput) | Output | Explanation                          |
|-------------------|--------|-------------------------------------|
| "a"               | True   | 'a' is a lowercase vowel.          |
| "E"               | True   | 'E' is an uppercase vowel.         |
| "b"               | False  | 'b' is a consonant.                |
| "Z"               | False  | 'Z' is a consonant.                |
| ""                | False  | Length is 0 (violates length constraint). |
| "ae"              | False  | Length is 2 (violates length constraint). |

## Function Signature (Java)
```java
public static boolean isVowel(String charInput)
```
