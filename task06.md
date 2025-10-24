# Problem 6: Longest String in Array

## Description
Write a method, `findLongestString`, that takes an array of strings and returns the string that has the greatest length. If there are multiple strings with the same maximum length, the method should return the one that appears first in the array.

## Constraints and Edge Cases
- Length comparison must be based on the number of characters
- If the input array is null or empty, return an empty string `""`

## Examples

| Input (stringArray) | Output | Explanation |
|---------------------|--------|-------------|
| ["1","1234","45","123456789","8","99","666","55555","2228"] | "123456789" | "123456789" has a length of 9, which is the maximum length in the array. |
| ["cat", "dogs", "bird", "fish"] | "dogs" | "dogs", "bird", and "fish" all have length 4. "dogs" is returned because it appears first. |
| [] | "" | Empty array constraint. |

### Function Signature (Java)
```java
public static String findLongestString(String[] stringArray)
```
