# Remove Character at Specific Index

## Description

Write a method, `removeCharAtIndex`, that takes an input string and an integer index, and returns a new string with the character at the specified index removed.

## Constraints and Edge Cases

- The input string is case-sensitive (removal is based on position, not value).
- If the input string is null or empty (`""`), return an empty string `""`.
- If the `indexToRemove` is less than 0 or greater than or equal to the length of the string, the original string should be returned unmodified.

## Examples

| Input (inputString, indexToRemove) | Output | Explanation                                      |
|-------------------------------------|--------|--------------------------------------------------|
| ("hello", 2)                       | "helo" | Character 'l' at index 2 is removed.            |
| ("Java", 0)                        | "ava"  | Character 'J' at index 0 is removed.            |
| ("hello", 10)                      | "hello" | Index 10 is out of bounds, so the original string is returned. |
| ("", 5)                            | ""     | Empty string constraint.                          |

## Function Signature (Java)

```java
public static String removeCharAtIndex(String inputString, int indexToRemove)
```
